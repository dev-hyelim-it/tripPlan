let mapContainer = document.getElementById('map'), // 지도를 표시할 div
            mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };

        // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
        let map = new kakao.maps.Map(mapContainer, mapOption);

// 키워드 지역 버튼 설정 영역
let allAreas = [];
        let isAllAreasVisible = false;
        let selectedKeyword = ''; // 수정
        let selectedArea = ''; // 수정

        window.onload = () => {
            // 오늘 날짜 설정
            const today = new Date().toISOString().split('T')[0];

            // 떠날 날짜와 도착 날짜의 min 속성을 오늘로 설정
            document.getElementById('departureDate').min = today;
            document.getElementById('arrivalDate').min = today;

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
                    displayAreas(allAreas.slice(0, 2)); // 처음 2개만 보여줌
                });
        }

        function createButton(text, onClick, buttonClass) {
            const button = document.createElement('button');
            button.innerText = text;
            button.type = 'button';
            button.className = `my-button ${buttonClass}`;

            button.onclick = () => {
                onClick(text, button);
            };

            return button;
        }

        function displayAreas(areas) {
            const areaButtons = document.getElementById('areaButtons');
            areaButtons.innerHTML = ''; // 기존 버튼을 지우고 새로 표시

            areas.forEach((area) => {
                const button = createButton(area, selectArea, 'area-button');
                areaButtons.appendChild(button);

                // 선택된 지역이면 색상 유지
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
                displayAreas(allAreas); // 모든 지역 표시
                this.innerText = '▲ 접기';
                isAllAreasVisible = true;
            } else {
                displayAreas(allAreas.slice(0, 2)); // 처음 2개만 다시 표시
                this.innerText = '▼ 더 보기';
                isAllAreasVisible = false;

                // 선택된 지역의 버튼 색상 유지
                if (selectedArea) {
                    const button = Array.from(document.querySelectorAll('#areaButtons .my-button'))
                        .find(btn => btn.innerText === selectedArea);
                    if (button) {
                        button.classList.add('active'); // 선택된 버튼 색상 유지
                    }
                }
            }
        };

        function selectKeyword(keyword, button) {
            // 이미 선택된 키워드가 있으면 해제
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
            // 이미 선택된 지역이 있으면 해제
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
            let messages = []; // 경고 메시지를 저장할 배열

            // 키워드 확인
            if (!selectedKeyword) {
                messages.push("키워드를 선택해주세요.");
                isValid = false; // 유효성 검사 실패
            }

            // 지역 확인
            if (!selectedArea) {
                messages.push("지역을 선택해주세요.");
                isValid = false; // 유효성 검사 실패
            }

            // 날짜 확인
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

            // 경고 메시지가 있을 경우 표시
            if (!isValid) {
                alert(messages.join("\n")); // 배열을 줄바꿈으로 연결하여 출력
            }

            return isValid; // 유효성 검사 결과 반환
        }
