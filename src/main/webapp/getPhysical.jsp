<%@page import="com.physical.biz.info.impl.PhysicalDAO"%>
<%@page import="com.physical.biz.info.PhysicalVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	// 1. 검색할 게시글 번호 추출
String seq = request.getParameter("seq");

// 2. DB 연동 처리
PhysicalVO vo = new PhysicalVO();
vo.setSeq(Integer.parseInt(seq));

PhysicalDAO physicalDAO = new PhysicalDAO();
PhysicalVO physical = physicalDAO.getPhysical(vo);

// 3. 화면 출력
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신체 정보 상세 보기</title>
</head>
<body>
	<center>
		<h1>신체 정보 상세 보기</h1>
		<a href="logout_proc.jsp">Log-out</a>
		<hr>
		<form action="updatePhysical_proc.jsp" method="post">
		<input name = "seq" type = "hidden" value ="<%= physical.getSeq() %>"/>
			<table border="1" cellpadding="0" celllspacing="0">
				<tr>
					<td bgcolor = "skyblue" width = "70">신장</td>
					<td align = "left"><input name = "height" type = "text" value = "<%= physical.getHeight() %>"/></td>
				</tr>
				<tr>
					<td bgcolor = "skyblue">체중</td>
					<td align="left"><input name = "weight" type = "text" value = "<%= physical.getWeight() %>" /></td>
				</tr>
				<tr>
					<td bgcolor = "skyblue">혈액형</td>
					<td align="left"><%= physical.getBlood() %></td>
				</tr>
				<tr>
					<td bgcolor = "skyblue">성별</td>
					<td align="left"><%= physical.getGender() %></td>
				</tr>
				<tr>
					<td bgcolor = "skyblue">등록일</td>
					<td align="left"><%= physical.getRegdate() %></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type = "submit" value = "신체 정보 수정" />
					</td>
				</tr>
			</table>
		</form>
		<hr>
		<a href="insertPhysical.jsp">신체정보등록</a>&nbsp;&nbsp;&nbsp;
		<a href="deletePhysical_proc.jsp?seq=<%= physical.getSeq() %>">신체정보삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getPhysicalList.jsp">신체정보목록</a>
	</center>
</body>
</html>