<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
    
}

.social-list>div {
    color: var(--white);
    margin: 0 .5rem;
    padding: .7rem;
    cursor: pointer;
    border-radius: .5rem;
    cursor: pointer;
   
}



.social-list>div>i {
    font-size: 1.5rem;
    
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
    
}

.text p {
    font-weight: 600;
    
}

.img img {
    width: 30vw;
   
}






/* BACKGROUND */

.container::before {
    content: "";
    position: absolute;
    top: 0;
    right: 0;
    height: 100vh;
    width: 300vw;
  
    background-image: linear-gradient(-45deg, var(--primary-color) 0%, var(--secondary-color) 100%);
    z-index: 6;
    box-shadow: rgba(0, 0, 0, 0.35) 0px 5px 15px;
    border-bottom-right-radius: max(50vw, 50vh);
    border-top-left-radius: max(50vw, 50vh);
}

.container.sign-in::before {
   
    right: 50%;
}

.container.sign-up::before {

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

    

    .content-row {
        align-items: flex-start !important;
    }

    .content-row .col {
     
        background-color: unset;
    }

    .col {
        width: 100%;
        position: absolute;
        padding: 2rem;
        background-color: var(--white);
        border-top-left-radius: 2rem;
        border-top-right-radius: 2rem;
    
 
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
                
              </div>
            </div>
          
          </div>
          <!-- END SIGN UP -->
          <!-- SIGN IN -->
          <div class="col align-items-center flex-col sign-in">
            <div class="form-wrapper align-items-center">
              <div class="form sign-in">
            	
                <div class="input-group">
                
                  <i class='bx bxs-user'></i>
                  		<input type="text" id="memberId" name="memberId" placeholder="아이디" required>
                		</div>
                		<div class="input-group">
                  		<i class='bx bxs-lock-alt'></i>
                  		<input type="tel" id="memberTel" name="memberTel" placeholder="휴대폰 번호" required>
                </div>
                <div class="input-group">
                  		<i class='bx bxs-lock-alt'></i>
                  		<input type="text" id="memberPw" name="memberPw" placeholder="비밀번호" required>
                </div>
                
                
                <button type="button" onclick="searchPw()">
                  찾기
                </button>
                &nbsp;&nbsp;
                <button type="button" onclick="location.href='login.do'">
                로그인
                </button>
                
                
                
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
              
      
            </div>
          </div>
          <!-- END SIGN UP CONTENT -->
        </div>
        <!-- END CONTENT SECTION -->
      
      </div>
      
      <script>
let container = document.getElementById('container')



setTimeout(() => {
  container.classList.add('sign-in')
}, 0)
		function searchPw(){
				let id = document.getElementById("memberId").value;
				let tel = document.getElementById("memberTel").value;
				
				let url = "ajaxSearchPw.do?id=" + id + "&tel=" + tel;
				
				fetch(url)
					.then(response => response.text())
					.then(text => htmlProcess(text));
	
			}
			function htmlProcess(data){
				let memberPw = document.getElementById("memberPw");
				memberPw.value = data;		
			}

      </script>
</body>
</html>