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

-- 첫 번째 포스트 삽입
INSERT INTO post (likes, post_date, user_no, post_title, post_content)
VALUES (100, '2024-07-23', 1, '부산 조아', '부산 개조음');

-- 첫 번째 포스트에 키워드 삽입 (맛집)
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

INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (1, '재밌었겠다ㅜㅜ', 'antty');
INSERT INTO comment (post_id, comment_content, comment_nickname) VALUES (2, '우와! 대박', 'froggy');

INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-07-21', '2024-07-19', 1, '호캉스', '부산');

--INSERT INTO travel (accommodation_id, travel_id) VALUES (1, 1);
--INSERT INTO travel (accommodation_id, travel_id) VALUES (1, 1);


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





INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (1, '더 리센츠 동대문 호텔', '서울특별시 동대문구 천호대로 383  (장안동)', '3성', '02-3390-7000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (2, '에이큐브 호텔 동대문', '서울특별시 중구 동호로35길 5 석광빌딩 (을지로5가)', '3성', '02-2264-2888', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (3, '라까사 호텔', '서울특별시 강남구 도산대로1길 83  (신사동)', '3성', '02-6711-9310', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (4, '사보이 호텔', '서울특별시 중구 명동8나길 10  (충무로1가)', '3성', '02-772-7700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (5, '콘래드 서울 호텔', '서울특별시 영등포구 국제금융로 10  (여의도동)', '5성', '02-6137-7000', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (6, '레이어스 호텔 하단', '부산광역시 사하구 낙동남로 1395  (하단동)', '4성', '051-999-1700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (7, '농심 호텔', '부산광역시 동래구 금강공원로20번길 23  (온천동)', '5성', '051-550-2100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (8, '스탠포드 호텔 부산', '부산광역시 중구 구덕로 53  (남포동5가)', '3성', '051-795-7700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (9, '에이치에비뉴 호텔 광안리 해변점', '부산광역시 수영구 광안해변로278번길 42 b동 9층 (민락동)', '2성', '051-751-5858', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (10, '(주)부산관광호텔', '부산광역시 중구 광복로97번길 23  (동광동2가)', '3성', '051-241-4301', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (11, '베스트웨스턴 프리미어 인천 에어포트 호텔', '인천광역시 중구 공항로424번길 48-27  (운서동)', '4성', '032-743-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (12, '토요코인 인천부평점', '인천광역시 부평구 광장로 10  (부평동)', '2성', '032-527-1045', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (13, '영종관광호텔', '인천광역시 중구 운중로21번길 8  (운남동)', '1성', '032-751-8868', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (14, '그랜드 하얏트 인천', '인천광역시 중구 영종해안남로321번길 208  (운서동)', '5성', '032-745-1234', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (15, '그랜드하얏트인천 웨스트타워', '인천광역시 중구 영종해안남로321번길 190  (운서동)', '5성', '032-745-1234', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (16, 'CS 프리미어 관광호텔', '경기도 안양시 만안구 경수대로 1180  (안양동)', '2성', '031-478-0100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (17, '그린피아 호텔', '경기도 화성시 세자로 438 그린피아호텔 (안녕동)', '2성', '031-225-3366', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (18, '대부도관광호텔', '경기도 안산시 단원구 사근여길 5 대부도 마리나 호텔 (대부북동)', '2성', '032-888-3860', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (19, '송탄 메트로 관광호텔', '경기도 평택시 관광특구로 24 메트로폴관광호텔 (서정동)', '2성', '031-668-0002', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (20, '호텔 리츠', '경기도 수원시 팔달구 권광로134번길 44-11  (인계동)', '3성', '031-224-1100', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (21, '베니키아 호텔 대림', '대전광역시 중구 대종로505번길 50  (선화동)', '2성', '042-251-9500', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (22, '디엠프레스 호텔', '대전광역시 서구 한밭대로570번길 29-20  (월평동)', '2성', '042-485-3030', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (23, '베니키아 테크노밸리 호텔', '대전광역시 유성구 테크노중앙로 57  (관평동)', '3성', '042-671-0500', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (24, '선샤인 호텔 대전', '대전광역시 동구 동서대로 1700 호텔선샤인 (가양동)', '2성', '042-620-6500', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (25, '호텔 오노마 오토그래프 컬렉션', '대전광역시 유성구 엑스포로 1  (도룡동)', '5성', '042-259-8007', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (26, '호텔 인터불고 원주', '강원도 원주시 동부순환로 200  (반곡동)', '4성', '033-769-8114', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (27, '인제스피디움', '강원도 인제군 기린면 상하답로 130  ', '4성', '033-1644-3366', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (28, '비발디파크', '강원도 홍천군 서면 한치골길 262  ', '4성', '033-439-7763', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (29, '더케이호텔앤리조트(주) 더케이설악산가족호텔', '강원도 속초시 설악산로 470-7  (도문동)', '3성', '033-639-8100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (30, '세이지우드 호텔 홍천', '강원도 홍천군 두촌면 광석로 898-87 2/2 ', '5성', '033-430-1600', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (31, 'L7 강남 바이 롯데', '서울특별시 강남구 테헤란로 415 L7 강남 (삼성동)', '4성', '02-2011-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (32, '조선 팰리스 서울 강남, 럭셔리 컬렉션 호텔', '서울특별시 강남구 테헤란로 231  (역삼동)', '5성', '02-727-7200', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (33, '롯데시티호텔 김포공항', '서울특별시 강서구 하늘길 38  (방화동)', '3성', '02-6116-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (34, '에이치에비뉴 호텔 이대', '서울특별시 마포구 신촌로 152  (노고산동)', '2성', '02-702-4577', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (35, '호텔 DM', '서울특별시 종로구 난계로29길 73  (숭인동)', '2성', '02-2236-3144', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (36, '롯데호텔 부산', '부산광역시 부산진구 가야대로 772  (부전동)', '5성', '051-810-5600', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (37, '소르젠떼 비지니스 호텔', '부산광역시 사상구 광장로81번길 55  (괘법동)', '2성', '051-715-2340', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (38, '명지 오이아 호텔', '부산광역시 강서구 명지국제6로1번길 24 (도하마린타워) (명지동)', '2성', '051-207-1201', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (39, '에이치에비뉴 호텔 광안리', '부산광역시 수영구 민락수변로 29 11층, 12층 (민락동)', '1성', '051-753-1340', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (40, '호메르스 호텔', '부산광역시 수영구 광안해변로 217 (광안동)', '3성', '051-750-8000', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (41, '네스트 호텔 (a member of Design Hotels™)', '인천광역시 중구 영종해안남로 19-5 (운서동)', '5성', '032-743-9000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (42, '호텔시애틀 인천공항점', '인천광역시 중구 신도시남로150번길 8  (운서동)', '2성', '032-752-1170', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (43, '선재해림', '인천광역시 옹진군 영흥면 선재로226번길 107-34 ', '2성', '032-880-1688', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (44, '오크우드 프리미어 인천 호텔', '인천광역시 연수구 컨벤시아대로 165 (송도동)', '5성', '032-726-2000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (45, '홀리데이 인 인천 송도 호텔', '인천광역시 연수구 인천타워대로 251  (송도동)', '4성', '032-250-0000', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (46, '블룸비스타호텔앤컨퍼런스주식회사 ', '경기도 양평군 강하면 강남로 316  ', '4성', '031-770-8888', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (47, '호텔 에스알 스위츠', '경기도 성남시 분당구 황새울로319번길 9 (서현동)', '3성', '031-702-6565', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (48, '호텔더메이', '경기도 남양주시 별내2로 70  (별내동)', '3성', '031-551-8700', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (49, '라마다 프라자 수원 호텔', '경기도 수원시 팔달구 중부대로 150 라마다프라자 수원 호텔 (인계동)', '4성', '031-230-0001', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (50, '어반 부티크 호텔', '경기도 안양시 동안구 흥안대로 497  (관양동)', '3성', '031-421-0000', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (51, '하슬라 아트 월드 뮤지엄 호텔', '강원도 강릉시 강동면 율곡로 1441 ', '2성', '033-644-9411', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (52, '쏠비치 호텔 삼척', '강원도 삼척시 수로부인길 453 (갈천동)', '4성', '033-803-7955', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (53, '뉴동해관광호텔', '강원도 동해시 평릉길 1  (천곡동)', '3성', '033-533-9215', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (54, '롯데 리조트 속초', '강원도 속초시 대포항길 186 (대포동)', '4성', '033-634-1101', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (55, '동해현진관광호텔', '강원도 동해시 동굴로 125-3 . (천곡동)', '3성', '033-539-2000', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (56, '레전드 호텔', '대전광역시 유성구 계룡로141번길 21  (봉명동)', '3성', '042-229-8000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (57, '롯데시티호텔 대전', '대전광역시 유성구 엑스포로123번길 33  (도룡동)', '4성', '042-333-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (58, '계룡스파텔', '대전광역시 유성구 온천로 81', '3성', '042-602-1111', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (59, '디엠프레스호텔', '대전광역시 서구 한밭대로570번길 29-20  (월평동)', '2성', '042-485-3030', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (60, '호텔 인터시티', '대전광역시 유성구 온천로 92', '4성', '042-600-6000', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (61, '홀리데이 인 광주 호텔', '광주광역시 서구 상무누리로 55  (치평동)', '4성', '062-610-7000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (62, '씨에스 호텔', '광주광역시 서구 상무평화로 128 (치평동)', '3성', '062-363-3300', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (63, 'ACC 디자인 호텔', '광주광역시 동구 금남로 226-11', '3성', '062-227-6400', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (64, '호텔 무등 파크', '광주광역시 동구 지호로164번길 14-10  (지산동)', '2성', '062-231-1571', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (65, '마스터스 관광호텔', '광주광역시 서구 상무연하로 46', '1성', '062-382-7700', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (66, '팔공산 온천 관광호텔', '대구광역시 동구 팔공산로185길 11 (용수동)', '2성', '053-985-8080', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (67, '제이비관광호텔', '대구광역시 동구 율암로 162  (상매동)', '3성', '053-964-2000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (68, '퀸벨 호텔', '대구광역시 동구 동촌로 200  (방촌동)', '3성', '053-282-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (69, '칸호텔', '대구광역시 달성군 구지면 달성2차동1로 141 ', '1성', '053-263-0777', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (70, '호텔G', '대구광역시 달성군 구지면 달성2차동1로 145  ', '2성', '053-263-5511', '호캉스');

INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (71, '롯데 호텔 제주', '제주특별자치도 서귀포시 중문관광로72번길 35', '5성', '064-731-1000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (72, '해비치 호텔 & 리조트 제주', '제주특별자치도 서귀포시 표선면 민속해안로 537', '5성', '064-780-8100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (73, '제주 신라 호텔', '제주특별자치도 서귀포시 중문관광로72번길 75', '5성', '064-735-5114', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (74, '켄싱턴 제주 호텔', '제주특별자치도 서귀포시 중문관광로72번길 60', '5성', '064-735-8900', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (75, '라마다 플라자 제주 호텔', '제주특별자치도 제주시 중앙로 66', '5성', '064-729-8100', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (76, '메종 글래드 제주', '제주특별자치도 제주시 노연로 80', '5성', '064-747-4900', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (77, '호텔 난타 제주', '제주특별자치도 제주시 명림로 56-26', '4성', '064-795-8000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (78, '베이힐 풀&빌라', '제주특별자치도 서귀포시 예래해안로 424', '5성', '064-801-9000', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (79, '그랜드 하얏트 제주', '제주특별자치도 제주시 노연로 12', '5성', '064-907-1234', '호캉스');
INSERT INTO accommodation (accommodation_id, accommodation_name, accommodation_location, accommodation_grade, accommodation_call, keyword) VALUES (80, '라마다 제주 함덕 호텔', '제주특별자치도 제주시 조천읍 조함해안로 100', '4성', '064-803-9700', '호캉스');




INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (1, '우래옥 본점', '서울 중구 창경궁로 62-29', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (2, '소문난 성수 감자탕', '서울 성동구 연무장길 45', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (3, '또순이네', '서울 영등포구 선유로47길 16', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (4, '새벽집 청담동점', '서울 강남구 도산대로101길 6', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (5, '마복림 떡볶이', '서울 중구 다산로35길 5', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (6, '토속촌 삼계탕', '서울 종로구 자하문로5길 5', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (7, '영동 설렁탕', '서울 서초구 강남대로101안길 24', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (8, '중앙 해장', '서울 강남구 영동대로86길 17', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (9, '청와옥 올림픽공원점', '서울 송파구 위례성대로 48', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (10, '명동교자 본점', '서울 중구 명동10길 29', '맛집');



INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (11, '해운대 암소 갈비집', '부산 해운대구 중동2로10번길 32-10', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (12, '바릇 식당', '부산 기장군 문오성길 61', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (13, '금수복국 해운대 본점', '부산 해운대구 중동1로43번길 23', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (14, '대게만찬', '부산 기장군 기장읍 기장해안로 266', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (15, '수변최고 돼지국밥 민락 본점', '부산 수영구 광안해변로370번길 9-32', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (16, '냉수탕 가든', '부산 부산진구 가야공원로 107', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (17, '해운대 가야밀면', '부산 해운대구 좌동순환로 27', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (18, '식당3선 센텀1관', '부산 해운대구 해운대로 230', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (19, '목장원', '부산 영도구 절영로 355', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (20, '얼크니 손칼국수 기장점', '부산 기장군 차성로417번길 22', '맛집');



INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (21, '똠팔이 이천점', '경기 이천시 이장로 274', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (22, '일산 칼국수 본점', '경기 고양시 일산동구 경의로 467', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (23, '장어의꿈', '경기 남양주시 순화궁로 492-6', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (24, '송추 가마골 본관', '경기 양주시 호국로 525', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (25, '가보정갈비 본관(1관)', '경기 수원시 팔달구 장다리로 282', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (26, '고기리 막국수', '경기 용인시 수지구 이종무로 157', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (27, '본수원갈비 본점', '경기 수원시 팔달구 중부대로223번길 41', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (28, '강강술래 늘봄농원점', '경기 고양시 덕양구 호국로 1526', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (29, '참숮한우천국 대화점', '경기 고양시 일산서구 일산로 676', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (30, '산으로간고등어 동천본점', '경기 용인시 수지구 고기로 126', '맛집');



INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (31, '청초수 물회 속초 본점', '강원 속초시 엑스포로 12-36', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (32, '동화 가든', '강원 강릉시 초당순두부길77번길 15', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (33, '통나무집 닭갈비 본점', '강원 춘천시 신북읍 신샘밭로 763', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (34, '봉포 머구리집', '강원 속초시 영랑해안길 223', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (35, '양지말화로구이', '강원 홍천군 양지말길 17-4', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (36, '토담 숯불 닭갈비', '강원 춘천시 신북읍 신샘밭로 662', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (37, '백촌 막국수', '강원 고성군 백촌1길 10', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (38, '88생선구이', '강원 속초시 중앙부두길 71', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (39, '김영애 할머니 순두부 본점', '강원 속초시 원암학사평길 183', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (40, '대청마루 [한식]', '강원 속초시 관광로 430', '맛집');



INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (41, '우진해장국', '제주 제주시 서사로 11', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (42, '자매국수 본점', '제주 제주시 탑동로11길 6', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (43, '숙성도 중문점', '제주 서귀포시 일주서로 966', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (44, '명진전복', '제주 제주시 해맞이해안로 1282', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (45, '미영이네 식당', '제주 서귀포시 하모항구로 42', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (46, '연돈', '제주 서귀포시 일주서로 968-10', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (47, '곰막', '제주 제주시 구좌해안로 64', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (48, '고집돌우럭 중문점', '제주 서귀포시 일주서로 879', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (49, '고집돌 우럭 제주공항점', '제주 제주시 임항로 30', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (50, '가시아방 국수', '제주 서귀포시 섭지코지로 10', '맛집');


INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (51, '나주곰탕 하얀집', '전남 나주시 금성관길 6-1', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (52, '꽃돌게장 1번가', '전남 여수시 봉산2로 36', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (53, '여수 명동게장', '전남 여수시 봉산남4길 23-26', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (54, '쌍교 숯불갈비 담양 본점', '전남 담양군 송강정로 212', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (55, '청정 게장촌', '전남 여수시 봉산남4길 23-32', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (56, '남도 예담', '전남 담양군 담장로 143', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (57, '북항 회센터', '전남 목포시 북항로 190', '맛집');




INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (58, '지린성 [중식]', '전북 군산시 미원로 87', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (59, '한일옥', '전북 군산시 구영3길 63', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (60, '복성루 [중식]', '전북 군산시 월명로 382', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (61, '고궁 전주 본점 [한식]', '전북 전주시 덕진구 송천중앙로 33', '맛집');
INSERT INTO restaurant (restaurant_id, restaurant_name, restaurant_location, keyword) VALUES (62, '현대옥 본점', '전북 전주시 완산구 화산천변2길 7-4', '맛집');


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





