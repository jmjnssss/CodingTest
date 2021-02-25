<%@page import="com.login.dto.MYMemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	MYMemberDto dto = (MYMemberDto)session.getAttribute("dto");

	if (dto == null) {
		pageContext.forward("index.html");
	}
%>
<body>

	<div>
		<span><b><%=dto.getMyid() %>님 환영합니다.</b></span>
		<a href="logincontroller.jsp?command=logout">logout</a>
	</div>

	<div>
		<a href="logincontroller.jsp?command=updateuserform&myno=<%=dto.getMyno()%>">마이페이지 </a>
	</div>
	<div>
		<a href="logincontroller.jsp?command=enableduserform&myno=<%=dto.getMyno()%>">회원 탈퇴하기 </a>
	</div>



</body>
</html>