package com.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberLogoutController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ctx = request.getContextPath();
        // 세션의 가져온 후 제거방법 강제 / 브라우저 종료(sessionID 브라우저 쿠키 저장) / 세션 종료 까지 기다리기(web.xml default 세션 타임 아웃 시간 = 30분)
        request.getSession().invalidate();
        return "redirect:"+ctx+"/memberList.do";

    }
}
