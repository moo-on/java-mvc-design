package com.web.forward;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// forward 실습 전 redirect 기법 복습//
		
		String data = "apple";
		// View page(jsp)로 전달 후 출력
		response.sendRedirect("view/redirect.jsp?data="+data);
	}
}

/*
 redirect 기법은(queryString) 클라이언트가 서버에 기존 요청을 끊고 새로운 요청을 보내므로, request 객체 역시 새롭게 바뀐다.
 
 */