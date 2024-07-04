package com.data.employee;

import java.util.List;


public class EmployeeService {

	private EmployeeDAO_interface dao;

	public EmployeeService() {
		dao = new EmployeeJNDIDAO();
	}
	
	public List<EmployeeVO> getAll(){
		return dao.getAll();
	}
	
}
