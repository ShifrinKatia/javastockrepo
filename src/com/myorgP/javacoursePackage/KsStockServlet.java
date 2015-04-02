package com.myorgP.javacoursePackage;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class KsStockServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		//variable declaration and assignment
		int num1=4, num2=3, num3=7;
		
		//calculation
		int result = (num1+num2)*num3;
		String resultStr = new String ("<h1> Result of "+" ("+num1+"+"+num2+")"+"*"+num3+"="+result+"</h1>");
		
		
		
		resp.getWriter().println( resultStr );
		

	}
}
