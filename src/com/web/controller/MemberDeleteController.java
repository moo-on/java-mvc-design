package com.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.MemberDAO;

/**
 * Servlet implementation class MemberDeleteController
 */

public class MemberDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		String nextPage = null;
		if (cnt>0) {
			nextPage = "redirect:/jsp-tutorial/memberList.do";
		}
		else {
			throw new ServletException("not insert");
		}
		return nextPage;
	}
	
	

}
