package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dto.MVCBoardDto;

import cpm.mvc.biz.MVCBoardBiz;
import cpm.mvc.biz.MVCBoardBizImpl;


@WebServlet("/MVCController")
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF8");
	
		MVCBoardBiz biz = new MVCBoardBizImpl(); 
	
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
	
		if(command.equals("list")) {
			// 1.
			
			// 2.
			
			// 3.
			
			// 4.
			response.sendRedirect("mvclist.jsp");
			
		
		} else if(command.equals("insertform")) {
			response.sendRedirect("myinsert.jsp");
			
		} else if(command.equals("insertres")) {
			// 1.
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// 2.
			MVCBoardDto dto = new MVCBoardDto(0, writer, title, content, null);
			int res = biz.insert(dto);
			// 3.
			// 4.
			if (res > 0) {
				response.sendRedirect("mvc.do?command=list");
			} else {
				response.sendRedirect("mvc.do?command=insertform");
			}
			
			
			
		} else if(command.equals("selectone")) {
			
		}
		
	
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
		
	}

}
