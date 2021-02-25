<%@page import="com.mvc.dao.MVCBoardDaoImpl"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="com.mvc.dao.MVCBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function deleteProc(seq) {
		if (confirm(seq+"번 글을 삭제하시겠습니까?")){
			location.href="mycontroller.jsp?command=delete&seq="+seq;
		}
	}

</script>
</head>
<%
	MVCBoardDto dto = (MVCBoardDto) request.getAttribute("dto");
											// controller에서 가져옴
	/*
	＊request.getParameter(key) : queryString으로 넘어온 key=value 의 형태에서, 넣어준 key에 맞는 value return
	int seq = Integer.parseInt(request.getParameter("seq")); // 요청받는 data들은 모두 문자열(String)
	MVCBoardDao dao = new MVCBoardDaoImpl();
	MVCBoardDto dto = dao.selectOne(seq);
	*/
%>
<body>

	<h1>SELECT</h1>
	
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='mycontroller.jsp?command=updateform&seq=<%=dto.getSeq()%>'">
																	<!-- 요청할 때 key=value해서 seq 같이 보냄 queryString-->
																	<!-- jsp뒤에 ? key = value 벨류는 무조건 문자열 (이 방식이 쿼리 스트링)-->
				<input type="button" value="삭제" onclick="deleteProc(<%=dto.getSeq()%>)">
				<input type="button" value="목록" onclick="location.href='mylist.jsp'">
			</td>
		</tr>
		
	
	</table>


</body>
</html>