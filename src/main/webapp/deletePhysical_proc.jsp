<%@page import="com.physical.biz.info.impl.PhysicalDAO"%>
<%@page import="com.physical.biz.info.PhysicalVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 사용자 입력 정보 추출
	String seq = request.getParameter("seq");
	
	// 2. DB 연동 처리
	PhysicalVO vo = new PhysicalVO();
	vo.setSeq(Integer.parseInt(seq));
	
	PhysicalDAO physicalDAO = new PhysicalDAO();
	physicalDAO.deletePhysical(vo);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getPhysicalList.jsp");
%>