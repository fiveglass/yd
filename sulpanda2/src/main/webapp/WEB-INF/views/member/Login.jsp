<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String errMsg = (String)session.getAttribute("errMsg");
	if(errMsg == null) errMsg= "";
	
	session.invalidate();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
:root {
    --primary-color: #4EA685;
    --secondary-color: #57B894;
    --black: #000000;
    --white: #ffffff;
    --gray: #efefef;
    --gray-2: #757575;

    --facebook-color: #4267B2;
    --google-color: #DB4437;
    --twitter-color: #1DA1F2;
    --insta-color: #E1306C;
}

@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600&display=swap');

* {
    font-family: 'Poppins', sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

html,
body {
    height: 100vh;
    overflow: hidden;
}

.container {
    position: relative;
    min-height: 100vh;
    overflow: hidden;
}

.row {
    display: flex;
    flex-wrap: wrap;
    height: 100vh;
}

.col {
    width: 50%;
}

.align-items-center {
    display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
}

.form-wrapper {
    width: 100%;
    max-width: 28rem;
}

.form {
    padding: 1rem;
    background-color: var(--white);
    border-radius: 1.5rem;
    width: 100%;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    transform: scale(0);
    transition: .5s ease-in-out;
    transition-delay: 1s;
}

.input-group {
    position: relative;
    width: 100%;
    margin: 1rem 0;
}

.input-group i {
    position: absolute;
    top: 50%;
    left: 1rem;
    transform: translateY(-50%);
    font-size: 1.4rem;
    color: var(--gray-2);
}

.input-group input {
    width: 100%;
    padding: 1rem 3rem;
    font-size: 1rem;
    background-color: var(--gray);
    border-radius: .5rem;
    border: 0.125rem solid var(--white);
    outline: none;
}

.button input {
	cursor: pointer;
	width: 100%;
	padding: .6rem 0;
	border-radius: .5rem;
	border: none;
	background-color: var(- -primary-color);
	color: var(- -white);
	font-size: 1rem;
	outline: none;
}

.input-group input:focus {
    border: 0.125rem solid var(--primary-color);
}

.form button {
    cursor: pointer;
    width: 100%;
    padding: .6rem 0;
    border-radius: .5rem;
    border: none;
    background-color: var(--primary-color);
    color: var(--white);
    font-size: 1.2rem;
    outline: none;
}

.form p {
    margin: 1rem 0;
    font-size: .7rem;
}

.flex-col {
    flex-direction: column;
}

.social-list {
    margin: 2rem 0;
    padding: 1rem;
    border-radius: 1.5rem;
    width: 100%;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    transform: scale(0);
    transition: .5s ease-in-out;
    transition-delay: 1.2s;
}

.social-list>div {
    color: var(--white);
    margin: 0 .5rem;
    padding: .7rem;
    cursor: pointer;
    border-radius: .5rem;
    cursor: pointer;
    transform: scale(0);
    transition: .5s ease-in-out;
}

.social-list>div:nth-child(1) {
    transition-delay: 1.4s;
}

.social-list>div:nth-child(2) {
    transition-delay: 1.6s;
}

.social-list>div:nth-child(3) {
    transition-delay: 1.8s;
}

.social-list>div:nth-child(4) {
    transition-delay: 2s;
}

.social-list>div>i {
    font-size: 1.5rem;
    transition: .4s ease-in-out;
}

.social-list>div:hover i {
    transform: scale(1.5);
}

.facebook-bg {
    background-color: var(--facebook-color);
}

.google-bg {
    background-color: var(--google-color);
}

.twitter-bg {
    background-color: var(--twitter-color);
}

.insta-bg {
    background-color: var(--insta-color);
}

.pointer {
    cursor: pointer;
}

.container.sign-in .form.sign-in,
.container.sign-in .social-list.sign-in,
.container.sign-in .social-list.sign-in>div,
.container.sign-up .form.sign-up,
.container.sign-up .social-list.sign-up,
.container.sign-up .social-list.sign-up>div {
    transform: scale(1);
}

.content-row {
    position: absolute;
    top: 0;
    left: 0;
    pointer-events: none;
    z-index: 6;
    width: 100%;
}

.text {
    margin: 4rem;
    color: var(--white);
}

.text h2 {
    font-size: 3.5rem;
    font-weight: 800;
    margin: 2rem 0;
    transition: 1s ease-in-out;
}

.text p {
    font-weight: 600;
    transition: 1s ease-in-out;
    transition-delay: .2s;
}

.img img {
    width: 30vw;
    transition: 1s ease-in-out;
    transition-delay: .4s;
}

.text.sign-in h2,
.text.sign-in p,
.img.sign-in img {
    transform: translateX(-250%);
}

.text.sign-up h2,
.text.sign-up p,
.img.sign-up img {
    transform: translateX(250%);
}

.container.sign-in .text.sign-in h2,
.container.sign-in .text.sign-in p,
.container.sign-in .img.sign-in img,
.container.sign-up .text.sign-up h2,
.container.sign-up .text.sign-up p,
.container.sign-up .img.sign-up img {
    transform: translateX(0);
}

/* BACKGROUND */

.container::before {
    content: "";
    position: absolute;
    top: 0;
    right: 0;
    height: 100vh;
    width: 300vw;
    transform: translate(35%, 0);
    background-image: linear-gradient(-45deg, var(--primary-color) 0%, var(--secondary-color) 100%);
    transition: 1s ease-in-out;
    z-index: 6;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    border-bottom-right-radius: max(50vw, 50vh);
    border-top-left-radius: max(50vw, 50vh);
}

.container.sign-in::before {
    transform: translate(0, 0);
    right: 50%;
}

.container.sign-up::before {
    transform: translate(100%, 0);
    right: 50%;
}

/* RESPONSIVE */

@media only screen and (max-width: 425px) {

    .container::before,
    .container.sign-in::before,
    .container.sign-up::before {
        height: 100vh;
        border-bottom-right-radius: 0;
        border-top-left-radius: 0;
        z-index: 0;
        transform: none;
        right: 0;
    }

    /* .container.sign-in .col.sign-up {
        transform: translateY(100%);
    } */

    .container.sign-in .col.sign-in,
    .container.sign-up .col.sign-up {
        transform: translateY(0);
    }

    .content-row {
        align-items: flex-start !important;
    }

    .content-row .col {
        transform: translateY(0);
        background-color: unset;
    }

    .col {
        width: 100%;
        position: absolute;
        padding: 2rem;
        background-color: var(--white);
        border-top-left-radius: 2rem;
        border-top-right-radius: 2rem;
        transform: translateY(100%);
        transition: 1s ease-in-out;
    }

    .row {
        align-items: flex-end;
        justify-content: flex-end;
    }

    .form,
    .social-list {
        box-shadow: none;
        margin: 0;
        padding: 0;
    }

    .text {
        margin: 0;
    }

    .text p {
        display: none;
    }

    .text h2 {
        margin: .5rem;
        font-size: 2rem;
    }
}

    </style>
</head>
<body>
    <div id="container" class="container">
	
        <!-- FORM SECTION -->
        <div class="row">
          <!-- SIGN UP -->
          <div class="col align-items-center flex-col sign-up">
            <div class="form-wrapper align-items-center">
              <div class="form sign-up">
              <form id="frm" action="memberInsert.do" onsubmit = "return formCheck()" method="post">
                <div class="input-group">
                  <i class='bx bxs-user'></i>
                  <input type="text" id="memberId" name="memberId" placeholder="Username">
                  <span class='button'>
                  
					<button type="button" id="checkId" value="No" onclick="idCheck()">중복체크</button>
				  </span>
                </div>
                <div class="input-group">
                  <i class='bx bxs-lock-alt'></i>
                  <input type="password" id="memberPassword" name="memberPassword" placeholder="Password">
                </div>
                <div class="input-group">
                  <i class='bx bxs-lock-alt'></i>
                  <input type="password" id="passwordCheck" name="passwordCheck" placeholder="Confirm password">
                </div>
                <div class="input-group">
                    <i class='bx bxs-name'></i>
                    <input type="text" id="memberName" name="memberName" placeholder="Name">
                </div>
                <div class="input-group">
                    <i class='bx bxs-tel'></i>
                    <input type="Tel"id="memberTel" name="memberTel"  placeholder="Tel">
                </div>
                <div class="input-group">
							<i class='bx bxs-addr'></i> <input type="text"
								id="sample6_postcode" name="sample6_postcode" placeholder="우편번호"> 
							<span class='button'>
							<button type="button" id="checkId" value="No" onclick="sample6_execDaumPostcode()">우편번호찾기</button>
							</span> 
							<input type="text" id="sample6_address" name="sample6_address" placeholder="주소"><br>
							<input type="text" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소">
							<input type="text" id="sample6_extraAddress" name="sample6_extraAddress" placeholder="참고항목">
						</div>
                <button>
                  Sign up
                </button>
                <p>
                  <span>
                    Already have an account?
                  </span>
                  <b onclick="toggle()" class="pointer">
                    Sign in here
                  </b>
                </p>
              </div>
            </div>
          </form>
          </div>
          <!-- END SIGN UP -->
          <!-- SIGN IN -->
          <div class="col align-items-center flex-col sign-in">
            <div class="form-wrapper align-items-center">
              <div class="form sign-in">
            	<form id="frm" action="memberLogin.do" method="post">
                <div class="input-group">
                  <i class='bx bxs-user'></i>
                  		<input type="text" id="memberId" name="memberId" placeholder="아이디" required>
                		</div>
                		<div class="input-group">
                  		<i class='bx bxs-lock-alt'></i>
                  		<input type="password" id="memberPw" name="memberPw" placeholder="비밀번호" required>
                </div>
                <div id="errMsg" style="color:red"><%=errMsg %></div>
                <a id="kakao-login-btn" href="javascript:kakaoLogin()">
  <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="200" 
    alt="카카오 로그인 버튼" /></a>
    <a id="naver-login-btn" href="naverLogin.do">
  <img src="assets/img/네이버로그인버튼.png" width="200" alt="네이버 로그인 버튼" /></a>
                <button>
                  Sign in
                </button>
                </form>
                <p>
                	
                  <b onclick="location.href='forgetPw.do'" style="cursor:pointer">
                    비밀번호 찾기
                  </b>
                </p>
                <p>
                  <span>
                    Don't have an account?
                  </span>
                  <b onclick="toggle()" class="pointer">
                    Sign up here
                  </b>
                </p>
              </div>
            </div>
            <div class="form-wrapper">
        
            </div>
          </div>
          <!-- END SIGN IN -->
        </div>
        <!-- END FORM SECTION -->
        <!-- CONTENT SECTION -->
        <div class="row content-row">
          <!-- SIGN IN CONTENT -->
          <div class="col align-items-center flex-col">
            <div class="text sign-in">
              <h2>
                Welcome
              </h2>
      
            </div>
            <div class="img sign-in">
        
            </div>
          </div>
          <!-- END SIGN IN CONTENT -->
          <!-- SIGN UP CONTENT -->
          <div class="col align-items-center flex-col">
            <div class="img sign-up">
            
            </div>
            <div class="text sign-up">
              <h2>
                Join with us
              </h2>
      
            </div>
          </div>
          <!-- END SIGN UP CONTENT -->
        </div>
        <!-- END CONTENT SECTION -->
      
      </div>
      <form id="form-kakao-login" method="post" action="socialLogin.do">
		    <input type="hidden" id="socialName" name="socialName"/>
		    <input type="hidden" id="socialId" name="socialId"/>
		    <input type="hidden" id="socialTel" name="socialTel" value=""/>
	</form>
      <script>
let container = document.getElementById('container')

toggle = () => {
  container.classList.toggle('sign-in')
  container.classList.toggle('sign-up')
}

setTimeout(() => {
  container.classList.add('sign-in')
}, 200)


      </script>
      <script src = "https://developers.kakao.com/sdk/js/kakao.min.js"></script>
      <script>
		window.Kakao.init("fb74b6cb0883a625f1a180019b2d9a9f");
		
		function kakaoLogin(){
			window.Kakao.Auth.login({
				scope:'profile_nickname, account_email',
				success: function(authObj){
					window.Kakao.API.request({
						url:'/v2/user/me',
						success: response=>{
							let kakaoName = document.getElementById("socialName");
							let kakaoId = document.getElementById("socialId");
							
							//kakaoMemberId.value = response.kakao_account['email'];
							kakaoName.value = response.kakao_account['profile']['nickname'];
							kakaoId.value = response.id;
							//console.log(response.kakao_account['email'])
							//console.log(response.kakao_account['profile']['nickname'])
			  				//console.log(response.id)
							
			  				let url = "ajaxCheckAge.do?id=" + response.id;
			  				
			  				fetch(url)
			  					.then(response => response.text())
			  					.then(text => htmlProcess(text));
			  				
							
							//memberName.value = account.nickname;
							//memberGender.value = account.gender;
							// 사용자 정보가 포함된 폼을 서버로 제출한다.
							
			  				
						}
					})
					console.log(authObj);
			        var token = authObj.access_token;
				},
				fail: function(err) {
			          alert(JSON.stringify(err));
			        }
			});
		
		}
		
		function htmlProcess(data){
			
			if(data=="Yes"){
				let	sign = prompt("처음 오셨네요!! 당신은 미성년자 입니까? (예, 아니오로 대답해주세요.)");
				
				
				if(sign == "예"){
					alert("미성년자는 로그인이 불가합니다.");
					location.href = "main.do";
				} else if(sign =="아니오"){
					document.querySelector('#form-kakao-login').submit();
				} else {
					alert("잘못된 값 입력");
				}
			} else {
				document.querySelector('#form-kakao-login').submit();
			}
		}
			
	</script>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<script type="text/javascript">
	
	function formCheck() {
		let frm = document.getElementById("frm");
		let checkId = document.getElementById("checkId").value
		if(frm.memberPassword.value != frm.passwordCheck.value){
			alert("패스워드가 동일하지 않습니다.");
			frm.memberPassword.value = "";
			frm.passwordCheck.value="";
			frm.memberPw.focus();
			return false;
		}else if(checkId != "Yes"){
			alert("아이디 중복체크를 수행하세요.")
			return false;
		}
		
		return true;	
	}
	
	function idCheck() {
		let id = document.getElementById("memberId").value;
		let url ="ajaxCheckId.do?id="+id;
		fetch(url)
			.then(response => response.text())
			.then(text=>htmlProcess(text));	
	}
	
	function htmlProcess(data) {
		if(data == 'Yes'){
			alert(document.getElementById("memberId").value + "\n 사용가능한 아이디 입니다.");
			document.getElementById("checkId").value = "Yes";
		}else {
			alert(document.getElementById("memberId").value + "\n 이미 사용하는 아이디 입니다.");
			document.getElementId("memberId").value = "";
			document.getElementId("memberId").focus();
		}
	}
	
	
	
</script>
</body>
</html>