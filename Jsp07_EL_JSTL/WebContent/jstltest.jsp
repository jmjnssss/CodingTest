<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL : Jsp Standard Tag Library</h1>
	
	<table border="1">
		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>
		<c:forEach items="${list }" var="score">
			<tr>
				<td>
					<!-- eq: == / ne: != / empty: null -->
					<!-- choose -> html태그처럼 보이지만 자바 컴파일은 JVM에서 해줌
								   결국 서버에서 해주는거 -->
					<c:if test="${score.name eq '이름10'}">
						<c:out value="홍길동"></c:out>
					</c:if>
					<c:choose>
						<c:when test="${score.name eq '이름20'}">
							<c:out value="${score.name }님!"></c:out>
						</c:when>
						<c:when test="${score.name eq '이름30'}">
							<c:out value="${score.name }님!"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="누구지?"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>
				<td>
					<c:choose>
						<c:when test="${score.grade eq'A' || score.grade eq 'B' }">
							<c:out value="PASS"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="FAIL"></c:out>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<c:forEach var="i" begin="1" end="20" step="2">
		${i*2 }<br/>
	</c:forEach>
	
	<!-- 구구단 출력 -->
	<table border="1">
	<tr>
	
	<c:forEach var="i" begin="1" end="9" >
		<td colspan="9" align="center">${i }<c:out value="단"></c:out></td>
		<tr>
		<c:forEach var="j" begin="2" end="9">
			<td>${j }x${i }=${i*j }</td>
		
		</c:forEach>
		</tr>
	</c:forEach>
	</tr>
	
	</table>

</body>
</html>