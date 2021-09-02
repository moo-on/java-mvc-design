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
		
		// forward �ǽ� �� redirect ��� ����//
		
		String data = "apple";
		// View page(jsp)�� ���� �� ���
		response.sendRedirect("view/redirect.jsp?data="+data);
	}
}

/*
 redirect �����(queryString) Ŭ���̾�Ʈ�� ������ ���� ��û�� ���� ���ο� ��û�� �����Ƿ�, request ��ü ���� ���Ӱ� �ٲ��.
 
 */