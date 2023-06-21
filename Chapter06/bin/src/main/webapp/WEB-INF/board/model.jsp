<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% //이건 전통적 방식. 아래에 있는 퍼센트 안에 데이터.<!-- 2.전통적방식 -->
String data = (String)request.getAttribute("data");
%>


<html>
<head>
<meta charset="UTF-8">
<title>Model</title>
</head>
<body>
	<h1>Model</h1>
	<h2>${data}</h2>
	<h2><%=data %></h2> <!-- 2.전통적방식 -->
	<c:forEach ${list}>	<!-- 리스트도 이런식으로 -->
	</c:forEach>
</body>
</html>