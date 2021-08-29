package com.web.controller;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.MemberDAO;
import com.web.model.MemberVO;


@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청 받기 (memberList.do)
		// 2. 회원전체 리스트 가져오기 (model 연동)
		MemberDAO dao  = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberList();
		// 3. 회원전체리스트 html로 만들어 응답
		response.setContentType("text/html;charset=utf-8"); // MIME-TYPE
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script>");
		out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table class='table table-bordered'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>번호</th>");
		out.println("<th>아이디</th>");
		out.println("<th>비밀번호</th>");
		out.println("<th>이름</th>");
		out.println("<th>나이</th>");
		out.println("<th>이메일</th>");
		out.println("<th>전화번호</th>");
		out.println("<th>삭제</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		
		
		for(MemberVO vo : list) {
			out.println("<tr>");
			out.println("<td>"+vo.getNum()+"</td>");
			out.println("<td><a href='/jsp-tutorial/memberContent.do?num="+vo.getNum()+"'>"+vo.getId()+"</a></td>");
			out.println("<td>"+vo.getPass()+"</td>");
			out.println("<td>"+vo.getName()+"</td>");
			out.println("<td>"+vo.getAge()+"</td>");
			out.println("<td>"+vo.getEmail()+"</td>");
			out.println("<td>"+vo.getPhone()+"</td>");
			out.println("<td><a href='/jsp-tutorial/memberDelete.do?num="+vo.getNum()+"'>삭제</a></td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("<tr>");
		out.println("<td colspan='8' align='right'>");
		out.println("<a href='member/memberRegister.html'>회원가입</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
