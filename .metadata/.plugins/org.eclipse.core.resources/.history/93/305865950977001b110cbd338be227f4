<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
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
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");
	// list를 (최상위-모든 것을 상속해줌) object로 받아줌 그래서 명시적 형변환 필요
%>
<body>

	<h1>List</h1>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
		for (MVCBoardDto dto : list){
%>	
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="mycontroller.jsp?command=selectone&seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getRegdate() %></td>
		</tr>
<%
		}
%>		
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='mycontroller.jsp?command=insertform'">
			</td>
		</tr>
	</table>
	
	









</body>
</html>




















