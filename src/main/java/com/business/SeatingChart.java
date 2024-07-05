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

import com.data.seatingChart.SeatService;
import com.data.seatingChart.SeatVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@MultipartConfig
@WebServlet(name = "SeatingChart", urlPatterns = { "/api/seatingChart" })
public class SeatingChart extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		SeatService seatSvc = new SeatService();
		List<SeatVO> seatList = seatSvc.getAll();

		ObjectMapper objMapper = new ObjectMapper();
		
		try {
			String json = objMapper.writeValueAsString(seatList);
			System.out.println(json);
			
			res.setContentType("application/json");
			PrintWriter out = res.getWriter();
			out.print(json);
			out.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
