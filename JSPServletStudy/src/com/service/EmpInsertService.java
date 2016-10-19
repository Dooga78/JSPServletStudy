package com.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDAO;

public class EmpInsertService implements EmpServiceImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String empId = request.getParameter("empId");
		String ename = request.getParameter("ename");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		EmpDAO eDao = new EmpDAO();
		
		int result = eDao.insert(empId, ename, salary);
		
		request.setAttribute("result", result);
	}

}
