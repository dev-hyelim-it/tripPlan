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

INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('frog', 'froggy', 'frog@naver.com', 'froggg', 'frogfrog');
INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('ant', 'antty', 'ant@naver.com', 'anttt', 'antant');

INSERT INTO post (likes, post_date, user_no, post_title, post_content) VALUES (100, '2024-07-23', 1, '부산 조아', '부산 개조음');
INSERT INTO post (likes, post_date, user_no, post_title, post_content) VALUES (159, '2024-08-11', 2, '여수 조아', '여수 개조음');

INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-07-21', '2024-07-19', 1, '호캉스', '부산')

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (1, '더 리센츠 동대문 호텔', '서울특별시 동대문구 천호대로 383  (장안동)', '3성', '02-3390-7000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (2, '에이큐브 호텔 동대문', '서울특별시 중구 동호로35길 5 석광빌딩 (을지로5가)', '3성', '02-2264-2888', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (3, '라까사 호텔', '서울특별시 강남구 도산대로1길 83  (신사동)', '3성', '02-6711-9310', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (4, '레이어스 호텔 하단', '부산광역시 사하구 낙동남로 1395  (하단동)', '4성', '051-999-1700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (5, '사보이 호텔', '서울특별시 중구 명동8나길 10  (충무로1가)', '3성', '02-772-7700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (6, '안동 씨엠파크 호텔', '경상북도 안동시 풍천면 검무로 10-17  ', '3성', '054-853-7800', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (7, '콘래드 서울 호텔', '서울특별시 영등포구 국제금융로 10  (여의도동)', '5성', '02-6137-7000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (8, '호텔 인터불고 원주', '강원도 원주시 동부순환로 200  (반곡동)', '4성', '033-769-8114', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (9, '베스트웨스턴 프리미어 인천 에어포트 호텔', '인천광역시 중구 공항로424번길 48-27  (운서동)', '4성', '032-743-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (10, '호텔국도', '서울특별시 중구 을지로 164  (을지로4가)', '3성', '02-6466-1234', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (11, '호텔 디 아티스트', '서울특별시 강남구 테헤란로29길 11  (역삼동)', '2성', '02-569-4920', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (12, '농심 호텔', '부산광역시 동래구 금강공원로20번길 23  (온천동)', '5성', '051-550-2100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (13, '영등포 샤또호텔', '서울특별시 영등포구 선유로 100  (양평동1가)', '2성', '02-2675-2016', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (14, '토요코인 인천부평점', '인천광역시 부평구 광장로 10  (부평동)', '2성', '032-527-1045', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (15, '프린스행복호텔', '전라남도 강진군 강진읍 보은로 113-1 프린스행복호텔 ', '2성', '061-433-7300', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (16, '나인트리 프리미어호텔 명동 2', '서울특별시 중구 마른내로 28 (초동)', '4성', '02-6967-0999', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (17, 'CS 프리미어 관광호텔', '경기도 안양시 만안구 경수대로 1180  (안양동)', '2성', '031-478-0100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (18, '노바루스 관광 호텔', '서울특별시 영등포구 선유로 88-6 노바루스관관호텔 (양평동1가)', '1성', '02-2671-5757', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (19, '신라스테이 구로', '서울특별시 동작구 시흥대로 596  (신대방동)', '3성', '02-2162-9102', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (20, '메리어트 이그제큐티브 아파트먼트 서울', '서울특별시 영등포구 여의대로 8  (여의도동)', '5성', '02-2090-8000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (21, '토요코인 울산 삼산동', '울산광역시 남구 삼산로 308  (삼산동)', '2성', '052-257-1045', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (22, '스탠포드 호텔 부산', '부산광역시 중구 구덕로 53  (남포동5가)', '3성', '051-795-7700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (23, '신라스테이 광화문', '서울특별시 종로구 삼봉로 71  (수송동)', '3성', '02-6060-9000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (24, '신라스테이 마포', '서울특별시 마포구 마포대로 83  (도화동)', '3성', '02-6979-9000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (25, '신라스테이 울산', '울산광역시 남구 삼산로 200  (달동)', '3성', '052-900-9100', '호캉스');

INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (1, '(구)강경노동조합', '충청남도 논산시 강경읍 염천리', '역사관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (2, '(구)한일은행강경지점', '충청남도 논산시 강경읍 서창리', '역사관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (3, '1100고지습지', '제주특별자치도 서귀포시 색달동 산 1-2(색달동) 인근', '자연관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (4, '168계단', '부산광역시 동구 영초길191번길 10-2', '체험관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (5, '1913송정역시장', '광주광역시 광산구 송정로8번길 13', '쇼핑');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (6, '2018평창동계올림픽대회및동계패럴림픽대회기념관', '강원특별자치도 평창군 대관령면 올림픽로 220', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (7, '2·28민주운동기념회관', '대구광역시 중구 2·28길 9', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (8, '365세이프타운', '강원특별자치도 태백시 평화길 15 안전체험', '체험관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (9, '3D과학체험관', '경상남도 양산시 웅상대로 1009-1 과학체험관', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (10, '40계단문화관광테마거리', '부산광역시 중구 중앙동4가', '체험관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (11, '4560디자인하우스', '서울특별시 서초구 매헌로 16(양재동)', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (12, '4est수목원', '전라남도 해남군 현산면 황산리 산1-33', '자연관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (13, '5.16도로숲터널', '제주특별자치도 서귀포시 남원읍 신례리', '건축/조형물');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (14, '5·18기념공원', '광주광역시 서구 상무민주로 61', '휴양관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (15, '5·18민주화운동기록관', '광주광역시 동구 금남로 221', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (16, '6.25전쟁체험전시관', '강원특별자치도 고성군 현내면 통일전망대로 453 6.25전쟁체험전시관', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (17, '88공원', '강원특별자치도 화천군 간동면 어룡동길 42-96', '휴양관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (18, '9.81파크', '제주특별자치도 제주시 애월읍 천덕로 880-24', '육상 레포츠');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (19, 'BIFF광장', '부산광역시 중구 비프광장로 36', '체험관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (20, 'CECO창원컨벤션센터', '경상남도 창원시 성산구 원이대로 362 창원컨벤션센터', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (21, 'CICA미술관', '경기도 김포시 양촌읍 삼도로 196-30', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (22, 'C아트뮤지엄(숲속의미술공원)', '경기도 양평군 양동면 다락근이길 57-13', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (23, 'DMZ생태평화공원', '강원특별자치도 철원군 김화읍 생창길 481-1(김화읍)', '역사관광지');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (24, 'GS칼텍스예울마루', '전라남도 여수시 예울마루로 100', '문화시설');
INSERT INTO attraction (attraction_id, attraction_name, attraction_location, keyword) VALUES (25, 'JFK대천워터파크', '충청남도 보령시 대해로 876', '휴양관광지');

