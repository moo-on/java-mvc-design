package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.MemberDAO;
import com.web.model.MemberVO;


public class MemberInsertController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.�ĸ����� ����(VO)
				String id = request.getParameter("id");
				String pass = request.getParameter("pass");
				String name= request.getParameter("name");
				int age = Integer.parseInt(request.getParameter("age"));
				String email= request.getParameter("email");
				String phone = request.getParameter("phone");
				
				/* �����ڷ� �ٷ� set���ֱ� �߾Ⱦ��δ�.
				MemberVO vo = new MemberVO(id, pass, name, age, email, phone);
				*/
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPass(pass);
				vo.setName(name);
				vo.setAge(age);
				vo.setEmail(email);
				vo.setPhone(phone);
				
				String nextPage = null;
				// model���� ����
				MemberDAO dao = new MemberDAO();
				int cnt = dao.memberInsert(vo);
				if(cnt == 1) {
					//����
					nextPage = "/jsp-tutorial/memberList.do";
				}else {
					//���� ���ܰ�ü ���� �� WAS���� ����
					throw new ServletException("not insert");
				}
				return nextPage;
	}
	

}
