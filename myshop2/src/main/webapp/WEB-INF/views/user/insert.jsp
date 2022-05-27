<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<style>
input:focus {outline:none;}

@font-face {
    font-family: 'LeferiPoint-WhiteObliqueA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/LeferiPoint-WhiteObliqueA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
table, tr, td{
	font-family: 'LeferiPoint-WhiteObliqueA';
	border: none;
}
input[type="password"]{
	color: #323232;
	font-family: 'LeferiPoint-WhiteObliqueA';
	font-size: 10px;
}
input[type="text"]{
	color: #323232;
	font-family: 'LeferiPoint-WhiteObliqueA';
	font-size: 10px;
}
input, select {
	height: 30px;
	border: 1px solid #323232;
	border-radius: 10px;
}
table{
	margin: 0px auto;
	margin-left: 333px;
	margin-bottom: 50px;

}
.title {
	width: 50px;
	font-weight: bold;
	font-size: 12px;
}
select, option{
	width: 132px;
	text-align: center;
}
button {
	margin-left: 10px;
	height: 30px;
	border: none;
	background-color: #FF6F61;
	color: white;
	border-radius:10px;
	box-shadow: 2px 2px 5px #323232;
}
button:hover{
	background-color: #E2b9b3;
	margin-left: 10px;
	height: 30px;
	border: none;
	color: white;
	border-radius:10px;
	box-shadow: 2px 2px 5px #323232;
}

</style>
<div id="page">
	<h1>회원가입</h1>
	
	<form id="frm" action="insert" method="post">
		<table>
			<tr>
				<td class="title" width=100>아이디</td>
				<td>
					<input type="text" name="id">
					<button type="button" id="check">중복체크</button>
				</td>
				
			</tr>
			<tr>
				<td class="title" width=100>패스워드</td>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td class="title" width=100>패스워드확인</td>
				<td><input type="password" name="passchk"></td>
			</tr>
			<tr>
				<td class="title" width=100>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td class="title" width=100>타입</td>
				<td>
					<select>
						<option value="관리">관리자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="title" width=100>전화번호</td>
				<td><input type="text" name="tel"></td>
			</tr>
		</table>
		<div style="text-align: center;">
			<button type="submit">회원가입</button>
			<button type="reset">가입취소</button>
		</div>
	</form>
</div>
<script>
	var check=false;
	
	
	//중복체크 버튼을 클릭한 경우
	$("#check").on("click",function(){
		var id=$(frm.id).val();
		if(id==""){
			alert("아이디를 입력하세요");
			$(frm.id).focus();
		}
		$.ajax({
			type:"post",
			url:"/user/login",
			data:{id:id},
			success: function(data){
				if(data==0) {
					alert("사용가능한 아이디 입니다.");
					check=true;
				}else {
					alert("이미 가입된 아이디 입니다.");
				}
			}
		});
	});
	
	//회원가입 버튼을 클릭한 경우
	$(frm.id).on("change", function(){
		check=false;
	});
	
	$(frm).on("submit", function(e){
		e.preventDefault();
		
		if(!check) {
			alert("아이디 중복체크를 하세요");
			return;
		}
		
		var pass=$(frm.pass).val();
		var passchk=$(frm.passchk).val();
		var name=$(frm.name).val();

		
		
		if(pass == ""){
			alert("비밀번호를 입력하세요");
			$(frm.pass).focus();
			return;
		}else if(name == ""){
			alert("이름을 입력하세요!");
			$(frm.name).focus();
			return;
		}else if(pass != passchk){
			alert("비밀번호가 다릅니다");
			$(frm.pass).focus();
		}else{
			if(!confirm("회원가입하실래요?")) return;
			frm.submit();
		}
	});
	
</script>