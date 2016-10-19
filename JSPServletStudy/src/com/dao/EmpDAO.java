package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.vo.EmpVO;

public class EmpDAO {

	DataSource dataFactory;
	
	public EmpDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource)ctx.lookup("java:comp/env/jdbc/MySQL5.5");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
//	Emp List
	public ArrayList<EmpVO> select() {
		ArrayList<EmpVO> list = new ArrayList<>();

		String sql = "select * from emp";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				EmpVO eVo = new EmpVO();
				
				eVo.setEmpId(rs.getString("emp_id"));
				eVo.setEname(rs.getString("ename"));
				eVo.setSalary(rs.getInt("salary"));
				eVo.setDateOfHire(rs.getDate("date_of_hire"));
				
				list.add(eVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

//	Emp insert
	public int insert(String empId, String ename, int salary) {
		String sql = "insert into emp (emp_id, ename, salary, date_of_hire) values (?, ?, ?, sysdate())";
		int result = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, empId);
			pstmt.setString(2, ename);
			pstmt.setInt(3, salary);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
