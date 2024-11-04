��#   t r i p P l a n 
 
 
/* 어드민 페이지 시작 */
.admin_article {
    padding: 20px;
    height: 100vh;
    background-color: #dde6eb;
}

.admin_title {
    margin: 10px 0;
}

.admin_main_section {
    width: 100%;
    height: auto;
    min-height: calc(100% - 80px);
}

.admin_main_ul {
    display: flex;
    padding: 0;
}

.admin_main_li {
    color: white;

}

.admin_main_li a {
    position: relative;
    display: block;
    padding: 15px 0 15px 20px;
    margin: 5px 10px 0;
    width: 250px;
    height: calc(100% - 5px);
    text-align: left;
    font-weight: 800;
    font-size: 20px;
    color: white;
    border-top-left-radius: 15px;
    border-top-right-radius: 15px;
    background-color: #1364df;
    transition: all 0.3s ease 0s;
}

.admin_main_li a:hover {
    transition: all 0.3s ease 0s;
}

.admin_main_li:first-child a {
    margin-left: 0;
}

.admin_main_li .admin_main_active {
    color: #1364df;
    background-color: white;
}

.admin_main_li .admin_main_active::before, .admin_main_li a:hover::before {
    content: '';
    position: absolute;
    top: 17px;
    left: -1px;
    display: block;
    width: 5px;
    height: 57px;
    background-color: #1364df;
    border: 1px solid #1364df;
    border-top-right-radius: 8px;
    border-bottom-right-radius: 8px;
}

.admin_main_li a span {
    display: block;
    margin-top: 5px;
    font-size: 15px;
    font-weight: 500;
    border-radius: 5px;
    transition: background 0.3s;
}

.admin_main_li a:hover {
    color: #1364df;
    background-color: white;
}

.admin_main_content {
    padding: 20px;
    height: 670px;
    border-top-right-radius: 15px;
    border-bottom-right-radius: 15px;
    border-bottom-left-radius: 15px;
    background-color: white;
}

.admin_community_title {
    margin-bottom: 10px;
    font-size: 18px;
}

.admin_community_content .ac_list_title, .admin_customer_content .ac_list_title {
    height: 50px;
}

.ac_list_body, .ac_list_title {
    display: flex;
    flex-direction: column;
    height: 495px;
    -ms-overflow-style: none; /* 인터넷 익스플로러 */
    scrollbar-width: none; /* 파이어폭스 */
    overflow-y: scroll;
}

.ac_list_body::-webkit-scrollbar {
    display: none;
  }

.ac_list_li, .ac_list_title li {
    display: flex;
    align-items: center;
    width: 100%;
    /* min-width: 200px; */
    height: 50px;
    border-bottom: 1px solid #ddd;
}

.ac_list_li div, .ac_list_title li div {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-grow: 1;
    flex-basis: 0;
    height: 50px;
}

.ac_list_li div:nth-child(1), .ac_list_title li div:first-child {
    flex-grow: 0.3;
}

.ac_list_li div:nth-child(2), .ac_list_title li div:nth-child(2) {
    flex-grow: 0.4;
}

.ac_list_li div:nth-child(4), .ac_list_title li div:nth-child(4) {
    margin-right: 30px;
}

.ac_list_title li div:last-child {
    color: #1364df;
}

.admin_community_content .ac_list_li div:nth-child(7), .ac_list_title li div:last-child {
    flex-grow: 0.5;
}

.ac_list_li .ac_ellipsis {
    display: block;
    text-align: center;
    line-height: 50px;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.ac_list_li:nth-of-type(odd) .ac_list_num {
    color: #f58020;
    /* background-color: #ffe9d7; */
}

.ac_list_li:nth-of-type(even) .ac_list_num {
    color: #2059f5;
    /* background-color: #d7deff; */
}

.admin_community_content .ac_list_body div:last-of-type {
    position: relative;
}

.admin_community_content .ac_list_body div:last-of-type::after {
    content: '';
    position: absolute;
    top: 50%;
    left: 50%;
    display: block;
    width: 60%;
    height: 30px;
    border: 1px solid #ddd;
    border-radius: 10px;
    box-shadow: 3px 3px 5px 1px rgba(0, 0, 0, .06);
    transform: translate(-50%, -50%);
}

.admin_community_btn {
    margin-top: 10px;
    width: 120px;
    height: 45px;
    line-height: 45px;
    text-align: center;
    color: white;
    text-transform: uppercase;
    border-radius: 8px;
    background-color: #fca55e;
    transition: all 0.3s ease 0s;
}

.admin_community_btn:hover {
    background-color: #ff8b2c;
    transition: all 0.4s ease 0s;
    cursor: pointer;
}

.admin_customer_content .ac_list_title li div:last-child {
    flex-grow: 1;
}

.admin_customer_content .ac_list_body li div:last-child {
    position: unset;
}
/* 어드민 페이지 끝 */
