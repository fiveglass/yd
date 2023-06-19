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
    
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
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
	  	<input type="radio" class="btn-check" id="beer" value="맥주" name="option1" autocomplete="off">
		<label class="btn btn-outline-warning" for="beer">시원한 맥주지!</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="traditionalliquor" value="전통주" name="option1" autocomplete="off">
		<label class="btn btn-outline-warning" for="traditionalliquor">걸죽한 전통주가 최고!</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="wine" value="와인" name="option1" autocomplete="off">
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
	  	<input type="radio" class="btn-check" id="dry" value="드라이" name="option2" autocomplete="off">
		<label class="btn btn-outline-warning" for="dry">깔끔한 드라이</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="mid" value="중간" name="option2" autocomplete="off">
		<label class="btn btn-outline-warning" for="mid">적당한게 좋아</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="sweet" value="스위트" name="option2" autocomplete="off">
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
	  	<input type="radio" class="btn-check" id="sparkling" value="있음" name="option3" autocomplete="off">
		<label class="btn btn-outline-warning" for="sparkling">톡쏘는 탄산취향</label><br>
	</div>
	<div class="form-check form-check-inline">
	  	<input type="radio" class="btn-check" id="nosparkling" value="없음" name="option3" autocomplete="off">
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