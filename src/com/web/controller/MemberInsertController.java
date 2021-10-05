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

        String ctx = request.getContextPath(); //jsp-tutorial

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

        String nextPage = null;
        // model과의 연동
        MemberDAO dao = new MemberDAO();
        int cnt = dao.memberInsert(vo);
        if(cnt == 1) {
            //성공
            nextPage = "redirect:"+ctx+"/memberList.do";
        }else {
            //실패 예외객체 생성 후 WAS에게 전달
            throw new ServletException("not insert");
        }
        return nextPage;
    }


}
