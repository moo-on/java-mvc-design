package com.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	// ��� POJO�� �������� �޼ҵ�
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
