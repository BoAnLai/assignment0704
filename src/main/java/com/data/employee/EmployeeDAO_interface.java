package com.data.employee;

import java.sql.SQLException;
import java.util.*;

public interface EmployeeDAO_interface {
          public List<EmployeeVO> getAll();
          public void removeSeat(String floorSeatSeq) throws SQLException;
          public void setSeat(Integer empId, String floorSeatSeq);
          public void cleanSeatIfOccupied(String floorSeatSeq);
//          public void insert(UserVO userVO) throws SQLException;
//          public void update(Integer userId,UserVO userVO);
//          public UserVO findById(Integer userId);
//          public List<UserVO> getByEmail(String userEmail);
//          public List<UserVO> getByIdentity(String identity);
//          public List<UserVO> getByCompanyName(String userCompanyName);
//          public List<UserVO> getByLastIp(String userLastIp);
//          public List<UserVO> getByNickname(String userNickname);
//          public void updateLastLogin(Integer userId);    
//          public UserVO findByEmail(String email) throws SQLException;
//          public void updateLastIp(Integer userId);      
}
