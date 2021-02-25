<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
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
	
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command); // 지금 내가 어디로 가고 싶다를 출력
	
	MVCBoardBiz biz = new MVCBoardBizImpl();

	// 요청한 명령을 확인한다.
	if (command.equals("list")) {
		// 1. 보내준 값이 있으면, 받는다.
		// 2. db에 전달할 값이 있으면, 전달하고,
		//	  없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectList();
		
		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		request.setAttribute("list", list);
		// 무슨 type인지 모르니까 list를 Object로 감싸줌 
		// request가 맨위 setCharacterEncoding이랑 똑같나요? -> 네, 맞습니다.
		
		// 4. 보낸다.
		pageContext.forward("mylist.jsp");
		// 주소창 : mycontroller.jsp?command=list (페이지 위임)
		
	} else if (command.equals("insertform")){
		// 1.
		// 2.
		// 3.
		/*
			request.setAttribute("list", "a");
			얘는 안됨 새로 요청하는거니까..
		*/	
		// 4.
		response.sendRedirect("myinsert.jsp");
		// 주소창 : myinsert.jsp (페이지 이동)
		/*
			pageContext.forward()   : 페이지 위임 (request, response 객체가 그대로 전달) ＊ 니가 대신가
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체) 	＊ 다시 요청하세요 
									  redirect할 땐, 1,2,3 해봤자 다음 페이지에 전달이 안됨

		*/
		
	} else if (command.equals("insertres")){
		// 1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 2.
		MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
		int res = biz.insert(dto);
		
		// 3. 전달할 값 없으니까 안할거임
		// 4.
		if (res>0){		
%>
	<script type="text/javascript">
			alert("글 작성 성공");
			location.href='mycontroller.jsp?command=list';
		</script>
	<%
		} else {
%>
	<script type="text/javascript">
			alert("글 작성 실패");
			location.href='mycontroller.jsp?command=insertform';
		</script>

	<% 		
		}
		
		} else if(command.equals("selectone")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			MVCBoardDto dto = biz.selectOne(seq);
			// 3.
			request.setAttribute("dto", dto);
			// 4.
			pageContext.forward("myselect.jsp");
			
		
		
		} else if(command.equals("updateform")) {
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			MVCBoardDto dto = biz.selectOne(seq);
			// 3.
			request.setAttribute("dto", dto);
			// 4.
			pageContext.forward("myupdate.jsp");
		
		
		} else if (command.equals("updateres")){
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			// 2.
			MVCBoardDto dto = new MVCBoardDto(seq, null, title, content, null);
			int res = biz.update(dto);
			/*
				화면에서 바로 db로 연결하던거 여기에서 해줌
			*/
			// 3. 전달할 값 없으니까 안할거임
			// 4.
			if (res>0){		
%>
				<script type="text/javascript">
					alert("수정 성공");
					location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>";
				</script>
<%
			} else {
%>
				<script type="text/javascript">
					alert("수정 실패");
					history.back();
					// location.href='mycontroller.jsp?command=updateform';
				</script>

	<%	
			}
			
		} else if (command.equals("delete")){
			// 1.
			int seq = Integer.parseInt(request.getParameter("seq"));
			// 2.
			int res = biz.delete(seq);
			// 3.
			// 4.
			if (res > 0){
%>
			<script type="text/javascript">
				alert("삭제 성공");
				location.href="mycontroller.jsp?command=list";
			</script>

<% 				
			} else {
%>
			<script type="text/javascript">
				alert("삭제 실패");
				location.href="mycontroller.jsp?command=selectone&seq=<%=seq%>";
			</script>
<% 				
			}	
		}

%>

</body>
</html>















