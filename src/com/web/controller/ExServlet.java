package com.web.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.text.html.HTML;

import com.web.util.ExUtil;

/* 
 servlet의 골격
 1. HttpServlet 상속
 2. SE main과 같은 함수 생성 -> service 험수
 3. servlet, io 예외처리
 이러한 형태를 servlet이라고 부른다. 
 */
@WebServlet("/hs.do")
public class ExServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1~100까지의 합
		ExUtil ex = new ExUtil();
		int sum = ex.sum();
		
		// 응답
		// resp객체에 클라이언트의 ip,port 등(소켓 개념)의 정보가 담겨져 있고 
		// getWriter method로 PrintWriter라는 스트림을 생성한다.
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}
}
