package com.data.employee;

public class EmployeeVO implements java.io.Serializable{

	private Integer empId;
	private String name;
	private String email;
	private String floorSeatSeq;	
	
	public EmployeeVO() {
		super();
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer employeeId) {
		this.empId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFloorSeatSeq() {
		return floorSeatSeq;
	}

	public void setFloorSeatSeq(String floorSeatSeq) {
		this.floorSeatSeq = floorSeatSeq;
	}
	
	@Override
	public String toString() {
		String outputStr = "Employee: [";
		
		outputStr += "\r empId="+ this.getEmpId();
		outputStr += "\r name="+ this.getName();
		outputStr += "\r email="+ this.getEmail();
		outputStr += "\r floorSeatSeq="+ this.getFloorSeatSeq();		
		outputStr += "]\r\r";
		
		return outputStr;
	}
	
	
}
