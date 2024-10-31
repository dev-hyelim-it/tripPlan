INSERT INTO keyword (keyword) VALUES ('숙박');
INSERT INTO keyword (keyword) VALUES ('맛집');
INSERT INTO keyword (keyword) VALUES ('자연');
INSERT INTO keyword (keyword) VALUES ('역사');
INSERT INTO keyword (keyword) VALUES ('체험');
INSERT INTO keyword (keyword) VALUES ('쇼핑');
INSERT INTO keyword (keyword) VALUES ('문화');

INSERT INTO area (area) VALUES ('서울특별시');
INSERT INTO area (area) VALUES ('부산광역시');
INSERT INTO area (area) VALUES ('대구광역시');
INSERT INTO area (area) VALUES ('인천광역시');
INSERT INTO area (area) VALUES ('광주광역시');
INSERT INTO area (area) VALUES ('대전광역시');
INSERT INTO area (area) VALUES ('울산광역시');
INSERT INTO area (area) VALUES ('세종특별자치시');
INSERT INTO area (area) VALUES ('경기도');
INSERT INTO area (area) VALUES ('강원특별자치도');
INSERT INTO area (area) VALUES ('충청북도');
INSERT INTO area (area) VALUES ('충청남도');
INSERT INTO area (area) VALUES ('전북특별자치도');
INSERT INTO area (area) VALUES ('전라남도');
INSERT INTO area (area) VALUES ('경상북도');
INSERT INTO area (area) VALUES ('경상남도');
INSERT INTO area (area) VALUES ('제주특별자치도');


INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password, result_type) VALUES ('frog', 'froggy', 'frog@naver.com', 'froggg', 'frogfrog', 'HN');
INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password, result_type) VALUES ('ant', 'antty', 'ant@naver.com', 'anttt', 'antant', 'AC');
--INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('1111', '1111', '1111@naver.com', '1111', '1111');
INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('admin', 'admin', 'admin@naver.com', 'admin', 'admin1111');
INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('1111', '1111', '1111@naver.com', '1111', '1111');
--INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('admin', 'admin', 'admin@naver.com', 'admin', 'admin1111');

INSERT INTO post (likes, post_date, user_no, post_title, post_content)
VALUES (100, '2024-07-23', 1, '부산 조아', '부산 개조음');

INSERT INTO post_keyword (post_id, keyword_id)
VALUES (
    (SELECT post_id FROM post WHERE post_title = '부산 조아'),
    (SELECT keyword_id FROM keyword WHERE keyword = '맛집')
);

INSERT INTO post (likes, post_date, user_no, post_title, post_content)
VALUES (159, '2024-08-11', 2, '여수 조아', '여수 개조음');

INSERT INTO post_keyword (post_id, keyword_id)
VALUES (
    (SELECT post_id FROM post WHERE post_title = '여수 조아'),
    (SELECT keyword_id FROM keyword WHERE keyword = '문화')
);

--INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (1, '재밌었겠다ㅜㅜ', 'antty');
--INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (2, '우와! 대박', 'froggy');

--INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-07-21', '2024-07-19', 1, '호캉스', '부산');
--INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-09-30', '2024-10-01', 1, '맛집투어', '전주');
--INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-11-01', '2024-11-09', 2, '힐링', '제주');
--
--INSERT INTO my_list (list_id, place_name, place_address) VALUES (1, '부산 해운대', '부산 해운대구 우동');
--INSERT INTO my_list (list_id, place_name, place_address) VALUES (2, '제주도 성산일출봉', '제주 서귀포시 성산읍');
--INSERT INTO my_list (list_id, place_name, place_address) VALUES (3, '서울 경복궁', '서울 종로구 사직로 161');

INSERT INTO post (likes, post_date, user_no, post_title, post_content) VALUES (60, '2024-09-15', 3, '목포 조아', '목포 개조음');
INSERT INTO post_keyword (post_id, keyword_id)
VALUES (
    (SELECT post_id FROM post WHERE post_title = '목포 조아'),
    (SELECT keyword_id FROM keyword WHERE keyword = '문화')
);

INSERT INTO suggestion (suggestion_id, suggestion_title, user_no, suggestion_content, suggestion_date) VALUES (1, '관리자님 오류 있어여', 1, '그 뭐냐 그... 그거 있잖아', '2024-08-11');
INSERT INTO suggestion (suggestion_id, suggestion_title, user_no, suggestion_content, suggestion_date) VALUES (2, '관리자님 점심 뭐 드세여', 2, '뭐 먹냐고', '2024-07-23');


INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (1, '재밌었겠다ㅜㅜ', 'antty');
--INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (2, '우와! 대박', 'froggy');
--INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (1, '재밌었겠다ㅜㅜ', 'antty');
--INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (2, '우와! 대박', 'froggy');

--
--INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-07-21', '2024-07-19', 1, '호캉스', '부산');
--INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-09-30', '2024-10-01', 1, '맛집투어', '전주');
--INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-11-01', '2024-11-09', 2, '힐링', '제주');

INSERT INTO mbti_question (question_text, question_type) VALUES
('연차로 놀러갈 당신. 어디로 놀러가시겠습니까?', '자연 vs 도시'),
('여행을 가기 전 당신! 당신의 여행 키워드는?', '힐링 vs 액티비티'),
('밥 먹을 당신! 뭘 드시겠습니까?', '자연 vs 도시'),
('밥을 다 먹은 당신! 소화하러 산책 가시겠습니까, 카페 가시겠습니까?', '힐링 vs 액티비티'),
('일정에 공백이 생겼다! 뭘 하시겠습니까?', '자연 vs 도시'),
('여행을 다녀온 당신. 기억에 남는 나의 모습은?', '힐링 vs 액티비티');


-- 질문 1: 연차로 놀러갈 당신. 어디로 놀러가시겠습니까? (자연 vs 도시)
INSERT INTO answer_options (option_text, option_type, question_id) VALUES
('나무가 많은 자연으로', 'NATURE', 1),
('사람이 많은 도시로', 'CITY', 1);

-- 질문 2: 여행을 가기 전 당신! 당신의 여행 키워드는? (힐링 vs 액티비티)
INSERT INTO answer_options (option_text, option_type, question_id) VALUES
('힐링', 'HEALING', 2),
('액티비티', 'ACTIVITY', 2);

-- 질문 3: 밥 먹을 당신! 뭘 드시겠습니까? (자연 vs 도시)
INSERT INTO answer_options (option_text, option_type, question_id) VALUES
('바베큐', 'NATURE', 3),
('배달 음식', 'CITY', 3);

-- 질문 4: 밥을 다 먹은 당신! 이제 뭐하시겠습니까? (힐링 vs 액티비티)
INSERT INTO answer_options (option_text, option_type, question_id) VALUES
('카페', 'HEALING', 4),
('산책', 'ACTIVITY', 4);

-- 질문 5: 일정에 공백이 생겼다! 뭘 하시겠습니까? (자연 vs 도시)
INSERT INTO answer_options (option_text, option_type, question_id) VALUES
('바다 보러 갈래', 'NATURE', 5),
('클럽 갈래', 'CITY', 5);

-- 질문 6: 여행을 다녀온 당신. 기억에 남는 나의 모습은? (힐링 vs 액티비티)
INSERT INTO answer_options (option_text, option_type, question_id) VALUES
('자연을 바라보며 마음의 안정을 갖는 나', 'HEALING', 6),
('각종 체험활동을 즐기는 나', 'ACTIVITY', 6);


-- User 1의 답변 데이터
--INSERT INTO users_mbti_answer (user_no, question_id, option_id) VALUES
--(1, 1, 1),  -- 질문 1에 대한 답변 (나무가 많은 자연으로)
--(1, 2, 3),  -- 질문 2에 대한 답변 (힐링)
--(1, 3, 5),  -- 질문 3에 대한 답변 (바베큐)
--(1, 4, 7),  -- 질문 4에 대한 답변 (카페)
--(1, 5, 9),  -- 질문 5에 대한 답변 (바다 보러 갈래)
--(1, 6, 11); -- 질문 6에 대한 답변 (자연을 바라보며 마음의 안정을 갖는 나)
--
---- User 2의 답변 데이터
--INSERT INTO users_mbti_answer (user_no, question_id, option_id) VALUES
--(2, 1, 2),  -- 질문 1에 대한 답변 (사람이 많은 도시로)
--(2, 2, 4),  -- 질문 2에 대한 답변 (액티비티)
--(2, 3, 6),  -- 질문 3에 대한 답변 (배달 음식)
--(2, 4, 8),  -- 질문 4에 대한 답변 (산책)
--(2, 5, 10), -- 질문 5에 대한 답변 (클럽 갈래)
--(2, 6, 12); -- 질문 6에 대한 답변 (각종 체험활동을 즐기는 나)

INSERT INTO mbti_test_result (result_title, result_type, description, recommend_area1, area_name1, area_description1, recommend_area2, area_name2, area_description2) VALUES
('당신은 HN(Healing, Nature)의 성향을 가지고 있습니다!', 'HN', '당신은 자연 속에서 마음의 평화를 찾고, 조용히 힐링하는 시간을 선호하는 여행자입니다. 일상에서 벗어나 자연 속에서 휴식을 취하며 에너지를 충전하는 것이 중요한 사람입니다.', '전라남도 완도', '청산도', '슬로시티로 지정된 섬으로, 한적하고 아름다운 풍경이 펼쳐집니다. 푸른 들판과 바다가 어우러져 있어 걷기 좋은 청산도의 슬로길을 산책하며 마음의 안정을 찾을 수 있습니다.', '강원도 인제', '곰배령', '산세가 부드럽고 자연 풍경이 빼어난 곳으로, 여름에는 녹음이 우거져 힐링 여행지로 좋습니다. 조용히 산책하거나 사진을 찍으며 자연과 함께 시간을 보낼 수 있습니다.'),
('당신은 HC(Healing, City)의 성향을 가지고 있습니다!', 'HC', '당신은 도시의 편의와 즐길 거리를 선호하면서도, 혼잡한 환경을 피해 조용히 힐링할 수 있는 시간을 원하는 여행자입니다. 자연 속에서의 힐링보다는 도시 속에서 여유로운 휴식을 즐기며 재충전하고자 합니다.', '부산', '해운대 달맞이길', '해운대 바다가 내려다보이는 한적한 산책길로, 도심에서 벗어나 조용히 힐링할 수 있습니다. 근처에 아늑한 카페들이 있어, 바다를 감상하며 여유롭게 시간을 보낼 수 있습니다.', '경기도 수원', '행궁동 카페거리', '수원 화성 근처에 위치한 조용한 카페 거리로, 개성 있는 카페들이 많아 차분한 분위기 속에서 휴식할 수 있습니다.'),
('당신은 AN(Activity, Nature)의 성향을 가지고 있습니다!', 'AN', '당신은 자연을 사랑하고, 그 속에서 다양한 활동을 통해 에너지를 얻는 사람입니다. 한적하게 쉬기보다는 자연 속에서 몸을 움직이며 신나는 경험을 하는 것을 좋아합니다.', '제주도', '곽지과물해변 스노클링', '맑은 물과 함께 해양 생물을 관찰할 수 있어 스노클링을 즐기기에 적합한 장소입니다.', '충청북도 단양', '패러글라이딩', '단양은 패러글라이딩 명소로도 유명하여 하늘을 날며 아름다운 단양의 산과 강을 내려다볼 수 있습니다.'),
('당신은 AC(Activity, City)의 성향을 가지고 있습니다!', 'AC', '당신은 도시의 다양한 체험과 활동적인 경험을 선호하는 여행자입니다. 도심 속에서 색다른 경험과 즐길 거리를 찾으며 에너지를 얻고, 새로운 공간과 문화에 적극적으로 참여하는 스타일입니다.', '부산', '서면', '부산의 대표적인 상업 지구로, 쇼핑과 맛집 투어를 즐길 수 있습니다. 실내 클라이밍과 VR 체험 같은 실내 액티비티도 다수 있어 활발한 도시 경험을 즐기기에 좋습니다.', '전주', '전주 한옥마을과 객사길', '전통 한옥이 줄지어 있는 골목을 산책하며 다양한 먹거리와 체험 거리를 즐길 수 있습니다. 길거리 음식과 한옥 카페 투어는 전주의 대표적인 즐길 거리입니다.');


--INSERT INTO travel (accommodation_id, travel_id) VALUES (1, 1);
--INSERT INTO travel (accommodation_id, travel_id) VALUES (1, 1);
INSERT INTO travel_accommodation (travel_acc_id, travel_id, accommodation_id) VALUES (1, 1, null);
INSERT INTO travel_accommodation (travel_acc_id, travel_id, accommodation_id) VALUES (2, 1, null);
INSERT INTO travel_accommodation (travel_acc_id, travel_id, accommodation_id) VALUES (3, 2, null);

--attraction, accommodation, restaurant 데이터
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (1, '(구)강경노동조합', '서울특별시 서초구 매헌로 16(양재동)', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (2, '4560디자인하우스', '서울특별시 서초구 매헌로 16(양재동)', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (3, 'KBS온', '서울특별시 영등포구 여의공원로 13 한국방송공사 본관', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (4, 'KT&G상상마당(홍대)', '서울특별시 마포구 어울마당로 65 상상마당빌딩', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (5, 'K현대미술관', '서울특별시 강남구 선릉로 807 K현대미술관', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (6, 'M컨템포러리', '서울특별시 강남구 봉은사로 120 1F', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (7, 'SJ쿤스트할레', '서울특별시 강남구 언주로148길 5', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (8, '가락시장(가락농수산물도매시장)', '서울특별시 송파구 양재대로 932', '쇼핑');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (9, '가리봉시장', '서울특별시 구로구 우마3길 19', '쇼핑');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (10, '가회민화박물관', '서울특별시 종로구 북촌로 52', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (11, '168계단', '부산광역시 동구 영초길191번길 10-2', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (12, '40계단문화관광테마거리', '부산광역시 중구 중앙동4가', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (13, 'KT&G상상마당부산', '부산광역시 부산진구 서면로 39', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (14, 'SEALIFE부산아쿠아리움', '부산광역시 해운대구 해운대해변로 266', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (15, 'BIFF광장', '부산광역시 중구 비프광장로 36', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (16, '가덕도대항인공동굴', '부산광역시 강서구 대항동 393-9((대항동))', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (17, '가덕도등대', '부산광역시 강서구 외양포로 10', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (18, '가덕도연대봉', '부산광역시 강서구 천성동', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (19, '가야공원/가야산책공원', '부산광역시 부산진구 가야동 669-11', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (20, '가포수변공원', '부산광역시 마산합포구 가포본동7길 11-13', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (21, 'CICA미술관', '경기도 김포시 양촌읍 삼도로 196-30', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (22, 'C아트뮤지엄(숲속의미술공원)', '경기도 양평군 양동면 다락근이길 57-13', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (23, '가나아트파크', '경기도 양주시 장흥면 권율로 117', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (24, '가남체육공원', '경기도 여주시 가남읍 대명산길 98', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (25, '가리산(포천)', '경기도 포천시 이동면 도평리, 장암리', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (26, '가막들공원', '경기도 의왕시 양지편로 41-2', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (27, '가학동지석묘', '경기도 광명시 가학동 산101-2', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (28, '갈미한글공원', '경기도 의왕시 문화예술로 65', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (29, '갈산공원', '경기도 양평군 양평읍 양평체육공원길 24', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (30, '갈치저수지', '경기도 군포시 속달동', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (31, '1100고지습지', '제주특별자치도 서귀포시 색달동 산 1-2(색달동) 인근', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (32, '5.16도로숲터널', '제주특별자치도 서귀포시 남원읍 신례리', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (33, '9.81파크', '제주특별자치도 제주시 애월읍 천덕로 880-24', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (34, '가마오름', '제주특별자치도 제주시 한경면 청수리 1205', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (35, '가문이오름(감은이오름)', '제주특별자치도 서귀포시 표선면 가시리 산158-2', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (36, '가새기오름', '제주특별자치도 제주시 오라3동 2848', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (37, '가세오름', '제주특별자치도 서귀포시 표선면 토산리 산2', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (38, '가시오름', '제주특별자치도 서귀포시 대정읍 동일리 1706', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (39, '가파도', '제주특별자치도 서귀포시 대정읍 가파로', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (40, '각시바우오름', '제주특별자치도 서귀포시 호근동 2124', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (41, '4est수목원', '전라남도 해남군 현산면 황산리 산1-33', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (42, 'GS칼텍스예울마루', '전라남도 여수시 예울마루로 100', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (43, '가거도(소흑산도)', '전라남도 신안군 흑산면 가거도리 582-12', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (44, '가계해변', '전라남도 진도군 고군면 금계리 153', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (45, '가마골생태공원', '전라남도 담양군 용면 용소길 261', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (46, '가마미해수욕장', '전라남도 영광군 홍농읍 가마미로 341-6', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (47, '가사도', '전라남도 진도군 조도면 가사도리', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (48, '가사동백숲해변', '전라남도 완도군 약산면 가사길', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (49, '가야금산조테마공원', '전라남도 영암군 영암읍 기찬랜드로 19-10', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (50, '가우도', '전라남도 강진군 도암면 월곶로 473(도암면)', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (51, '3D과학체험관', '경상남도 양산시 웅상대로 1009-1 과학체험관', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (52, 'CECO창원컨벤션센터', '경상남도 창원시 성산구 원이대로 362 창원컨벤션센터', '문화');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (53, '가라산', '경상남도 거제시 남부면 다대리(남부면)', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (54, '가야랜드', '경상남도 김해시 인제로 368 가야랜드', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (55, '가야의거리', '경상남도 김해시 봉황동', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (56, '가야진사', '경상남도 양산시 원동면 용당들길 43-62', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (57, '가조도', '경상남도 거제시 사등면 가조로 1298', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (58, '가조백두산천지온천', '경상남도 거창군 가조면 온천길 161 백두산천지온천', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (59, '가음정시장', '경상남도 창원시 성산구 가음동 21-42', '쇼핑');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (60, '각산', '경상남도 사천시 실안동 산2', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (61, '(구)강경노동조합', '충청남도 논산시 강경읍 염천리', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (62, '(구)한일은행강경지점', '충청남도 논산시 강경읍 서창리', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (63, 'JFK대천워터파크', '충청남도 보령시 대해로 876', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (64, '가야산(서산)', '충청남도 서산시 해미면 산수리', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (65, '가의도', '충청남도 태안군 근흥면 가의도리', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (66, '각원사', '충청남도 천안시 동남구 각원사길 245(안서동)', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (67, '간곡서원', '충청남도 부여군 임천면 성흥로283번길 31-4', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (68, '갈목해변', '충청남도 서천군 마서면 송석리', '자연');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (69, '개덕사', '충청남도 금산군 추부면 개덕사길 83', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (70, '개심사(서산)', '충청남도 서산시 운산면 개심사로 321-86', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (71, '가경터미널시장', '충청북도 청주시 흥덕구 가경동 1438', '쇼핑');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (72, '가산사', '충청북도 옥천군 안내면 안내회남로 671', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (73, '가섭사', '충청북도 음성군 음성읍 가섭길 494', '역사');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (74, '각연사(괴산)', '충청북도 괴산군 칠성면 태성리', '역사');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (1, '더 리센츠 동대문 호텔', '서울특별시 동대문구 천호대로 383 (장안동)', '3성', '02-3390-7000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (2, '에이큐브 호텔 동대문', '서울특별시 중구 동호로35길 5 석광빌딩 (을지로5가)', '3성', '02-2264-2888', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (3, '라까사 호텔', '서울특별시 강남구 도산대로1길 83 (신사동)', '3성', '02-6711-9310', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (4, '레이어스 호텔 하단', '부산광역시 사하구 낙동남로 1395 (하단동)', '4성', '051-999-1700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (5, '사보이 호텔', '서울특별시 중구 명동8나길 10 (충무로1가)', '3성', '02-772-7700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (6, '안동 씨엠파크 호텔', '경상북도 안동시 풍천면 검무로 10-17 ', '3성', '054-853-7800', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (7, '콘래드 서울 호텔', '서울특별시 영등포구 국제금융로 10 (여의도동)', '5성', '02-6137-7000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (8, '호텔 인터불고 원주', '강원도 원주시 동부순환로 200 (반곡동)', '4성', '033-769-8114', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (9, '베스트웨스턴 프리미어 인천 에어포트 호텔', '인천광역시 중구 공항로424번길 48-27 (운서동)', '4성', '032-743-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (10, '호텔국도', '서울특별시 중구 을지로 164 (을지로4가)', '3성', '02-6466-1234', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (11, '호텔 디 아티스트', '서울특별시 강남구 테헤란로29길 11 (역삼동)', '2성', '02-569-4920', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (12, '농심 호텔', '부산광역시 동래구 금강공원로20번길 23 (온천동)', '5성', '051-550-2100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (13, '영등포 샤또호텔', '서울특별시 영등포구 선유로 100 (양평동1가)', '2성', '02-2675-2016', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (14, '토요코인 인천부평점', '인천광역시 부평구 광장로 10 (부평동)', '2성', '032-527-1045', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (15, '프린스행복호텔', '전라남도 강진군 강진읍 보은로 113-1 프린스행복호텔 ', '2성', '061-433-7300', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (16, '나인트리 프리미어호텔 명동 2', '서울특별시 중구 마른내로 28 (초동)', '4성', '02-6967-0999', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (17, 'CS 프리미어 관광호텔', '경기도 안양시 만안구 경수대로 1180 (안양동)', '2성', '031-478-0100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (18, '노바루스 관광 호텔', '서울특별시 영등포구 선유로 88-6 노바루스관관호텔 (양평동1가)', '1성', '02-2671-5757', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (19, '신라스테이 구로', '서울특별시 동작구 시흥대로 596 (신대방동)', '3성', '02-2162-9102', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (20, '메리어트 이그제큐티브 아파트먼트 서울', '서울특별시 영등포구 여의대로 8 (여의도동)', '5성', '02-2090-8000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (21, '토요코인 울산 삼산동', '울산광역시 남구 삼산로 308 (삼산동)', '2성', '052-257-1045', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (22, '스탠포드 호텔 부산', '부산광역시 중구 구덕로 53 (남포동5가)', '3성', '051-795-7700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (23, '신라스테이 광화문', '서울특별시 종로구 삼봉로 71 (수송동)', '3성', '02-6060-9000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (24, '신라스테이 마포', '서울특별시 마포구 마포대로 83 (도화동)', '3성', '02-6979-9000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (25, '신라스테이 울산', '울산광역시 남구 삼산로 200 (달동)', '3성', '052-900-9100', '호캉스');

INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (63, '하연옥 본점', '경남 진주시 진주대로 1317-20', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (64, '대동 할매국수', '경남 김해시 동남로45번길 8', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (65, '소토', '경남 양산시 상북면 충렬로 617', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (66, '하주옥', '경남 사천시 하동길 8-11', '맛집');


INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (67, '환여 횟집', '경북 포항시 북구 해안로 189-1', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (68, '함양집 경주보문점', '경북 경주시 북군1길 10-1', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (69, '맷돌 순두부', '경북 경주시 북군길 7', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (70, '향화정', '경북 경주시 사정로57번길 17', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (71, '함양집 보불로점', '경북 경주시 보불로 287', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (72, '용궁 단골 식당 본점', '경북 예천군 용궁시장길 30', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (73, '군위 이로운 한우', '경북 군위군 간동유원지길 14', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (74, '마라도 회식당', '경북 포항시 북구 해안로 217-1', '맛집');



INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (75, '우렁이 박사', '충남 당진시 샛터로 7-1', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (76, '박순자 아우내 순대', '충남 천안시 동남구 아우내순대길 47', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (77, '딴뚝 통나무집 식당', '충남 태안군 조운막터길 23-22', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (78, '소복갈비', '충남 예산군 천변로195번길 9', '맛집');

INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (79, '대산 보리밥', '충북 청주시 서원구 2순환로 1461-1', '맛집');


INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (80, '태평소국밥 본관', '대전 유성구 온천동로65번길 50', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (81, '오문창 순대국밥', '대전 대덕구 한밭대로 1153', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (82, '수통골 감나무집 본점', '대전 유성구 수통골로 69', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (83, '오씨 칼국수', '대전 동구 옛신탄진로 13-0', '맛집');

INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (84, '선녀풍 본점', '인천 중구 용유서로 272', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (85, '벌말 매운탕 본점', '인천 계양구 벌말로565번길 5', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (86, '동해 막국수', '인천 중구 용유서로479번길 16', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (87, '해송 쌈밥', '인천 중구 공항서로 177', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (88, '우판등심 인천점', '인천 연수구 청량로 61', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (89, '황해 해물 칼국수 1호점', '인천 중구 용유로21번길 3', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (90, '황해 해물 칼국수 2호점', '인천 중구 마시란로 37', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (91, '송도갈비 본점', '인천 연수구 능허대로 16', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (92, '외길수산 상동점', '인천 부평구 길주로77번길 19-45', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (93, '맛을담은 강된장', '인천 강화군 해안남로 1164', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (94, '언양 기와집 불고기', '울산 울주군 헌양길 86', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (95, '나사리 식당', '울산 울주군 나사해안길 15', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (96, '대덕 식당', '대구 남구 앞산순환로 443', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (97, '산장가든', '세종 연서면 도신고복로 1131-7', '맛집');