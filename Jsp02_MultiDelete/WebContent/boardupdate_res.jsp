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

	//seq, title, content
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	MDBoardDto dto = new MDBoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	
	MDBoardBiz dao = new MDBoardBizImpl();
	
	int res = dao.update(dto);
	
	if (res > 0){
%>		
	<script type="text/javascript">
		alert("수정 성공!");
		location.href="boardselect.jsp?seq=<%=seq%>"
	
	</script>
<% 	
	} else { 
%>		
	<script type="text/javascript">
		alert("수정 실패!");
		location.href="boardupdate.jsp?seq=<%=seq%>"
	
	
	</script>
<% 		
	}		
%>



</body>
</html>