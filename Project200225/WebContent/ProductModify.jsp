<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키작남_메인페이지</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/63b21adac5.js"></script>
<script>
	function modifyFn(){
		modifyForm.submit();	
	}
</script>
<style>
	#header1 {
		position: absolute;
    	top: 0;
    	left: 0;
    	content: "";
    	width: 100%;
    	height: 24px;
    	background-color: rgba(248, 247, 247, 0.911);
	}
	
	#header2 {
		    position: relative;
    	width: 1250px;
    	margin: 0 auto;
    	text-align: center;
	}
	
	button {
		border: none;
    	cursor: pointer;
    	font-size: 15px;
    	font-family: 'Do Hyeon', sans-serif;
    	background-color: rgba(248, 247, 247, 0.911);
    	float: right;
	}
	
	body{
    	font-family: 'Do Hyeon', sans-serif;
	}
	
	h1{
		text-align:center;
	}
	
	ul{
		display: block;
    	list-style-type: disc;
    	margin-block-start: 1em;
    	margin-block-end: 1em;
    	margin-inline-start: 0px;
    	margin-inline-end: 0px;
    	padding-inline-start: 40px;
	}
	
	#btn1{
		background-color: white;
		font-size: 17px;
		float: left;
	}
	
	#position{
		position: sticky;
        top: 0;
        background-color: white;
        z-index:10;
	    width: 1250px;
    	margin: 0 auto;
 	   	border-top: 1px #ddd solid;
    	border-bottom: 1px #ddd solid;
	}
	
	li{
		position: relative;
	    display: inline-block;
    	padding: 0 19px;
	}
	
	#inner {
		margin-top:8px;
		float: left;
	    line-height: 28px;
    	text-align: center;
    	display: block;
	}

	#type{
		text-align: right;
    	line-height: 18px;
	}
	
	#typelist{
		font-size:15px;
		display: inline;
    	padding: 0 6px 0 10px;
    	cursor: pointer;
    	background: url(//img.echosting.cafe24.com/skin/base_ko_KR/product/bg_result_type.gif) no-repeat 0 50%;
	}
	
	a {
		display: inline-block;
	    padding: 0 5px;
    	color: #555;
	    font-size: 14px;
	    text-decoration: none;
	    cursor: pointer;
	    line-height: 28px;
	}
	
	#btn2 {
		width: 120px;
		height:40px;
    	padding-left: 8px;
    	padding-right: 8px;
    	margin-right: 15px;
   	    background: #555555;
   	    color: #ffffff;
   		font-size: 15px;
    	text-align: center;
	    float: left;
	    position: relative;
    	left: 44%;
	}

	table{
		border-collapse: collapse;
		position: relative;
    	margin: 10px 0 0;
    	border-bottom: 1px solid #dfdfdf;
    	border-top: 0;
    	color: #fff;
    	line-height: 1.5;
    	margin-left:auto;
    	margin-right:auto;
	}
	
	tr{
		display: table-row;
	    vertical-align: inherit;
    	border-color: inherit;
	}
	
	th{
		padding: 12px 0 12px 18px;
    	border: 1px solid #dfdfdf;
    	border-bottom-width: 0;
    	color: #353535;
    	text-align: center;
    	font-weight: normal;
    	background-color: #fff;
    	border-left: 0;
    	width:100px;
    	font-size:20px;
	}
	
	td{
		border-top: 1px solid #dfdfdf;
    	color: #353535;
    	font-size: 11px;
    	vertical-align: middle;
    	word-break: break-all;
    	word-wrap: break-word;
    	width:500px;
    	height:80px;
	}
	
	#joininput{
		width:300px;
  		height:25px;
  		margin-left:10px;
	}
	
	select{
		width:300px;
  		height:30px;
  		margin-left:10px;
	}
	
	#typelist{
		font-size:15px;
		display: inline;
    	padding: 0 6px 0 10px;
    	cursor: pointer;
    	background: url(//img.echosting.cafe24.com/skin/base_ko_KR/product/bg_result_type.gif) no-repeat 0 50%;
	}
	
	#search{
		border-top:none;
		border-left:none;
		border-right:none;
		border-bottom:1px #e8e8e8 solid;
		height:18px;
		margin-bottom:0px;
	}
	
	#footerdiv{
		border-top:1px #e8e8e8 solid;
	}
	
	#footerul1{
		position: relative;
    	max-width: 1500px;
    	margin: 0 auto;
    	padding: 0 50px;
    	font-size: 0;
    	line-height: 0;
    	clear: both;
    	overflow: hidden;
	}
	
	#footerli1{
		position: relative;
    	float: left;
    	width: 30%;
    	color: #555;
    	-webkit-box-sizing: border-box;
    	-moz-box-sizing: border-box;
    	box-sizing: border-box;
    	line-height: 23px;
	}
	
	#footerli2{
		position: relative;
    	float: left;
    	width: 23%;
    	color: #555;
    	-webkit-box-sizing: border-box;
    	-moz-box-sizing: border-box;
    	box-sizing: border-box;
    	border-left:1px #e8e8e8 solid;
    	line-height: 23px;
	}
	
	#footerh2{
		text-align:left;
		margin: 35px 0 5px;
    	font-size: 19px;
    	color: #353535;
	}
	
	#myBtn {
  		display: none;
  		position: fixed;
  		bottom: 20px;
  		right: 30px;
  		z-index: 99;
  		font-size: 18px;
  		border: none;
  		outline: none;
  		background-color: red;
  		color: white;
  		cursor: pointer;
  		padding: 15px;
  		border-radius: 4px;
	}

	#myBtn:hover {
  		background-color: #555;
	}
</style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
    <script type="text/javascript">
    var loadFile = function(event) {
        var reader = new FileReader();
        reader.onload = function(){
          var output = document.getElementById('output');
          output.src = reader.result;
        };
        reader.readAsDataURL(event.target.files[0]);
      };

        function searchFn(){
    		var search = document.getElementById("search").value;
    		location.href="productSearch?search="+search;
    	}

    </script>
</head>
<body>
<button onclick="topFunction()" id="myBtn" title="Go to top">Top</button>
	<script>
//Get the button
var mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
	<div id = "header1">
	</div>
	<div id = "header2">
	<br><br>
		<h1 style="cursor:pointer" onclick="location.href='ProductList'"> 키작남 </h1>
	<br>		
		<div id = "inner">
			<c:if test="${not empty sessionScope.id}">
				<a>${sessionScope.id} 님 </a>
				<a onclick="location.href='MemberLogout'"> 로그아웃 </a>
			</c:if>
			<c:if test="${sessionScope.id eq 'admin'}"><a href="MemberList"> 회원목록 조회 </a></c:if>
			<c:if test="${sessionScope.id eq 'admin'}"><a href="ProductMake.jsp"> 상품 추가 </a></c:if>
			<c:if test="${empty sessionScope.id}"><a onclick="location.href='LoginPage.jsp'"> 로그인 </a></c:if>		
			<c:if test="${empty sessionScope.id}"><a onclick="location.href='JoinPage.jsp'"> 회원가입 </a></c:if>
			<c:if test="${sessionScope.id ne 'admin'}"><a onclick="location.href='checkOut.jsp'"> 장바구니 </a></c:if>
			<c:if test="${sessionScope.id ne 'admin'}"><a onclick="location.href='OrderBuyList'"> 주문내역 </a></c:if>
			<c:if test="${sessionScope.id eq 'admin'}"><a onclick="location.href='OrderBuyList'"> 회원 주문내역 </a></c:if>
			<a onclick="location.href='MyPage.jsp'"> 마이페이지 </a>
		</div>
		<ul id = "type">
    		<li id = "typelist"> <input type="text" name="search" id="search"placeholder="검색"> <button onclick="searchFn()" style="font-size:15px;">검색</button> </li>
    	</ul> 
	</div>
	<div id = "position">
		<ul>
			<li><button id="btn1" onclick="location.href='ProductListOuter'"> OUTER </button></li>
			<li><button id="btn1" onclick="location.href='ProductListTop'"> TOP </button></li>
			<li><button id="btn1" onclick="location.href='ProductListBottom'"> BOTTOM </button></li>
			<li><button id="btn1" onclick="location.href='ProductListShoes'"> SHOES </button></li>
			<li><button id="btn1" onclick="location.href='ProductListAcc'"> ACC </button></li>
		</ul>
	</div>
	<h1> Modify </h1>
	<form action="ProductModify?productno=${product.productno}" method="post" name="modifyForm" enctype="multipart/form-data">
		<table>
			<tr>
				<th>
					상품명
				</th>
				<td>
					<input id = "joininput" type="text" name="productname" maxlength="16" value="${product.productname}">
				</td>
				<td rowspan="3">
				<p style="text-align: center;">
					<img style="height:300px" src="./PfileUpload/${product.pfile}" id="output"/>
				</p>
				</td>
			</tr>		
			<tr>
				<th>
					카테고리
				</th>
				<td>
					<select name="category" onChange="getSelectValue(this.form);">
						<option onselect="focus">카테고리</option>
            			<option value="OUTER">OUTER</option> 
            			<option value="TOP">TOP</option> 
            			<option value="BOTTOM">BOTTOM</option>
            			<option value="SHOES">SHOES</option>
            			<option value="ACC">ACC</option> 
        			</select>
				</td>
			</tr>
			<tr>
				<th>
					가격
				</th>
				<td>
					<input id = "joininput" type="text" name="price" value="${product.price}">
            	</td>
			</tr>
			<tr>
				<th>
        			사진 파일
    			</th>
    			<td colspan="2">
        			<input id = "joininput" name="pfile" value="${product.pfile}" type="file" accept="image/*" onchange="loadFile(event)">
    			</td>
			</tr>
		</table>
		<br>
		<button id=btn2 onclick="modifyFn()"> 상품 수정 </button>
		<button id=btn2 type="reset"> 다시 작성 </button>
	</form>
	<br><br><br><br>
<div id = "footerdiv">
		<ul id = "footerul1">
			<li id = "footerli1">
				<div> 
					<h2 id = "footerh2"> 
						About 
						<br> <p style="font-size:15px">company.키작남 
						<br> owner.임현우
						<br> tel.010-3743-6577
						<br> address.경기도 부천시
						</p>  
					</h2>
				</div>
			</li>
			<li id = "footerli2">
				<div> 
					<h2 id = "footerh2"> 
					CustomerCenter 
					<br> <p style="font-size:15px">MON - FRI : 08:30AM-04:50PM
						<br> LUNCH : 12:00PM - 13:00PM
						<br> SAT SUN HOLIDAY OFF
						</p> 
					</h2>
				</div>
			</li>
			<li id = "footerli2">
				<div> 
					<h2 id = "footerh2"> Bank ACCOUNT 
					<br> <p style="font-size:15px">[입금 계좌 안내]
						<br> 신한 110-486-771115
						<br> 예금주 : 임현우
						</p>
					</h2>
				</div>
			</li>
			<li id = "footerli2">
				<div> 
					<h2 id = "footerh2"> 교환 환불 취소안내 
					<br> <p style="font-size:15px">[교환 반품 주소지]
						<br> 경기도 부천시
						<br> 예금주 : 임현우
						</p>
					</h2>
				</div>
			</li>
		</ul>
	</div>
</body>
</html>