package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.EmpInsertService;
import com.service.EmpListService;
import com.service.EmpServiceImpl;

@WebServlet("*.do")
public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = requestURI.substring(contextPath.length());
		
		EmpServiceImpl service = null;
		String nextPage = null;
		
		if (com.equals("/emp/list.do")) {
			service = new EmpListService();
			service.execute(request, response);
			nextPage = "/jsp/emp/list.jsp";
		} else if (com.equals("/emp/insertUI.do")) {
			nextPage = "/jsp/emp/insertUI.jsp";
		} else if (com.equals("/emp/insert.do")) {
			service = new EmpInsertService();
			service.execute(request, response);
			nextPage = "/emp/list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
