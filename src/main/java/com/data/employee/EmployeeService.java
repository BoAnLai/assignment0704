package com.data.employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class EmployeeService {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/assignment0704");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<EmployeeVO> getAll(){
		
		Connection con = null;
		try {
			con = ds.getConnection();
			EmployeeJNDIDAO dao = new EmployeeJNDIDAO(con);
			return dao.getAll();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
		
	}
	
	public void removeSeat(String floorSeatSeq) {
		
		Connection con = null;
		try {
			con = ds.getConnection();
			EmployeeJNDIDAO dao = new EmployeeJNDIDAO(con);
			dao.removeSeat(floorSeatSeq);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	public void setSeat(Integer empId, String floorSeatSeq) {
		
		Connection con = null;
		try {
			con = ds.getConnection();
			con.setAutoCommit(false);
			EmployeeJNDIDAO dao = new EmployeeJNDIDAO(con);
			
			dao.cleanSeatIfOccupied(floorSeatSeq);
			dao.setSeat(empId, floorSeatSeq);
			
			con.commit();
		}catch(SQLException e) {
			 if (con != null) {
	                try {
	                    con.rollback(); // 回滾交易
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
			e.printStackTrace();
		}finally {
			if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
	}
}
