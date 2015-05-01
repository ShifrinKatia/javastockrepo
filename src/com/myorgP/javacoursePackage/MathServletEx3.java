package com.myorgP.javacoursePackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MathServletEx3 extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html");
			
			//variable declaration and assignment
			
			int  hypotenuse=50;
			double	length,circleArea,angleRadians,radius=50, angleB=30,resultP, base=20, exp=13;
			
			
			//calculation
			
			//1.circleArea
			circleArea=Math.pow(radius, 2)*(Math.PI);
			
			//2.Length of opposite
			
			//degrees to radians
			angleRadians=Math.toRadians(angleB);
			
			//calculation of opposite length
			length =Math.sin(angleRadians)*hypotenuse;
			
			//3.Power
			resultP =Math.pow(base, exp);
			
			String line1 = new String("calculation 1: Area of circle with radius "+radius+" is: " +circleArea+ " square cm.");
		
			String line2 = new String("calculation 2: Length of opposite where angle B is "+angleB+" degrees and Hypotenuse length is "+hypotenuse+" cm, is "+length+" cm. ");
			String line3 = new String("calculation 3: Power of "+base+" with exp of "+exp+" is " +resultP+" .");
					
			// a string to include all calculations:
			
			String resultStr= line1 + "<br>" + line2 + "<br>" +line3;
			
			resp.getWriter().println(resultStr );
			}
	

	
	

}
