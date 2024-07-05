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

import com.data.employee.EmployeeService;
import com.data.employee.EmployeeVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@MultipartConfig
@WebServlet(name = "Employee", urlPatterns = { "/api/employees" })
public class Employee extends HttpServlet{

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
}
