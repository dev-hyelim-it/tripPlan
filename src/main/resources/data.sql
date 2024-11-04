INSERT INTO keyword (keyword) VALUES ('숙박');
INSERT INTO keyword (keyword) VALUES ('맛집');
INSERT INTO keyword (keyword) VALUES ('자연');
INSERT INTO keyword (keyword) VALUES ('역사');
INSERT INTO keyword (keyword) VALUES ('체험');
INSERT INTO keyword (keyword) VALUES ('쇼핑');
INSERT INTO keyword (keyword) VALUES ('문화');

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