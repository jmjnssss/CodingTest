<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	
	header{
		background-color: hotpink;
		height: 50px;
	}
	footer{
		background-color: hotpink;
		height: 30px;
		text-align: center;
		line-height: 30px;
	}

</style>
</head>
<body>

	<header>
		<a href="./boardlist.jsp">게시판 구현하기</a>
		<!-- ./ = 내 폴더 나와 같은 폴더 -->
		<!-- boardlist는 form폴더에 없고 웹컨텐츠파일에 있다. -->
		<!-- 근데 어차피 include 해서 boardlist에 있음 -->
		<!-- 그래서 ./ boardlist 사용 가능 -->
		
		<!-- 
		
			  / : 최상위 (root)
			 ./ : 나 자신이 속해져 있는 폴더
			../ : 상위 폴더	 
		
		 -->
	</header>

</body>
</html>