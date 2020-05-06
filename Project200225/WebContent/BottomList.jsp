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
	
	.slideshow-container {
  		max-width: 1200px;
  		max-height: 600px;
  		position: relative;
  		margin: auto;
	}	

	.mySlides {
  		display: none;
	}
	
	.dot {
  		cursor: pointer;
  		height: 5px;
  		width: 5px;
  		margin: 0 2px;
  		background-color: #bbb;
  		border-radius: 50%;
  		display: inline-block;
  		transition: background-color 0.6s ease;
	}
	
	.active, .dot:hover {
  		background-color: #717171;
	}
	
	h2 {
    font-size: 14px;
    color: #353535;
    text-align: center;
    letter-spacing: 2px;
	}
	
	#newList{
		display: block;
    	list-style-type: disc;
    	margin-block-start: 1em;
    	margin-block-end: 1em;
    	margin-inline-start: 0px;
    	margin-inline-end: 0px;
    	padding-inline-start: 40px;
	}
	
	#newListli{
		position: relative;
    	display: inline-block;
    	margin: 0 0 50px;
    	color: #757575;
    	vertical-align: top;
	}
	
	table, tr, td, th{
		border-collapse: collapse;
		margin-left:auto;
    	margin-right:auto;	
    	text-align:center;
    	padding:10px;
	}
	
	img {
		cursor: pointer;
	}
	
	#paging{
		width:200px;
		margin-left:auto;
    	margin-right:auto;
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
<script>
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
			<c:if test="${sessionScope.id eq 'admin'}"><a onclick="location.href='ProductMake.jsp'"> 상품 추가 </a></c:if>
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
			<li><button id="btn1" onclick = "location.href='ProductListOuter'"> OUTER </button></li>
			<li><button id="btn1" onclick="location.href='ProductListTop'"> TOP </button></li>
			<li><button id="btn1" onclick="location.href='ProductListBottom'"> BOTTOM </button></li>
			<li><button id="btn1" onclick="location.href='ProductListShoes'"> SHOES </button></li>
			<li><button id="btn1" onclick="location.href='ProductListAcc'"> ACC </button></li>
		</ul>
	</div>
	<br><br>
    <h1> - BOTTOM - </h1>
    <br><br>
    <c:set var="i" value="0" />
	<c:set var="j" value="3" />
    <table> 
    	<tr>  		
			<c:forEach var="product" items="${productList}" varStatus="status">
				<c:if test="${status.index%3==0}">
				</tr><tr>
				</c:if>
				<td> <img src="PfileUpload/${product.pfile}" width="380" height="480" onclick="location.href='productView?productno=${product.productno}&page=${paging.page}'"> <br> ${product.productname} <br> KRW ${product.price} </td>
				<c:if test="${test eq 3}" ><tr/></c:if>
			</c:forEach>
			</tr>
	</table>
	<div id="paging">
			<!-- 페이징 처리 -->
		<c:if test="${paging.page<=1}">
		[이전]&nbsp;
		</c:if>
		<c:if test="${paging.page>1}">
			<a href="ProductListBottom?page=${paging.page-1}">[이전]</a>&nbsp;
		</c:if>
		<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="i"
			step="1">
			<c:choose>
				<c:when test="${i eq paging.page}">
				${i}
				</c:when>
				<c:otherwise>
					<a href="ProductListBottom?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.page>=paging.maxPage}">
			&nbsp;[다음]
		</c:if>
		<c:if test="${paging.page<paging.maxPage}">
			&nbsp;<a href="ProductListBottom?page=${paging.page+1}">[다음]</a>
		</c:if>
	</div>
	<br><br>
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