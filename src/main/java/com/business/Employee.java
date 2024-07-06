package com.business;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.XSSFilter;
import com.data.employee.EmployeeService;
import com.data.employee.EmployeeVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@MultipartConfig
@WebServlet(name = "Employee", urlPatterns = { "/api/employees", "/api/employee/seat" })
public class Employee extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		if (req.getServletPath().equals("/api/employees")) {

			EmployeeService empSvc = new EmployeeService();
			List<EmployeeVO> empList = empSvc.getAll();

			ObjectMapper objMapper = new ObjectMapper();

			try {
				String json = objMapper.writeValueAsString(empList);

				res.setContentType("application/json");
				PrintWriter out = res.getWriter();
				out.print(json);
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getServletPath().equals("/api/employee/seat")) {

			EmployeeService empSvc = new EmployeeService();

			String action = XSSFilter.filter(req.getParameter("action"));
			String floorSeatSeq = XSSFilter.filter(req.getParameter("seatSelected"));

			if (action.isEmpty() || floorSeatSeq.isEmpty()) {
				res.setStatus(HttpServletResponse.SC_PRECONDITION_FAILED);
				return;
			}

			if (action.equals("清空座位")) {
				empSvc.removeSeat(floorSeatSeq);
			} else {
				Integer empId = Integer.valueOf(action);
				empSvc.setSeat(empId, floorSeatSeq);
			}

			res.sendRedirect(req.getContextPath() + "/api/employees");
		}
	}
}
