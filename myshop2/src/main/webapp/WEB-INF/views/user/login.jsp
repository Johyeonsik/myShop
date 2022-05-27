<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
input:focus {outline:none;}

@font-face {
    font-family: 'LeferiPoint-WhiteObliqueA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
input[type="password"]{
	color: #323232;
	font-family: 'LeferiPoint-WhiteObliqueA';
	font-size: 10px;
}
input[type="text"]{
	color: #323232;
	v 'LeferiPoint-WhiteObliqueA';
	font-size: 10px;
}
#idBox{
	text-align: center;
}
input, select {
	width: 200px;
	height: 30px;
	border: none;
	border-bottom: 0.2px solid #323232;
	padding: 10px;
}
button {
	width:200px;
	height: 40px;
	border: none;
	background-color: #FF6F61;
	color: white;
	box-shadow: 2px 2px 5px #323232;
	margin-left: 1px;
	margin-bottom: 10px;
	padding: 10px;
}
button:hover{
	width:200px;
	height: 40px;
	background-color: #E2b9b3;
	margin-left: 10px;
	border: none;
	color: white;
	box-shadow: 2px 2px 5px #323232;
}
a{
	font-size: 10px;
	text-decoration: none;
	color: #323232;
}
#insert{
	margin-left: 1px;
}
#findPass{
	margin-left: 100px;
}
#idBox{
	margin: 0px auto;
	padding-top: 20px;
	width: 300px;
	height: 250px;
	border: 10px solid #E2b9b3;
	border-radius: 30px;
}
#logText{
	font-family:'Cafe24Ohsquareair';
	font-size:20px;
	font-weight: bold;
	color: #323232;
}
</style>

<div id="page">
	<form name="frm" method="post">
		<div id="idBox">
			<div>
				<p id="logText">로 그 인</p>
			</div>
			<div>
				<p><input type="text" name="id" placeholder="아이디"></p>
			</div>
			<div>
				<p><input type="password" name="pass" placeholder="패스워드"></p>
			</div>
			<div>
				<button type="submit">로그인</button><br>
				<span id="insert"><a href="insert">회원가입</a></span>
				<span id="findPass"><a href="findPass">비밀번호 찾기</a></span>
			</div>
		</div>
	</form>

</div>

<script>
 $(frm).on("submit",function(e){
	 e.preventDefault();
	 var id=$(frm.id).val();
	 var pass=$(frm.pass).val();
	 if(id=="" || pass==""){
		 alert("아이디나 비밀번호를 입력하세요");
		 $(frm.id).focus();
		 return;
	 }
	 
	 $.ajax({
		type:"post",
		url:"/user/login",
		data:{id:id, pass:pass},
		success:function(data){
			if(data==0){
				alert("존재하지 않는 아이디 입니다.");
			}else if(data==2){
				alert("비밀번호가 일치하지 않습니다")
			}else if (data==1) {
				var dest="${dest}";
				if(dest== null || dest==""){
					location.href="/";
				}else {
					location.href=dest;
				}
			}
			
		}
	 });
 });
</script>