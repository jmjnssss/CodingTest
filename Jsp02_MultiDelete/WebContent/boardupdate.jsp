<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.dto.MDBoardDto"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// client와 server가 request(요청)하고 response(응답)할 때는 무조건 String이다.
	int seq = Integer.parseInt(request.getParameter("seq"));
	// 보내고 받을 땐 문자열로 받기 때문에 숫자로 다시 바꿔줌 ＊myselect에서 보낸 myno 받아줌
	MDBoardDao dao = new MDBoardDaoImpl();
	MDBoardDto dto = dao.selectOne(seq);
	

%>
</head>
<body>

	<h1>수정</h1>
	
	<form action="boardupdate_res.jsp" method="post"> <!-- post인 이유 길어지면 오류날 수 있어서 -->
	<!-- ./ 생략 가능 (root, 자기 자신, 상위 폴더-->
		<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=dto.getWriter() %></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"><%=dto.getContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정">
					<input type="button" value="취소" onclick="">
				</td>
			</tr>
		</table>
	</form>














</body>
</html>