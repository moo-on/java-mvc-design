package com.web.controller;

import java.util.*;
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


@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Ŭ���̾�Ʈ�� ��û �ޱ� (memberList.do)
		// 2. ȸ����ü ����Ʈ �������� (model ����)
		MemberDAO dao  = new MemberDAO();
		ArrayList<MemberVO> list = dao.memberList();
		// ��ü���ε�(request)���ε�
		request.setAttribute("list", list);
		// forward ��� 
		RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
		rd.forward(request, response);
		
	}
}
