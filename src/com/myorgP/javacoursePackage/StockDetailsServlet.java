package com.myorgP.javacoursePackage;



import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)	throws ServletException, IOException {

		resp.setContentType("text/html");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014,11,15);
		Date date= cal.getTime();


		Stock stock1 = new Stock("PIH",  date , ((float)(13.1)) , ((float)(12.4)) );
		Stock stock2 = new Stock("AAL",  date ,((float) (5.78)) ,((float)(5.5)) );
		Stock stock3 = new Stock("CAAS",  date , ((float)(32.2)) , ((float)(31.5))  );





		resp.getWriter().println("<br>");
		resp.getWriter().println(stock1.getHtmlDescription());
		resp.getWriter().println("<br>");
		resp.getWriter().println(stock2.getHtmlDescription());
		resp.getWriter().println("<br>");
		resp.getWriter().println(stock3.getHtmlDescription());
	}
}
