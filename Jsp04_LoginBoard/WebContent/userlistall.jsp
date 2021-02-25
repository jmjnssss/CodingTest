<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
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
	List<MYMemberDto> list = (List<MYMemberDto>)request.getAttribute("list");
%>	

	<h1>회원 전체 조회(탈퇴 포함)</h1>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>가입여부</th>
			<th>등급</th>
		</tr>
<%
	for (MYMemberDto dto : list){
%>
		<tr>
			<td><%=dto.getMyno() %></td>
			<td><%=dto.getMyid() %></td>
			<td><%=dto.getMypw() %></td>
			<td><%=dto.getMyname() %></td>
			<td><%=dto.getMyaddr() %></td>
			<td><%=dto.getMyphone() %></td>
			<td><%=dto.getMyemail() %></td>
			<td><%=dto.getMyenabled().equals("Y")? "가입" : "탈퇴" %></td>
			<td><%=dto.getMyrole() %></td>
		</tr>
		<!--500 에러 뜨면 dao, biz 그다음은 list 확인 -->
<% 		
	}
%>	
		<tr>
			<td colspan="9" align="right">
				<input type="button" value="메인" onclick="">
			</td>
		</tr>	
	</table>





</body>
</html>


















