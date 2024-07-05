package com.data.seatingChart;

import java.util.List;

public class SeatService {

	private SeatDAO_interface dao;
	
	public SeatService() {
		dao = new SeatJNDIDAO();
	}
	
	public List<SeatVO> getAll(){
		return dao.getAll();
	}
	
}
