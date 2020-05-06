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
    font-size: 18px;
    color: #353535;
    text-align: center;
    letter-spacing: 2px;
	}
	
	h3 {
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
    	text-align:left;
    	padding:10px;
    	font-size:18px;
	}
	
	#btn2{
		width : 420px;
		height : 48px;
		background: #333333;
    	color: #ffffff;
	}
	
	#btn3{
		width : 420px;
		height : 48px;
		background: #ffffff;
    	color: #353535;
	}
	
	img {
		cursor: pointer;
	}
	
	#paging{
		width:200px;
		margin-left:auto;
    	margin-right:auto;
	}
	
	.function{
		width:1180px;
		overflow: hidden;
    	text-align: right;
    	line-height: 18px;
    	margin-left:auto;
    	margin-right:auto;
	}
	
	.productcount{
		float:left;
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
	
	#detailArea{
		max-width: 1100px;
    	margin-left:auto;
    	margin-right:auto;
    }
    
    #imgdiv{
    	float: left;
    	width: 50%;
    	margin: 0;
    }
    
    .img-zoom-container {
  		position: relative;
	}

	.img-zoom-lens {
  		position: absolute;
  		border: 1px solid #d4d4d4;
		width: 150px;
  		height: 150px;
	}

	.img-zoom-result {
  		border: 1px solid #d4d4d4;
		width: 420px;
  		height: 275px;
	}
	
	#ModifyDelete{
		max-width: 865px;
    	margin-left:auto;
    	margin-right:auto;
	}
	
	.ModifyDelete{
		width : 100px;
		height : 30px;
    	text-align:center;
    	float:right;
    	font-size:17px;
    	background: #333333;
    	color: #ffffff;
    	padding-top:7px;
    	margin-left:30px;
	}
	
	.WriteBtn{
		width : 70px;
		height : 25px;
    	text-align:center;
    	float:right;
    	font-size:14px;
    	background: #333333;
    	color: #ffffff;
    	padding-top:3px;
    	margin-left:30px;
	}
	
	#ReviewDiv{
		margin-left:auto;
    	margin-right:auto;
    	width:1200px;
	}
	
	#ReviewTable{
		margin-left:auto;
    	margin-right:auto;
	}
	
	#ReviewTr{
		display: table-row;
	    vertical-align: inherit;
    	border-color: inherit;
	}
	
	#ReviewTh{
		padding: 12px 0;
		border-top: 1px solid #e5e5e5;
    	border-bottom: 1px solid #e5e5e5;
    	color: #353535;
    	vertical-align: middle;
    	font-size: 15px;
    	font-weight: 500;
    	background: #f9f9f9;
    	text-align:center;
	}
	
	thead{
	display: table-header-group;
    vertical-align: middle;
    border-color: inherit;
	}
	
	#snackbar {
  		visibility: hidden;
  		min-width: 250px;
  		margin-left: -125px;
  		background-color: #333;
  		color: #fff;
  		text-align: center;
  		border-radius: 2px;
  		padding: 16px;
  		position: fixed;
  		z-index: 1;
  		left: 50%;
  		bottom: 30px;
  		font-size: 17px;
	}

	#snackbar.show {
  		visibility: visible;
  		-webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
  		animation: fadein 0.5s, fadeout 0.5s 2.5s;
	}

	@-webkit-keyframes fadein {
  		from {bottom: 0; opacity: 0;} 
  		to {bottom: 30px; opacity: 1;}
	}

	@keyframes fadein {
  		from {bottom: 0; opacity: 0;}
  		to {bottom: 30px; opacity: 1;}
	}

	@-webkit-keyframes fadeout {
  		from {bottom: 30px; opacity: 1;} 
  		to {bottom: 0; opacity: 0;}
	}

	@keyframes fadeout {
  		from {bottom: 30px; opacity: 1;}
  		to {bottom: 0; opacity: 0;}
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
	
	.accordion {
  width: 100%;
  border: none;
  text-align: center;
  outline: none;
  font-size: 15px;
  transition: 0.4s;
}

.panel {
  padding: 0 18px;
  display: none;
  background-color: white;
  overflow: hidden;
}
</style>
<script>
	function searchFn(){
		var search = document.getElementById("search").value;
		location.href="productSearch?search="+search;
	}
	
	function imageZoom(imgID, resultID) {
		  var img, lens, result, cx, cy;
		  img = document.getElementById(imgID);
		  result = document.getElementById(resultID);
		  /*create lens:*/
		  lens = document.createElement("DIV");
		  lens.setAttribute("class", "img-zoom-lens");
		  /*insert lens:*/
		  img.parentElement.insertBefore(lens, img);
		  /*calculate the ratio between result DIV and lens:*/
		  cx = result.offsetWidth / lens.offsetWidth;
		  cy = result.offsetHeight / lens.offsetHeight;
		  /*set background properties for the result DIV:*/
		  result.style.backgroundImage = "url('" + img.src + "')";
		  result.style.backgroundSize = (img.width * cx) + "px " + (img.height * cy) + "px";
		  /*execute a function when someone moves the cursor over the image, or the lens:*/
		  lens.addEventListener("mousemove", moveLens);
		  img.addEventListener("mousemove", moveLens);
		  /*and also for touch screens:*/
		  lens.addEventListener("touchmove", moveLens);
		  img.addEventListener("touchmove", moveLens);
		  function moveLens(e) {
		    var pos, x, y;
		    /*prevent any other actions that may occur when moving over the image:*/
		    e.preventDefault();
		    /*get the cursor's x and y positions:*/
		    pos = getCursorPos(e);
		    /*calculate the position of the lens:*/
		    x = pos.x - (lens.offsetWidth / 2);
		    y = pos.y - (lens.offsetHeight / 2);
		    /*prevent the lens from being positioned outside the image:*/
		    if (x > img.width - lens.offsetWidth) {x = img.width - lens.offsetWidth;}
		    if (x < 0) {x = 0;}
		    if (y > img.height - lens.offsetHeight) {y = img.height - lens.offsetHeight;}
		    if (y < 0) {y = 0;}
		    /*set the position of the lens:*/
		    lens.style.left = x + "px";
		    lens.style.top = y + "px";
		    /*display what the lens "sees":*/
		    result.style.backgroundPosition = "-" + (x * cx) + "px -" + (y * cy) + "px";
		  }
		  function getCursorPos(e) {
		    var a, x = 0, y = 0;
		    e = e || window.event;
		    /*get the x and y positions of the image:*/
		    a = img.getBoundingClientRect();
		    /*calculate the cursor's x and y coordinates, relative to the image:*/
		    x = e.pageX - a.left;
		    y = e.pageY - a.top;
		    /*consider any page scrolling:*/
		    x = x - window.pageXOffset;
		    y = y - window.pageYOffset;
		    return {x : x, y : y};
		  }
		}
	
	var sell_price;
	var amount;

	function init () {
		sell_price = document.form.sell_price.value;
		amount = document.form.amount.value;
		document.form.sum.value = sell_price;
		change();
	}

	function add () {
		hm = document.form.amount;
		sum = document.form.sum;
		hm.value ++ ;

		sum.value = parseInt(hm.value) * ${product.price};
	}

	function del () {
		hm = document.form.amount;
		sum = document.form.sum;
			if (hm.value > 1) {
				hm.value -- ;
				sum.value = parseInt(hm.value) * ${product.price};
			}
	}

	function change () {
		hm = document.form.amount;
		sum = document.form.sum;

			if (hm.value < 0) {
				hm.value = 0;
			}
		sum.value = parseInt(hm.value) * ${product.price};
	}  
	
	function deleteFn(){
		if(confirm("삭제하시겠습니까?")){
			location.href="productDelete?productno=${product.productno}";
		}else{
			alert("취소되었습니다.");
		}
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
			<li><button id="btn1" onclick="location.href='ProductListOuter'"> OUTER </button></li>
			<li><button id="btn1" onclick="location.href='ProductListTop'"> TOP </button></li>
			<li><button id="btn1" onclick="location.href='ProductListBottom'"> BOTTOM </button></li>
			<li><button id="btn1" onclick="location.href='ProductListShoes'"> SHOES </button></li>
			<li><button id="btn1" onclick="location.href='ProductListAcc'"> ACC </button></li>
		</ul>
	</div>
    <br><br>
    <div id = "detailArea">
    	<div id = "imgdiv" class="img-zoom-container">
    		<img id="myimage" src="PfileUpload/${product.pfile}" width="450" height="600">
    	</div>
    	<div>
    		<table>
    			<tr>
					<td> 상품명</td>
					<td> <c>${product.productname} </c></td>
				</tr>
				<tr>
					<td> 가격</td>
					<td> KRW ${product.price}</td>
				</tr>
				
				<tr>
					<td> 수량</td>
					<td> <form name="form" method="get">
						 <input type=hidden name="sell_price" value="${product.price}">
						 <input type="text" name="amount" value="1" size="3" onchange="change();">
						 <input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
					</td>
				</tr>
				<tr>
					<td> 합계 </td>	
					<td> <input type="text" name="sum" size="11" value = "${product.price}" readonly> 원
					 	</form>
					</td>
				</tr>
				<tr>
					<td colspan="2"> <button id = "btn2" onclick="location.href='OrderAdd?productno=${product.productno}&id=${sessionScope.id}'"> BUY</button></td>
				</tr>
				<tr>
					<td colspan="2"> 
					<form action="add.jsp" method="post">
        				<input type = "hidden" value = "${sessionScope.id}" name="id">
						<input type = "hidden" value = "${product.productno}" name="productno">
						<input type = "hidden" value = "${product.productname}" name="productname">
						<input type = "hidden" value = "${product.price}" name="price">
						<input type = "hidden" value = "${product.size}" name="size">
						<button type="submit" value="추가" onclick="myFunction()" id = "btn3"> CART</button>
					</form>
						<div id="snackbar">장바구니에 추가되었습니다.</div>
						<script>
							function myFunction() {
  							var x = document.getElementById("snackbar");
  							x.className = "show";
  							setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
							}
						</script>
					</td>
				</tr>
				<tr>
					<td colspan="2"><div id="myresult" class="img-zoom-result"></div></td>
				</tr>
			</table>
			<script>
				imageZoom("myimage", "myresult");
			</script>
    	</div>
    </div>  
    <br>
    <div id = "ModifyDelete">
		<c:if test="${sessionScope.id eq 'admin'}"><a onclick="deleteFn()" class = "ModifyDelete"> 삭제 </a></c:if>
		<c:if test="${sessionScope.id eq 'admin'}"><a onclick="location.href='productSelect?productno=${product.productno}'" class = "ModifyDelete"> 수정 </a></c:if>
	</div>
	<br><br><br>
	<h2> - REVIEW - </h2>
	<h3> 상품의 사용후기를 적어주세요. </h3>
	<div id = "ReviewDiv">
		<table id = "ReviewTable">
			<thead>
			<tr id = "ReviewTr">
				<th id = "ReviewTh" style="width: 100px;"> 번호 </th>
				<th id = "ReviewTh" style="width: 860px;"> 제목 </th>
				<th id = "ReviewTh" style="width: 110px;"> 아이디 </th>
				<th id = "ReviewTh" style="width: 150px;"> 작성일자 </th>
			</tr>
			<c:forEach var="review" items="${ReviewList}">
			<tr id = "ReviewTr">
				<td> ${review.reviewno} </td>
				<td> ${review.title} </td>
				<td> ${review.id} </td>
				<td> ${review.date} </td>
			</tr>
			</c:forEach>
			</thead>
			<tr>
				<td> 1 </td>
				<td>
					<button class="accordion">유하~</button>
					<div class="panel">
  						<p>게시글 내용</p>
					</div>
		<script>
			var acc = document.getElementsByClassName("accordion");
			var i;

			for (i = 0; i < acc.length; i++) {
  				acc[i].addEventListener("click", function() {
    				this.classList.toggle("active");
    				var panel = this.nextElementSibling;
    				if (panel.style.display === "block") {
      					panel.style.display = "none";
    				} else {
      					panel.style.display = "block";
    				}
  				});
			}
		</script>
				</td>
				<td> lhw9387 </td>
				<td> 2020-03-04 </td>
			</tr>
		</table>
		<br><br>
		<c:if test="${not empty sessionScope.id}">
		<a onclick="location.href='ReviewWrite?productno=${product.productno}'" class = "WriteBtn"> WRITE </a>
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