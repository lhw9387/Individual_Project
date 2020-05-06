<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키작남_정보수정페이지</title>
<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<script src="https://kit.fontawesome.com/63b21adac5.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
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
    	text-align: left;
    	font-weight: normal;
    	background-color: #fff;
    	border-left: 0;
    	width:100px;
	}
	
	td{
		border-top: 1px solid #dfdfdf;
    	color: #353535;
    	font-size: 11px;
    	vertical-align: middle;
    	word-break: break-all;
    	word-wrap: break-word;
    	width:1100px;
    	height:44px;
	}
	
	input{
		height: 22px;
    	line-height: 22px;
    	padding: 2px 4px;
    	border: 1px solid #d5d5d5;
    	color: #353535;
    	font-size: 12px;
    	width:240px;
    	margin-left:5px;
	}
	
	span{
		font-size: 12px;
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
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
    
    	
    function pwdCheck(){
    	  var exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,16}$/;
    	  var pwd = document.getElementById("pwd");
    	  
    	  if(pwd.value.match(exp)){
    	      document.getElementById("pck").style.color = "blue";
    	      document.getElementById("pck").innerHTML = "<b> 적합한 비밀번호입니다.</b> ";
    	  } else {
    	      document.getElementById("pck").style.color = "red";
    	      document.getElementById("pck").innerHTML = "<b> 적합하지 않은 비밀번호입니다.</b> ";

    	  }
    	}

    	function checkReset(){
    	  document.getElementById("pck").innerHTML = "";
    	}

    	function pwdConfirm1(){
    	  var pwd = document.getElementById("pwd").value;
    	  var pwdConfirm = document.getElementById("pwdConfirm").value;
    	  var confirmMsg = document.getElementById("confirmMsg");
    	  if(pwd == pwdConfirm){
    	      confirmMsg.style.color="blue";
    	      confirmMsg.innerHTML = "비밀번호 일치";
    	  } else {
    	      confirmMsg.style.color="red";
    	      confirmMsg.innerHTML="비밀번호 불일치";
    	  }
    	}

    	function checkReset2(){
    	  document.getElementById("confirmMsg").innerHTML = "";
    	}		
    	
    	function email_change() {
    		if (document.join.email.options[document.join.email.selectedIndex].value == '0') {
    			document.join.email2.disabled = true;
    			document.join.email2.value = "";
    		}
    		if (document.join.email.options[document.join.email.selectedIndex].value == '9') {
    			document.join.email2.disabled = false;
    			document.join.email2.value = "";
    			document.join.email2.focus();
    		} else {
    			document.join.email2.disabled = true;
    			document.join.email2.value = document.join.email.options[document.join.email.selectedIndex].value;
    		}
    	}
    	
    	function onSubmit() {

    		if(!ok()){
    			return false;
    		};

    		console.log("submit1")

    		if (!idCheck()) {
    			console.log("submit")
    			alert("ID를 확인해주세요.");
    			document.getElementById("idForm").value = "";
    			document.getElementById("idForm").focus();
    			return false;
    		}

    		if (!pwdCheck()) {
    			alert("비밀번호를 확인해주세요.");
    			document.getElementById("pwd").value = "";
    			document.getElementById("pwd").focus();
    			return false;
    		}

    		if (!pwdConfirm1()) {
    			alert("비밀번호 재확인이 틀립니다.");
    			document.getElementById("pwdConfirm").value = "";
    			document.getElementById("pwdConfirm").focus();
    			return false;
    		}

    		signForm.submit();
    	}
    	    	  

    	// 휴대폰 번호 정규식	
    	  function phoneCheck(){
    	    var exp = /^\d{3}-\d{4}-\d{4}$/;
    	    var phone = document.getElementById("phone");
    	    
    	    if(phone.value.match(exp)){
    	        document.getElementById("phoneCheck").style.color = "blue";
    	        document.getElementById("phoneCheck").innerHTML = "<b> 적합한 휴대폰 번호입니다.</b> ";
    	    } else {
    	        document.getElementById("phoneCheck").style.color = "red";
    	        document.getElementById("phoneCheck").innerHTML = "<b> 적합하지 않은 휴대폰 번호입니다.</b> ";
    	  
    	    }
    	  }
    	  
    	  function checkReset3(){
    	    document.getElementById("phoneCheck").innerHTML = "";
    	  }
    	  
    	  
    	// 로그아웃
    	  function logout(){
    		  location.href="MemberLogout";
    	  }    
    	
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
			<c:if test="${sessionScope.id eq 'admin'}"><a href="MemberList"> 상품 추가 </a></c:if>
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
	<h1> MODIFY</h1>
	<form action="MemberModify" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>
					아이디
				</th>
				<td>
					<input type="text" name="id" onkeyup="idCheck()"
					id="idForm"
                	value=" ${member.id}" 
                	onblur="checkReset1()"
                	readonly
                	>
				</td>
			</tr>		
			<tr>
				<th>
					비밀번호
				</th>
				<td>
					<input type="password" name="password" id="pwd" onkeyup="pwdCheck()" onblur="checkReset()" placeholder=" 영문 대소문자/숫자/특수문자 조합 8자~16자">
					&nbsp;
                <span id="pck"></span>
				</td>
			</tr>
			<tr>
				<th>
					비밀번호 확인
				</th>
				<td>
					<input type="password" id="pwdConfirm" onkeyup="pwdConfirm1()" onblur="checkReset2()"  placeholder=" 비밀번호 재확인">
                &nbsp;
                <span id="confirmMsg"></span>
            	</td>
			</tr>
			<tr>
				<th>
					이름
				</th>
				<td colspan="3">
					<input type="text" name="name" value=" ${member.name}" readonly>
				</td>
			</tr>
			<tr>
				<th>
					이메일
				</th>
				<td colspan="3">
					<input type="email" name="email" value=" ${member.email}">
				</td>
			</tr>
			<tr>
				<th>
					주소
				</th>
				<td colspan="3">
					<div class="field-wrap">
					<input type="text" name="postcode" id="sample6_postcode" placeholder=" 우편번호">&nbsp;
					<input type="button" id = "addressbtn" onclick="sample6_execDaumPostcode()" value=" 우편번호 찾기"><br><br>
					<input type="text" name="address2" id="sample6_address" placeholder=" 주소">&nbsp;
					<input type="text" name="detailAddress" id="sample6_detailAddress" placeholder=" 상세주소">&nbsp;
					<input type="text" name="extraAddress" id="sample6_extraAddress" placeholder=" 참고항목">
					</div>
					
				</td>
			</tr>
			<tr>
				<th>
					휴대폰 번호
				</th>
				<td colspan="3">
				 <input type="text" name="phone" id="phone" onkeyup="phoneCheck()" onblur="checkReset3()" value=" ${member.phone}">
                &nbsp;
                <span id="phoneCheck"></span>
				</td>
			</tr>
		</table>
		<br>
		
		<button id=btn2 onclick = "onSubmit()"> 정보 수정 </button>
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