<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>
</head>
<body>
	<br>
	<div align="center">
		<img src="assets/img/술추천1.png" width="1340" height="340">
	</div>
	<br>
	<div align="center">
		<img src="assets/img/술추천2.png" width="1340" height="340">
	</div>
	<br>
	<div align ="center">
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="beer" value="beer" name="option1" autocomplete="off">
		<label class="btn btn-outline-warning" for="beer">시원한 맥주지!</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="traditionalliquor" value="traditionalliquor" name="option1" autocomplete="off">
		<label class="btn btn-outline-warning" for="traditionalliquor">걸죽한 전통주가 최고!</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="wine" value="wine" name="option1" autocomplete="off">
		<label class="btn btn-outline-warning" for="wine">분위기있게 살짝 와인!</label><br>
	</div>
	</div>
	<br><br>
	<div align="center">
		<img src="assets/img/술추천3.png" width="1340" height="340">
	</div>
	<br>
	<div align ="center">
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="dri" value="dri" name="option2" autocomplete="off">
		<label class="btn btn-outline-warning" for="dri">깔끔한 드라이</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="mid" value="mid" name="option2" autocomplete="off">
		<label class="btn btn-outline-warning" for="mid">적당한게 좋아</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="sweet" value="sweet" name="option2" autocomplete="off">
		<label class="btn btn-outline-warning" for="sweet">달달한게 좋지</label><br>
	</div>
	</div>
	<br><br>
	<div align="center">
		<img src="assets/img/술추천4.png" width="1340" height="340">
	</div>
	<br>
	<div align ="center">
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="sparkling" value="sparkling" name="option3" autocomplete="off">
		<label class="btn btn-outline-warning" for="sparkling">톡쏘는 탄산취향</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="nosparkling" value="nosparkling" name="option3" autocomplete="off">
		<label class="btn btn-outline-warning" for="nosparkling">따끔한게 싫어 무탄산취향</label><br>
	</div>
	</div>
	<br><br>
	<div align ="center">
	<button type="button" id="submit" class="btn btn-dark btn-lg" >결과 보러가기</button>
	</div>
	<br><br>
</body>
<script>
	document.getElementById('submit').onclick = function() {
	    var radios1 = document.getElementsByName("option1");
	    var selected1 = Array.from(radios1).find(radio => radio.checked).value;
	    
	    var radios2 = document.getElementsByName("option2");
	    var selected2 = Array.from(radios2).find(radio => radio.checked).value;
	    
	    var radios3 = document.getElementsByName("option3");
	    var selected3 = Array.from(radios3).find(radio => radio.checked).value;
	
	    
	    location.href='recommendResult.do?option1='+selected1+'&option2='+selected2+'&option3='+selected3;
	}
	
	
</script>
</html>