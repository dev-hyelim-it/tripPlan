INSERT INTO keyword (keyword) VALUES ('혼밥');
INSERT INTO keyword (keyword) VALUES ('커피');
INSERT INTO keyword (keyword) VALUES ('유적지');

INSERT INTO area (area) VALUES ('부산');
INSERT INTO area (area) VALUES ('인천');
INSERT INTO area (area) VALUES ('서울');

INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('frog', 'froggy', 'frog@naver.com', 'froggg', 'frogfrog');
INSERT INTO users (user_name, user_nickname, user_email, user_id, user_password) VALUES ('ant', 'antty', 'ant@naver.com', 'anttt', 'antant');

INSERT INTO post (likes, post_date, user_no, post_title, post_content) VALUES (100, '2024-07-23', 1, '부산 조아', '부산 개조음');
INSERT INTO post (likes, post_date, user_no, post_title, post_content) VALUES (159, '2024-08-11', 2, '여수 조아', '여수 개조음');

INSERT INTO travel (end_date, start_date, user_id, keyword, place) VALUES ('2024-07-21', '2024-07-19', 1, '호캉스', '부산')

--INSERT INTO travel (accommodation_id, travel_id) VALUES (1, 1)
--INSERT INTO travel (accommodation_id, travel_id) VALUES (1, 1)
