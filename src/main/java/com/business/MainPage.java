package com.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig
@WebServlet(name = "MainPage", urlPatterns = { "/index" })
public class MainPage extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setAttribute("baseUrl", req.getContextPath() + "/presentation/");
		req.getRequestDispatcher("/presentation/index.jsp").forward(req, res);
	}

}
