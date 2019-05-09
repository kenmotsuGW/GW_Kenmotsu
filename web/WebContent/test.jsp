<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>転送できたよ</title>
</head>
<body>
	<h1>ごちそうさまです。</h1>

	sessionで送られたnameは「<%= session.getAttribute("name") %>」<br>
	requestで送られたageは「<%= request.getAttribute("age") %>」
</body>
</html>