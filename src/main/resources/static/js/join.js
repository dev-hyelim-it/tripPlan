//회원가입 진행용 js

//    변수 선언
$(document).ready(function() {
    let isValidUserId = false;
    let isValidPassword = false;
    let isValidNickname = false;
    alert("test")

//    아이디는 영문+숫자 4~10자리
//    $("#userId").on("change", function(){
//            let str = $("#userId").val();
//            var regExp = /^[0-9a-zA-Z]{4,10}$/;
//       if (!regExp.test(str)) {
//        $("#dup-userId").text("아이디는 영문+숫자 4~10자입니다").css("color", "red");
//        isValidUserId = false;
//        return;
//      }
//
////    아이디 중복 확인 후 안내 메시지 출력
//    $.ajax({
//        url:`/checkJoin`, // 서버에서 아이디 중복 확인을 위한 url
//        type:"GET",
//        cache:false,
//        data : { userId : str }, // 서버에 전달할 데이터
//        success : function(data){
//          if (data.success) { // 응답 성공시
//            $("#dup-userId").text("사용 가능한 아이디입니다").css("color", "green");
//            isValidUserId = true;
//          } else { // 응답 실패시
//            $("#dup-userId").text(data.msg).css("color", "red");
//            isValidUserId = false;
//          }
//        }
//      });
//    })
//
////    비밀번호는 8~16자이고, 비밀번호 확인란과 똑같이 입력해야 한다.
//    $("input[name='userPassword'], input[name='re-password']").on("propertychange change keyup paste input", function(){
//      let pass1 = $("input[name='userPassword']").val();
//      let pass2 = $("input[name='re-password']").val();
//      let regExp = /^[a-zA-Z\d`~!@#$%^&*()-_=+]{8,16}$/;
//
//      if (!regExp.test(pass1)) {
//        $("#dup-password").text("비밀번호는 8~16자입니다").css("color", "red");
//        isValidPassword = false;
//        return;
//      }
//      if (pass1 == pass2) {
//        $("#dup-password").text("비밀번호와 일치합니다");
//        $("#dup-password").css("color", "green");
//        isValidPassword = true;
//      }
//      else {
//        $("#dup-password").text("비밀번호와 다릅니다");
//        $("#dup-password").css("color", "red");
//        isValidPassword = false;
//      }
//    })
//
////    닉네임은 2~8자로, 중복을 허용하지 않는다
//    $("#userNickname").on("change", function(){
//      let str = $("#userNickname").val();
//      var regExp = /^[ㄱ-ㅎ|가-힣|a-z|A-Z|0-9|]{2,8}$/;
//      if (!regExp.test(str)) {
//        $("#dup-userNickname").text("닉네임은 2~8자 입니다").css("color", "red");
//        isValidNickname = false;
//        return;
//      }
//
//      $.ajax({
//        url:`/checkJoin`,
//        type:"GET",
//        cache:false,
//        data: { userNickname: str },
//        success : function(data){
//          if (data.success) {
//            $("#dup-userNickname").text("사용 가능한 별명입니다").css("color", "green");
//            isValidNickname = true;
//          } else {
//            $("#dup-userNickname").text(data.msg).css("color", "red");
//            isValidNickname = false;
//          }
//        }
//      });
//    })
//
////      회원가입 완료
//      $("#submitBtn").click(function() {
//      if (!isValidUserId) {
//            alert("아이디를 확인해주세요");
//            return;
//            }
//      if (!isValidPassword) {
//            alert("비밀번호를 확인해주세요");
//            return;
//            }
//      if (!isValidNickname) {
//          alert("닉네임을 확인해주세요");
//          return;
//      }
//
//      let data = {
//        "userId": $("#userId").val(),
//        "userPassword": $("#userPassword").val(),
//        "userNickname": $("#userNickname").val(),
//        "userName": $("#userName").val(),
//        "userEmail": $("#userEmail").val()
//      };
//
//      $.ajax({
//        url: `/checkJoinProc`,
//        type:"POST",
//        contentType: "application/json",
//        dataType: "json",
//        data:JSON.stringify(data),
//        cache:false,
//        success : function(data){
//          if (data.success) {
//            alert("회원가입 성공");
//            location.href = "/login"; // 회원가입 성공 시 로그인 페이지로 이동
//          } else {
//            alert(data.msg);
//          }
//        },
//        error: function() {
//            alert("회원가입 중 오류가 발생했습니다.");
//        }
//      });
//    });
    });
