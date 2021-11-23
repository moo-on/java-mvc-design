package com.web.controller;

import com.web.model.MemberDAO;
import com.web.model.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberLoginController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ctx = request.getContextPath();

        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");

        MemberVO vo = new MemberVO();
        vo.setId(user_id);
        vo.setPass(password);

        MemberDAO dao = new MemberDAO();
        String user_name = dao.memberLogin(vo);

        // 로그인 성공
        if (user_name != null && !"".equals(user_name)){
            request.getSession().setAttribute("userID", user_id); // session객체라는 서버에 만들어지는 메모리공간, 로그인에 성공하면 session객체에 변수를 바인딩, 다른 사이트에서도 session객체 안에 있는 변수로 인증 등을 함
            request.getSession().setAttribute("userName", user_name);
        }
        else{
            request.getSession().setAttribute("userID", "");
            request.getSession().setAttribute("userName", "");
            request.getSession().setAttribute("msg", "사용자정보가 올바르지 않습니다.");
        }

        return "redirect:"+ctx+"/memberList.do";
    }
}
