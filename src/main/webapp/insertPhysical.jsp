<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신체 정보 등록</title>
</head>
<body>
<center>
<h1>신체 정보 등록</h1>
<a href = "logout_proc.jsp">Log-out</a>
<hr>
<form action = "insertPhysical_proc.jsp" method = "post">
<table border = "1" cellpadding = "0" cellspacing = "0">
	<tr>
		<td bgcolor = "skyblue">신장</td><td align = "left">
	 	<input type = "text" name = "height"/></td>
	 </tr>
	 <tr>
	 	<td bgcolor = "skyblue">체중</td><td align = "left">
	 	<input type = "text" name = "weight"/></td>
	 </tr>
	 <tr>
	 	<td bgcolor = "skyblue">혈액형</td><td align = "left">
	 	<input type = "text" name = "blood"/></td>
	 </tr>
	 <tr>
	 	<td bgcolor = "skyblue">성별</td><td align = "left">
	 	<input type = "text" name = "gender"/></td>
	 </tr>
	 <tr>
	 	<td colspan "2" align = "center">
	 	<input type = "submit" value = "신체 정보 등록" /></td>
	 </tr>
</table>
</form>
<hr>
<a href = "getPhysicalList.jsp">신체 정보 목록 가기</a>
</center>
</body>
</html>