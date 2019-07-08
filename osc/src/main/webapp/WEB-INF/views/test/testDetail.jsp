<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function update(){
		
		var param = $("#testForm").serializeObject();
		
		$.ajax({
	   		type: "POST"
	   		,url : "/test/testUpdate"
	   		,data: JSON.stringify(param)
	   		,contentType:"application/json; charset=UTF-8" 
	   		,success:function(data){
	   			if(data.success){
	   				alert("수정성공");
	   			}else{
	   				alert("수정실패");
	   			}
				location.href="/test/testList";
	   		}
	   	});
	}
	
	function moveList(){
		location.href="/test/testList";
	}
	
</script>
<head>
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>osc</title>
</head>
<body>
<form name="testForm" id="testForm">
<input type="hidden" name="id" value="${resultData.id}"/>
<table>
	<tr>
		<th>상세</th>
	</tr>
	<tr>
		<td>id : ${resultData.id}</td>
		<td>sub : <input type="text" name="subject" value="${resultData.subject}"></td>
	</tr>
	<tr>
		<td>cont : <input type="text" name="name" value="${resultData.name}"></td>
		<td>regDt : ${resultData.regDt}</td>
	</tr>
	<tr>
		<td><input type="button" value="수정" onclick="javascript:update();"/></td> 
		<td><input type="button" value="목록" onclick="javascript:moveList();"/></td>
	</tr>
</table>
</form>
</body>
</html>