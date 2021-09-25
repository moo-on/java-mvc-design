package com.web.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controller.Controller;
import com.web.controller.MemberContentController;
import com.web.controller.MemberDeleteController;
import com.web.controller.MemberInsertController;
import com.web.controller.MemberListController;
import com.web.controller.MemberRegisterController;
import com.web.controller.MemberUpdateController;
import com.web.model.MemberDAO;
import com.web.model.MemberVO;

import java.util.*;
/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		String ctx = request.getContextPath(); // ctx = jsp-tutorial
		String command = url.substring(ctx.length()); // URI= jsp-tutorial/memberInster.do, command = memberInsert.do
		System.out.println(command);
		request.setCharacterEncoding("euc-kr"); // memberInsert에서 속성 저장 시 한글 값 깨짐 방지
		
		Controller controller = null; 
		String nextPage = null;
		//분기 작업
		// List view
		if(command.equals("/memberList.do")) {
			controller = new MemberListController();
			nextPage = controller.requestHandler(request, response);
			// controller를 생성 후 request, response객체 넘겨줘서 일을 한 후 다음 페이지 까지 받아와서 넘겨주는 것이 pojo의 역할
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
		// insert func
		else if(command.equals("/memberInsert.do")) {
			controller = new MemberInsertController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
		}
		// register view
		else if(command.equals("/memberRegister.do")) {
			controller = new MemberRegisterController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");
			rd.forward(request, response);
		}
		// content view
		else if(command.equals("/memberContent.do")) {
			controller = new MemberContentController();
			nextPage = controller.requestHandler(request, response);
			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}
		// Update func
		else if(command.equals("/memberUpdate.do")) {
			controller = new MemberUpdateController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
		}
		// Delete func
		else if(command.equals("/memberDelete.do")) {
			controller = new MemberDeleteController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);
		}
		
	}

}
