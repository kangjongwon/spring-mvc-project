<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function insert(){
		
		var param = $("#testForm").serializeObject();

		$.ajax({
	   		type: "POST"
	   		,url : "/test/testInsert"
	   		,data: JSON.stringify(param)
	   		,contentType:"application/json; charset=UTF-8" 
	   		,success:function(data){
	   			if(data.success){
	   				alert("등록성공");
	   			}else{
	   				alert("등록실패");
	   			}
				location.href="/test/testList";
	   		}
	   	});
	}
	
</script>
<head>
<script type="text/javascript" src="/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="/resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<link href="/resources/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>osc test </title>
</head>
<body>
<table>
	<tr>
		<td>관리자 : ${sessionScope.loginSession.dsLoginId} 님</td>
	</tr>
	<tr>
		<th>id</th>
		<th>sub</th>
		<th>name</th>
		<th>regDt</th>
		<th>del</th>
	</tr>
	<c:forEach items="${resultData.testList}" var="testList">
		<tr>
			<th>${testList.id}</th>
			<th><a href="/test/testDetail/${testList.id}">${testList.subject}</a></th>
			<th>${testList.name}</th>
			<th>${testList.regDt}</th>
			<th><a href="/test/testDelete/${testList.id}">삭제</a></th>
		</tr>
	</c:forEach>
</table>
<form name="testForm" id="testForm">
<table>
	<tr>
		<td>등록</td>
	</tr>
	<tr>
		<td>sub : <input type="text" name="subject"></td>
	</tr>
	<tr>
		<td>name : <input type="text" name="name"></td>
	</tr>
	<tr>
		<td><input type="button" value="등록" onclick="javascript:insert();"/></td>
	</tr>
</table>
</form>
</body>
<script>
$(document).ready(function(){
});
</script>
</html>
