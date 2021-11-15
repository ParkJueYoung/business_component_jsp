<%@page import="com.physical.biz.info.PhysicalVO"%>
<%@page import="com.physical.biz.info.impl.PhysicalDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 1. 사용자 입력 정보 추출
	// 2. DB 연동 처리
	PhysicalVO vo = new PhysicalVO();
	PhysicalDAO physicalDAO = new PhysicalDAO();
	List<PhysicalVO> physicalList = physicalDAO.getPhysicalList(vo);

	// 3. 화면 구성
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신체 정보 목록</title>
</head>
<body>
	<center>
		<h1>신체 정보 목록</h1>
		<h3>
			환영합니다. <a href="logout_proc.jsp">Log-out</a>
		</h3>

		<form action="getPysicalList.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<!-- <tr>
					<td align="right"><select name="searchCondition">
							<option>value = "">
							<option>value = "">
					</select>
						<input name="searchKeyword" type="text" />
						<input type="submit" value="검색" />
					</td>
				</tr> -->
			</table>
		</form>
		
		<table border = "1" cellpadding = "0" cellspacing = "0" width = "700">
		<tr>
			<th bgcolor = "skyblue" width = "100"> 등록번호 </th>
			<th bgcolor = "skyblue" width = "100"> 신장 </th>
			<th bgcolor = "skyblue" width = "100"> 체중 </th>
			<th bgcolor = "skyblue" width = "100"> 혈액형 </th>
			<th bgcolor = "skyblue" width = "100"> 성별 </th>
			<th bgcolor = "skyblue" width = "100"> 등록일 </th>
		</tr>
		
		<% for(PhysicalVO physical : physicalList){ %>
		
		<tr>
			<td><%= physical.getSeq() %></td>
			<td align = "left"><a href="getPhysical.jsp?seq=<%= physical.getSeq() %>">
								<%= physical.getHeight() %></a></td>
			<td><%= physical.getWeight() %></td>
			<td><%= physical.getBlood() %></td>
			<td><%= physical.getGender() %></td>
			<td><%= physical.getRegdate() %></td>
		</tr>
		<% } %>	
		</table>
		<br>
		<a href = "insertPhysical.jsp">새글 등록</a>
	</center>
</body>
</html>

