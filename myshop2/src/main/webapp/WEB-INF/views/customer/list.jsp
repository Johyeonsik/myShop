<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
table{
	margin: 0px auto;
	overflow: hidden;
	margin-left: 30px;
}
th{
	text-align: left;
	font-size: 12px;
	font-weight: bold;
	padding: 10px;
	
}
td {
	text-align:left;
	border: hidden;
	font-size: 10px;
}
.title{
	border-bottom: 1px solid gray;
}
.btnPoint{
 	background-color: #E8DCCA;
 	border: none;
 	border-radius: 10px;
 	width: 40px;
 	margin-left: 10px;
 	cursor: pointer;
}
.btnUpdate, .btnDelete{
 	background-color: #E8DCCA;
 	border: none;
 	border-radius: 10px;
 	width: 40px;
 	cursor: pointer;
 	margin-left: -5px;
}
.btnAdd{
	background-color: coral;
	color: white;
 	border: none;
 	border-radius: 5px;
 	width: 80px;
 	cursor: pointer;
 	height: 35px;
 	margin-left: -30px;
}
.pagination a{
	font-size: 10px;
}
input[type=text]{
	border: 3px solid coral;
	height: 35px;
	border-radius: 5px;
}
input[type=button]{
	width: 50px;
	border: none;
	height: 35px;
	background: coral;
	border-radius: 5px;
	color: white;
}
</style>
<div id="page">
	
	<table id="tbl"></table>
	<script id="temp" type="text/x-handlebars-template">
			<tr>
				<th colspan=6 style="text-align:center; font-size: 15px">
					<span id="frm">
      					<input type="text" value="${param.keyword}" id="keyword" name="keyword"> 
     					<input type="button" value="검색" id="search">
    				</span>
				</th>
				<th>
					<button class="btnAdd">회원 추가</button>
				</th>
			</tr>
			<tr class="title">
				<th width=100>번호</th>
				<th width=100>이름</th>
				<th width=150>전화번호</th>
				<th width=200>적립금</th>
				<th width=150>가입일</th>
				<th width=100>수정</th>
				<th width=100>삭제</th>
			</tr>
		{{#each list}}
			<tr class = "row">
				<td>{{cus_no}}</td>
				<td>{{cus_name}}</td>
				<td>
					<span class = "tel">{{cus_tel}}</span>
				</td>
				<td>
					<span>{{display cus_point}}</span> &nbsp;원&nbsp;&nbsp;
					<button class="btnPoint">추가</button>
				</td>
				<td>
					<span class="date">{{cus_joindate}}</span>
				</td>
				<td>
					<button class="btnUpdate">수정</button>
				</td>
				<td>
					<button class="btnDelete">삭제</button>
				</td>
			</tr>
		{{/each}}
	</script>
	<div class="pagination"></div>
	<script>
		Handlebars.registerHelper("display", function(cus_point){
			return cus_point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		});
	</script>
</div>
<script>
	var page="${param.page==null ? 1: param.page}";
	var keyword="${param.keyword==null ? '': param.keyword}"

	getList();
	
	function getList(){
		$.ajax({
			type: "get",
			url: "/customer/list.json",
			data: {page:page, keyword:keyword},
			success:function(data){
				var template = Handlebars.compile($("#temp").html());
				$("#tbl").html(template(data));
				$(".pagination").html(getPagination(data));
				//추가 버튼 클릭시 
				$(".row").on("click",".btnPoint",function(){
					alert("이 버튼을 클릭하면 추가할 금액을 입력 할 수 있는 창을 띄울 예정입니다.")
				});
				
				$(".row").each(function(){
					//전화번호 포멧
					var num = $(this).find(".tel").html();
					var formatNum = '';

					if(num.length==11){
					    formatNum = num.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
					}else if(num.length==8){
					    formatNum = num.replace(/(\d{4})(\d{4})/, '$1-$2');
					}else if(num.indexOf('02')==0){
					    formatNum = num.replace(/(\d{2})(\d{4})(\d{4})/, '$1-$2-$3');
					}else{
					    formatNum = num.replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');
					}
						$(this).find(".tel").html(formatNum);
						
					//가입일 섭스트링
					var target = $(this).find(".date");
					var date = target.html().substring(0,11);
					target.html(date);
				});
				
			}
		});
	}
	$(".pagination").on("click", "a", function(e){
	     e.preventDefault();
	     page = $(this).attr("href");
	     getList();
	})
	$("#tbl").on("click", "#search", function(){
	   keyword = $("#keyword").val();
	   page = 1;
	   getList();
	})
	$("#tbl").on("keypress", "#keyword", function(e){
	   if(e.keyCode==13){
	      $("#search").click();
	   }
	})

</script>