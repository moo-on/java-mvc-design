package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.model.CalcModel;


@WebServlet("/calc.do")
public class CalcController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int n1 = Integer.parseInt(request.getParameter("n1"));
		int n2 = Integer.parseInt(request.getParameter("n2"));
		
		// model
		CalcModel calc = new CalcModel();
		int sum = calc.sum(n1, n2);
		
		// view
		PrintWriter out = response.getWriter();
		out.println(sum);
		
	}

}
