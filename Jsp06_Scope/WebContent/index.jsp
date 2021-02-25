<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("pageId", "my pageContext value");
	request.setAttribute("requestId", "my request value");
	session.setAttribute("sessionId", "my session value");
	application.setAttribute("applicationId", "my application value");
%>

	<h1>INDEX</h1>
	
	pageId : <%=pageContext.getAttribute("pageId") %><br/>
	requestId : <%=request.getAttribute("requestId") %><br/>
	sessionId : <%=session.getAttribute("sessionId") %><br/>
	applicationId : <%=application.getAttribute("applicationId") %><br/>
	
	<a href="result.jsp">result</a><br/>
	<form action="scope.do" method="post">
		<input type="hidden" name="myRequest" value="my request value 2">
		<input type="submit" value="controller">
	</form>

	<% //pageContext.forward("scope.do"); %>
	<!--
		자바니까 주석처리 // 	
		index로 안넘어가고 Result로 넘어감 
		근데 requestId가 나온다? 
	-->
	<!-- 
	
		setAttribute : request에 담기 -> 객체
		getAttribute : 담아둔거 가져오기
		
		setParameter : ?
		*do?k=v
		<form action="*.do">
			<input type="" name="k" value="v">
		getParameter : 전달된거 받아오기 -> String 
		
	-->
</body>
</html>

















