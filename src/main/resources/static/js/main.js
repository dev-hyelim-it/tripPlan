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
        const marker = new kakao.maps.Marker({
            position: markerPosition
        });
        marker.setMap(map); // 지도에 마커 추가
    });
}

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
            <div>
                <h3>${place.place_name}</h3>
                <p>${place.address_name}</p>
                <button onclick="addToMyList('${place.place_name}', '${place.address_name}')">여행 추가</button>
            </div>
        `);

        kakao.maps.event.addListener(marker, 'click', function() {
            displayInfoWindow(map, marker, place);
        });
    });
}