package com.data.seatingChart;

public class SeatVO implements java.io.Serializable{

	private String floorSeatSeq;
	private Integer floorNo;
	private Integer seatNo;
	
	public SeatVO() {
		super();
	}
	
	public String getFloorSeatSeq() {
		return floorSeatSeq;
	}
	public void setFloorSeatSeq(String floorSeatSeq) {
		this.floorSeatSeq = floorSeatSeq;
	}
	public Integer getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(Integer floorNo) {
		this.floorNo = floorNo;
	}
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	
	@Override
	public String toString() {
		String outputStr = "Seat: [";
		
		outputStr += "\r floorSeatSeq="+ this.getFloorSeatSeq();
		outputStr += "\r floorNo="+ this.getFloorNo();
		outputStr += "\r seatNo="+ this.getSeatNo();
		outputStr += "]\r\r";
		
		return outputStr;
	}
	
}
