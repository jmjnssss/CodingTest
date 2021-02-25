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

	<h1>insert</h1>
	<!-- insert_res로 보내주기 위해 form 태그를 쓴다. -->
	<!-- action : 값을 전달 받을 경로 -->
	<!-- method : post 0번지부터 n번지까지 header 나머지는 body -->
	<!-- body는 무한대지만 header는 정해져있음 -->
	<!-- get은 header에 전달되지만 post는 body에 전달됨 -->
	<!-- 길이가 정해져있는 header보단 body에 전달되면 좋으니 post 쓴다. -->
	<form action="myinsert_res.jsp" method="post">
		<table border="1">
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성">
					<input type="button" value="취소" onclick="">
				</td>
			</tr>
		</table>	
	</form>
	
</body>
</html>









