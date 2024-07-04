package com.data.employee;

public class EmployeeVO implements java.io.Serializable{

	private Integer employeeId;
	private String name;
	private String email;
	private String floorSeatSeq;
	
	public static void main(String args[]) {
		
		EmployeeVO emp = new EmployeeVO();
		System.out.println(emp);
		
	}
	
	
	
	public EmployeeVO() {
		super();
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
		
		outputStr += "\r employeeId="+ this.getEmployeeId();
		outputStr += "\r name="+ this.getName();
		outputStr += "\r email="+ this.getEmail();
		outputStr += "\r floorSeatSeq="+ this.getFloorSeatSeq();		
		outputStr += "]\r\r";
		
		return outputStr;
	}
	
	
}
