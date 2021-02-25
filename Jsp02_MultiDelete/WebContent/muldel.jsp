<%@page import="com.muldel.dao.MDBoardDaoImpl"%>
<%@page import="com.muldel.dao.MDBoardDao"%>
<%@page import="com.muldel.biz.MDBoardBizImpl"%>
<%@page import="com.muldel.biz.MDBoardBiz"%>
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
	// chk=1&chk=2 ... 같은 이름으로 여러 개의 값이 전달되고 있을 때 사용
	String[] seqs = request.getParameterValues("chk");
	// 받은 값이 없다면
	if (seqs == null || seqs.length == 0) {
%>
	<!-- 유효성 검사 한번 더 하고 있음 -->
	<script type="text/javascript">
		alert("하나 이상 체크주세요!");
		location.href="boardlist.jsp"
	</script>	
<% 	
		} else {
			MDBoardBiz biz = new MDBoardBizImpl();
			// MDBoardDao도 되고 MDBoardBiz도 되는데 왜 되는걸까
			int res = biz.multidelete(seqs);
			if (res > 0){
%>
		<script type="text/javascript">
			alert("체크된 글들을 삭제 성공하였습니다.");
			location.href="boardlist.jsp";
		</script>
<%
			} else {
%>
		<script type="text/javascript">
			alert("선택 삭제 실패");
			loaction.href="boardlist.jsp";
		</script>

<% 		
			}
		}
%>




</body>
</html>










