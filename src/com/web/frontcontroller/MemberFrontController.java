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
		
		// controller를 생성 후 request, response객체 넘겨줘서 일을 한 후 다음 페이지 까지 받아와서 넘겨주는 것이 pojo의 역할
		// List view
		HandlerMapping mapping = new HandlerMapping();
		controller = mapping.getController(command);
		nextPage = controller.requestHandler(request, response);
		
		// forward redirect 분리
		if(nextPage!=null) {
			if(nextPage.indexOf("redirect:")!=-1) {
				response.sendRedirect(nextPage.split(":")[1]); //redirect
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.makeView(nextPage));
				rd.forward(request, response);
			}
		}
		
	}

}
