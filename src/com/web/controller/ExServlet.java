package com.web.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.text.html.HTML;

import com.web.util.ExUtil;

/* 
 servlet�� ���
 1. HttpServlet ���
 2. SE main�� ���� �Լ� ���� -> service ���
 3. servlet, io ����ó��
 �̷��� ���¸� servlet�̶�� �θ���. 
 */
@WebServlet("/hs.do")
public class ExServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1~100������ ��
		ExUtil ex = new ExUtil();
		int sum = ex.sum();
		
		// ����
		// resp��ü�� Ŭ���̾�Ʈ�� ip,port ��(���� ����)�� ������ ����� �ְ� 
		// getWriter method�� PrintWriter��� ��Ʈ���� �����Ѵ�.
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(sum);
		out.println("</body>");
		out.println("</html>");
	}
}
