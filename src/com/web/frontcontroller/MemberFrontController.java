package com.web.frontcontroller;

import com.web.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        String ctx = request.getContextPath(); // ctx = jsp-tutorial
        System.out.println(ctx);
        String command = url.substring(ctx.length()); // URI= jsp-tutorial/memberInsert.do, command = memberInsert.do
        System.out.println(command);
        request.setCharacterEncoding("euc-kr"); // memberInsert 에서 속성 저장 시 한글 값 깨짐 방지

        Controller controller = null;
        String nextPage = null;

        // controller 생성 후 request, response 객체 넘겨줘서 일을 한 후 다음 페이지 까지 받아와서 넘겨주는 것이 pojo 의 역할
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
