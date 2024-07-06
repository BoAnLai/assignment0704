package com.data.seatingChart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SeatService {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/assignment0704");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public List<SeatVO> getAll(){
		Connection con = null;
		try {
			con = ds.getConnection();
			SeatJNDIDAO dao = new SeatJNDIDAO(con);
			return dao.getAll();
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
			}
		}
	}
	
}
