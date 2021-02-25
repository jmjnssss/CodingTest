<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@page import="com.muldel.dto.MDBoardDto"%>
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
	/*
		getParameter : 웹브라우저에서 전송받은 request 영역에서 
					   name값이 일치하는 것을 읽어옴
		리턴타입 : String
	 */
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	/*
		client -> server -> DB
	   	 dto에 담아서 DB까지 전달 
	*/
	
	MDBoardDto dto = new MDBoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	MDBoardDao dao = new MDBoardDaoImpl();
	
	int res = dao.insert(dto);
	
	if (res > 0){
		// insert 된 row의 갯수
		
%>		
	<script type="text/javascript">
		alert("작성 성공");
		location.href="boardlist.jsp";
	</script>
	
<%	
	} else {
%>	
	<script type="text/javascript">
		alert("작성 실패");
		location.href="boardinsert.jsp";
	</script>
<% 	
	}
%>









</body>
</html>











