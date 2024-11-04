
// 지도 표시를 위한 div 요소
    const mapContainer = document.getElementById('map');

    // 지도 옵션 설정
    const mapOptions = {
        center: new kakao.maps.LatLng(37.566535, 126.9779692), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

    // 지도 생성
    const map = new kakao.maps.Map(mapContainer, mapOptions);

// 지도 초기화 함수
function initMap(data) {
    if (!data.documents || data.documents.length === 0) {
        alert('검색 결과가 없습니다.');
        return;
    }

    // 첫 번째 장소의 좌표를 지도 중심으로 설정
    const firstPlace = data.documents[0];
    const mapOptions = {
        center: new kakao.maps.LatLng(firstPlace.y, firstPlace.x),
        level: 3
    };
    map.setCenter(mapOptions.center); // 기존 지도 객체의 중심을 재설정

    // 마커 생성 및 지도에 표시
        data.documents.forEach(place => {
            const markerPosition = new kakao.maps.LatLng(place.y, place.x);
            const marker = new kakao.maps.Marker({ position: markerPosition });
            marker.setMap(map);

            // 마커 클릭 이벤트로 정보 창 표시
            kakao.maps.event.addListener(marker, 'click', function() {
                displayInfoWindow(map, marker, place);
            });
        });
}
// 검색 버튼과 검색창 요소
const searchBtn = document.getElementById('searchBtn');
const keywordInput = document.getElementById('keyword');

// Enter 키 눌렀을 때 검색 실행
keywordInput.addEventListener('keydown', function(event) {
    if (event.keyCode === 13) { // Enter 키 코드
        searchBtn.click(); // 검색 버튼 클릭 이벤트 실행
    }
});

// 검색 버튼 클릭 시 실행될 함수
document.getElementById('searchBtn').addEventListener('click', function() {
    const keyword = document.getElementById('keyword').value;

    fetch(`/search?keyword=${encodeURIComponent(keyword)}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('네트워크 응답이 정상적이지 않습니다: ' + response.status);
        }
        return response.json();
    })
    .then(data => {
        console.log('서버 응답 데이터:', data); // 데이터 구조 확인을 위한 로그
        if (data.documents && data.documents.length > 0) {
            initMap(data); // 지도 초기화 함수 호출
            displayPlaces(data.documents); // 장소 목록 표시 함수 호출
        } else {
            alert('검색 결과가 없습니다.');
        }
    })
    .catch(error => {
        console.error('문제가 발생했습니다:', error.message); // 오류 메시지 콘솔에 출력
        alert('검색 결과를 불러오는 중 문제가 발생했습니다.');
    });
});

// 장소 목록 표시 함수
function displayPlaces(places) {
    $('#list').css("display","block");
    const placeList = $('#list'); // HTML의 장소 목록 표시할 요소
    placeList.empty(); // 이전 검색 결과 제거

    if (places.length === 0) {
        placeList.append('<p>검색 결과가 없습니다.</p>');
        return;
    }

    places.forEach(place => {
        const coords = new kakao.maps.LatLng(place.y, place.x);
        const marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        placeList.append(`
            <div onclick="moveToLocation(${place.y}, ${place.x}, '${place.place_name}', '${place.address_name}')" data-lat="${place.y}" data-lng="${place.x}" data-place-name="${place.place_name}" data-address-name="${place.address_name}">
                <h3>${place.place_name}</h3>
                <p>${place.address_name}</p>
                <button class="addBtn" onclick="addToMyList('${place.place_name}', '${place.address_name}')">여행 추가</button>
            </div>
        `);

        kakao.maps.event.addListener(marker, 'click', function() {
            displayInfoWindow(map, marker, place);
        });
    });
}

document.addEventListener("click", (e) =>{
const documentItem = e.target.closest(".map_section");
if(documentItem) {
const {className} = e.target;
// addBtn 클릭 시 여행 목록에 장소 추가
        if (className === "addBtn") {
        }
        // 장소 목록 클릭 시 해당 위치로 지도 이동
        if (className === "place-item") {
        }
    }
});

    // 1. 리스트 클릭 시 지도 중심 이동
    function moveToLocation(lat, lng, placeName, addressName) {
        const moveLatLon = new kakao.maps.LatLng(lat, lng);
        map.panTo(moveLatLon); // 지도 중심 이동
    };

    // 2. 여행 목록 추가 함수
    function addToMyList(placeName, addressName, event) {
        const myList = document.getElementById('myList');
        const listItem = document.createElement('li');
        listItem.classList.add('my_list');
        listItem.innerHTML = `
            <p>${placeName}</p>
            <p>${addressName}</p>
        `;
        myList.appendChild(listItem);

        // 저장버튼 표시 여부
        if(myList.children.length > 0) {
        $('.save_db_btn').css("display","block");
        } else {
        $('.save_db_btn').css("display","none");
        }
    };

    // 3. 추가된 여행 목록 저장 기능
    function saveToDatabase() {
        const myListItems = document.querySelectorAll('#myList .my_list');
        // 입력된 날짜 데이터 가져오기
//        const departureDate = document.getElementById('departureDate').value;
//        const arrivalDate = document.getElementById('arrivalDate').value;

        const placeData = Array.from(myListItems).map(item => ({
            placeName: item.children[0].textContent,
            addressName: item.children[1].textContent
        }));

// 전송할 데이터에 날짜 정보 포함
    /*const requestData = [
        {
            places: placeData,
             travelDates: {
                 startDate: departureDate,
                 endDate: arrivalDate
        }
        }];*/
    console.log("전송할 데이터:", JSON.stringify(placeData));
        fetch('/saveMyList', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(placeData)  // 배열 형태로 전달
        })
        .then(response => {
            if (response.ok) {
                alert('저장되었습니다.');
                updateMyListUI(); // UI 업데이트 함수 호출
                console.log(placeData);
            } else {
                alert('저장 중 오류가 발생했습니다.');
            }
        })
        .catch(error => console.error('Error:', error));
    }

    function updateMyListUI() {
        // UI를 업데이트하는 코드
        const myListElement = document.getElementById('myList');
        myListElement.innerHTML = ''; // 리스트를 비움
        // 추가로 UI 업데이트 로직
    }


    let cities = ['Seoul', 'Daejeon', 'Incheon', 'Sokcho', 'Gangneung', 'Chuncheon', 'Gwangju', 'Ulsan', 'Busan', 'Mokpo', 'Jeju City'];
    let apiKey = '04755e2affa51884138930dc31807981'; // OpenWeatherMap API 키로 교체

    let requests = cities.map(city => {
        let weatherUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`;

        return $.ajax({
            url: weatherUrl,
            type: 'GET',
            success: function(data) {
                let temp = data.main.temp;
                let weatherDescription = data.weather[0].description;
                let icon = data.weather[0].icon;

                $('.weather-slides').append(`
                    <div class="weather-slide">
                        <h2>${city}</h2>
                        <img src="https://openweathermap.org/img/wn/${icon}.png" alt="${weatherDescription}" style="width: 50px;"/>
                        <p>${temp} °C / ${weatherDescription}</p>
                    </div>
                `);
            },
            error: function() {
                $('.weather-slides').append('<div class="weather-slide">날씨 정보를 가져오는데 실패했습니다.</div>');
            }
        });
    });

    let currentIndex = 0;

    function updateSlide() {
        let offset = -currentIndex * 100; // 현재 인덱스에 따라 오프셋 계산
        $('.weather-slides').css('transform', 'translateX(' + offset + '%)');
    }

    function startAutoSlide() {
        intervalId = setInterval(function() {
            currentIndex = (currentIndex + 1) % cities.length;
            updateSlide();
        }, 8000);
    }

    function prevSlide() {
        currentIndex = (currentIndex - 1 + cities.length) % cities.length;
        updateSlide();
    }

    function nextSlide() {
        currentIndex = (currentIndex + 1) % cities.length;
        updateSlide();
    }

    $.when(...requests).then(function() {
        updateSlide();
        startAutoSlide();
    });
