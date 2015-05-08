package com.myorgP.javacoursePackage.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import com.myorgP.javacoursePackage.model.Portfolio;
import com.myorgP.javacoursePackage.model.Stock;
import com.myorgP.javacoursePackage.service.PortfolioManger;

@SuppressWarnings("serial")

public class PortfolioServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		resp.setContentType("text/html");
		
		PortfolioManger portfolioManager1 = new PortfolioManger();
		
		Portfolio portfolio1 =portfolioManager1.getPortfolio();
		portfolio1.setTitle("Portfolio 1");
		resp.getWriter().println(portfolio1.getHtmlString());
		
	 
		Portfolio portfolio2 = new Portfolio(portfolio1);
		portfolio2.setTitle("Portfolio #2");
		resp.getWriter().println(portfolio2.getHtmlString());
		

		portfolio1.removeStock(portfolio1.getStocks()[0].getSymbol());
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		Stock[] temp = portfolio2.getStocks();
		temp[portfolio2.getStockIndex()-1].setBid(55.55f);
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());





	}
}
