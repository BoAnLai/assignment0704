package com.data.employee;

import java.sql.SQLException;
import java.util.*;

public interface EmployeeDAO_interface {
          public List<EmployeeVO> getAll();
          public void removeSeat(String floorSeatSeq) throws SQLException;
          public void setSeat(Integer empId, String floorSeatSeq);
          public void cleanSeatIfOccupied(String floorSeatSeq);
}
