package com.data.employee;

import java.sql.SQLException;
import java.util.List;


public class EmployeeService {

	private EmployeeDAO_interface dao;

	public EmployeeService() {
		dao = new EmployeeJNDIDAO();
	}
	
	public List<EmployeeVO> getAll(){
		return dao.getAll();
	}
	
	public void removeSeat(String floorSeatSeq) {
		try {
			dao.removeSeat(floorSeatSeq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setSeat(Integer empId, String floorSeatSeq) {
		dao.cleanSeatIfOccupied(floorSeatSeq);
		dao.setSeat(empId, floorSeatSeq);
	}
}
