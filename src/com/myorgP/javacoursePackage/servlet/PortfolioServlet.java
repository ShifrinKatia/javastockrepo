package com.myorgP.javacoursePackage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.myorgP.javacoursePackage.model.Portfolio;
import com.myorgP.javacoursePackage.service.PortfolioManger;

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		resp.setContentType("text/html");
		
		PortfolioManger portfolioManager = new PortfolioManger();
		Portfolio portfolio =portfolioManager.getPortfolio();
		resp.getWriter().println(portfolio.getHtmlString());





	}
}
