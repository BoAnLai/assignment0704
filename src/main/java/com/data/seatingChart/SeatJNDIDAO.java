package com.data.seatingChart;

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

public class SeatJNDIDAO implements SeatDAO_interface{

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
	public List<SeatVO> getAll() {
		// TODO Auto-generated method stub
		
		List<SeatVO> seatList = new ArrayList();
		SeatVO seat = null;
		Connection con = null;

		CallableStatement callableStatement = null;
		String sql = "{CALL get_all_seat}";
		ResultSet rs = null;
		
		try {
			con = ds.getConnection();
			callableStatement = con.prepareCall(sql);
			rs = callableStatement.executeQuery();
			
			while(rs.next()) {
				seat = new SeatVO();
				seat.setFloorSeatSeq(rs.getString(1));
				seat.setFloorNo(rs.getInt(2));
				seat.setSeatNo(rs.getInt(3));
				seatList.add(seat);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
            try {
                if (rs != null) rs.close();
                if (callableStatement != null) callableStatement.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		
		return seatList;
	}
}
