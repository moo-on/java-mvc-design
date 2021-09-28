package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.MemberDAO;
import com.web.model.MemberVO;

/**
 * Servlet implementation class MemberContentController
 */

public class MemberContentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberContent(num);
		
		// °´Ã¼ ¹ÙÀÎµù 
		request.setAttribute("vo", vo);
		return "memberContent";
	}
       
	
}
