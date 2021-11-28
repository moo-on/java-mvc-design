package com.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberLogoutController implements Controller{
    @Override
    public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 세션의 가져온 후 제거
        request.getSession().invalidate();
        return null;
    }
}
