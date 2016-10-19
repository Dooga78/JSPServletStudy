package com.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmpDAO;
import com.vo.EmpVO;

public class EmpListService implements EmpServiceImpl {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EmpDAO eDao = new EmpDAO();
		
		ArrayList<EmpVO> list = eDao.select();
		
		request.setAttribute("list", list);
	}

}
