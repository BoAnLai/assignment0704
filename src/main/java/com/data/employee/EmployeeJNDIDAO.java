package com.data.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EmployeeJNDIDAO implements EmployeeDAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/assignment0704");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public List<EmployeeVO> getAll() {
		// TODO Auto-generated method stub
		List<EmployeeVO> empList = new ArrayList();
		EmployeeVO emp = null;
		Connection con = null;

		CallableStatement callableStatement = null;
		String sql = "{CALL get_all_employee}";
		ResultSet rs = null;

		try {
			con = ds.getConnection();
			callableStatement = con.prepareCall(sql);
			rs = callableStatement.executeQuery();

			while (rs.next()) {
				emp = new EmployeeVO();
				emp.setEmpId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setFloorSeatSeq(rs.getString(4));
				empList.add(emp);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	
	@Override
	public void removeSeat(String floorSeatSeq) {
		// TODO Auto-generated method stub
		Connection con = null;

		CallableStatement callableStatement = null;
		String sql = "{CALL remove_employee_seat(?)}";

		try {
			con = ds.getConnection();
			callableStatement = con.prepareCall(sql);

			callableStatement.setString(1, floorSeatSeq);
			callableStatement.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void setSeat(Integer empId, String floorSeatSeq) {
		Connection con = null;

		CallableStatement callableStatement = null;
		String sql = "{CALL set_employee_seat(?,?)}";

		try {
			con = ds.getConnection();
			callableStatement = con.prepareCall(sql);

			callableStatement.setInt(1, empId);
			callableStatement.setString(2, floorSeatSeq);
			callableStatement.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public void cleanSeatIfOccupied(String floorSeatSeq) {
		Connection con = null;

		CallableStatement callableStatement = null;
		String sql = "{CALL clean_seat_if_occupied(?)}";

		try {
			con = ds.getConnection();
			callableStatement = con.prepareCall(sql);

			callableStatement.setString(1, floorSeatSeq);
			callableStatement.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			try {
				if (callableStatement != null)
					callableStatement.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}