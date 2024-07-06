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

	private Connection con;
	
	public SeatJNDIDAO(Connection con) {
		this.con = con;
	}
	
	@Override
	public List<SeatVO> getAll() {
		
		List<SeatVO> seatList = new ArrayList();
		SeatVO seat = null;

		CallableStatement callableStatement = null;
		String sql = "{CALL get_all_seat}";
		ResultSet rs = null;
		
		try {
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}
		
		return seatList;
	}
}
