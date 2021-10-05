package com.web.forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.MemberVO;

/**
 * Servlet implementation class ForwardController
 */
@WebServlet("/fc.do")
public class ForwardController extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String name = "moon";
        int age = 19;
        String email = "w@naver.com";

        MemberVO vo = new MemberVO();
        vo.setName(name);
        vo.setAge(age);
        vo.setEmail(email);

        // forward.jsp
        // 객체바인딩
        request.setAttribute("vo", vo);
        // forward
        RequestDispatcher rd = request.getRequestDispatcher("view/forward.jsp");
        rd.forward(request, response);
    }
}
// 해당 요청은 forward.jsp로 요청을 의뢰(RequestDispatcher)하고 다시 컨트롤러에 응답을 하기에, forward.jsp는 노출되지 않는다.
