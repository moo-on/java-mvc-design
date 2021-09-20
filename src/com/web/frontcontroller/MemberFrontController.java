package com.web.frontcontroller;

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
		
		request.setCharacterEncoding("euc-kr"); // memberInsert에서 속성 저장 시 한글 값 깨짐 방지
		
		//분기 작업
		if(command.equals("/memberList.do")) {
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberVO> list = new ArrayList<>();
			
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
			rd.forward(request, response);
		}
		else if(command.equals("/memberInsert.do")) {
			// 1.파리미터 수집(VO)
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			String name= request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email= request.getParameter("email");
			String phone = request.getParameter("phone");
			
			/* 생성자로 바로 set해주기 잘안쓰인다.
			MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
			*/
			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPass(pass);
			vo.setName(name);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			
			//System.out.println(vo); // vo.toString()
			
			// model과의 연동
			MemberDAO dao = new MemberDAO();
			int cnt = dao.memberInsert(vo);
			PrintWriter out = response.getWriter();
			if(cnt == 1) {
				//성공
				//out.println("insert success");
				// Redirect기술로 회원 리스트 보기로 보내버림.
				response.sendRedirect("/jsp-tutorial/memberList.do");
			}else {
				//실패 예외객체 생성 후 WAS에게 전달
				throw new ServletException("not insert");
			}
		}
		else if(command.equals("/memberRegister.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("member/memberRegister.html");
			rd.forward(request, response);
		}
		
		else if(command.equals("/memberContent.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.memberContent(num);
			
			// 객체 바인딩
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
			rd.forward(request, response);
		}
		else if(command.equals("/memberUpdate.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			
			MemberVO vo = new MemberVO();
			vo.setNum(num);
			vo.setAge(age);
			vo.setEmail(email);
			vo.setPhone(phone);
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.memberUpdate(vo);

			if (cnt>0) {
				response.sendRedirect("/jsp-tutorial/memberList.do");
			}
			else {
				throw new ServletException("not insert");
			}
		}
		else if(command.equals("/memberDelete.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.memberDelete(num);
			if (cnt>0) {
				response.sendRedirect("/jsp-tutorial/memberList.do");
			}
			else {
				throw new ServletException("not insert");
			}
		}
		
	}

}
