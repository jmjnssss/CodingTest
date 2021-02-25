<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.board.dao.MyBoardDao"%>
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
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectList();
%>
<body>

	<h1>selectList</h1>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
<%
	for (MyBoardDto dto : list){
%>		
		<tr>
			<td><%=dto.getSeq() %></td>
			<td><%=dto.getWriter() %></td>
			<td><a href="myselect.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
			<!-- ＊?seq= 쓰는 이유 : 해당 번호 글 하나만 보고싶어서 (key = value) -->
			<td><%=dto.getRegdate() %></td>
		</tr>
<%
	}
%>		
		<tr>
			<td colspan="4">
				<input type="button" value="글작성" onclick="location.href='myinsert.jsp'">
			</td>
		</tr>
		
	</table>

</body>
</html>















