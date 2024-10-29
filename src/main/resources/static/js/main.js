let allAreas = [];
let isAllAreasVisible = false;
let selectedKeyword = '';
let selectedArea = '';

window.onload = () => {
    const today = new Date().toISOString().split('T')[0];
    document.getElementById('departureDate').min = today;
    document.getElementById('arrivalDate').min = today;

    // departureDate의 이벤트 리스너 추가
    document.getElementById('departureDate').addEventListener('change', function() {
        const selectedDepartureDate = this.value;
        document.getElementById('arrivalDate').min = selectedDepartureDate; // 도착 날짜의 최소값을 떠날 날짜로 설정
    });

    // 지도 초기화
//    let mapContainer = document.getElementById('map'),
//        mapOption = {
//            center: new kakao.maps.LatLng(33.450701, 126.570667),
//            level: 3
//        };
//
//    let map = new kakao.maps.Map(mapContainer, mapOption);

    loadKeywords();
    loadAreas();
};

function loadKeywords() {
    fetch('/api/keywords')
        .then(response => response.json())
        .then(data => {
            const keywordButtons = document.getElementById('keywordButtons');
            keywordButtons.innerHTML = '';

            data.forEach(keyword => {
                const button = createButton(keyword, selectKeyword, 'keyword-button');
                keywordButtons.appendChild(button);
            });
        });
}

function loadAreas() {
    fetch('/api/areas')
        .then(response => response.json())
        .then(data => {
            allAreas = data;
            displayAreas(allAreas.slice(0, 2));
        });
}

function createButton(text, onClick, buttonClass) {
    const button = document.createElement('button');
    button.innerText = text;
    button.type = 'button';
    button.className = `my-button ${buttonClass}`;
    button.onclick = () => onClick(text, button);
    return button;
}

function displayAreas(areas) {
    const areaButtons = document.getElementById('areaButtons');
    areaButtons.innerHTML = '';
    areas.forEach(area => {
        const button = createButton(area, selectArea, 'area-button');
        areaButtons.appendChild(button);
        if (selectedArea === area) {
            button.classList.add('active');
        }
    });
    updateShowMoreButton();
}

function updateShowMoreButton() {
    const showMoreButton = document.getElementById('showMoreAreas');
    showMoreButton.style.display = allAreas.length > 2 ? 'block' : 'none';
}

document.getElementById('showMoreAreas').onclick = function() {
    if (!isAllAreasVisible) {
        displayAreas(allAreas);
        this.innerText = '▲ 접기';
        isAllAreasVisible = true;
    } else {
        displayAreas(allAreas.slice(0, 2));
        this.innerText = '▼ 더 보기';
        isAllAreasVisible = false;

        if (selectedArea) {
            const button = Array.from(document.querySelectorAll('#areaButtons .my-button'))
                .find(btn => btn.innerText === selectedArea);
            if (button) {
                button.classList.add('active');
            }
        }
    }
};

function selectKeyword(keyword, button) {
    if (selectedKeyword) {
        const existingButton = Array.from(document.querySelectorAll('#keywordButtons .my-button'))
            .find(btn => btn.classList.contains('active'));
        if (existingButton) {
            existingButton.classList.remove('active');
        }
    }

    selectedKeyword = keyword;
    button.classList.add('active');
    updateSelection('keyword', keyword);
}

function selectArea(area, button) {
    if (selectedArea) {
        const existingButton = Array.from(document.querySelectorAll('#areaButtons .my-button'))
            .find(btn => btn.classList.contains('active'));
        if (existingButton) {
            existingButton.classList.remove('active');
        }
    }

    selectedArea = area;
    button.classList.add('active');
    updateSelection('area', area);
}

function updateSelection(type, value) {
    const input = document.getElementById(`hidden${capitalize(type)}`);
    input.value = value;
    document.getElementById(`selected${capitalize(type)}`).innerText = value || '선택된 항목이 없습니다.';
}

function capitalize(string) {
    return string.charAt(0).toUpperCase() + string.slice(1);
}

function validateForm() {
    let isValid = true;
    let messages = [];

    if (!selectedKeyword) {
        messages.push("키워드를 선택해주세요.");
        isValid = false;
    }

    if (!selectedArea) {
        messages.push("지역을 선택해주세요.");
        isValid = false;
    }

    const departureDate = document.getElementById('departureDate').value;
    const arrivalDate = document.getElementById('arrivalDate').value;

    if (!departureDate) {
        messages.push("떠날 날짜를 선택해주세요.");
        isValid = false;
    } else if (!arrivalDate) {
        messages.push("도착할 날짜를 선택해주세요.");
        isValid = false;
    } else if (departureDate > arrivalDate) {
        messages.push("떠날 날짜는 도착할 날짜보다 이전이어야 합니다.");
        isValid = false;
    }

    if (!isValid) {
        alert(messages.join("\n"));
    }

    return isValid;
}

// 날씨 슬라이드 관련 코드
let cities = ['Seoul', 'Daejeon', 'Incheon', 'Sokcho', 'Gangneung', 'Chuncheon', 'Gwangju', 'Ulsan', 'Busan', 'Mokpo', 'Jeju City'];
let apiKey = '{API KEY}'; // OpenWeatherMap API 키로 교체

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
