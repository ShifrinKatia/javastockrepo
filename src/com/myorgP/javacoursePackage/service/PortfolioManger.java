package com.myorgP.javacoursePackage.service;

import java.util.Calendar;
import java.util.Date;

import com.myorgP.javacoursePackage.model.Portfolio;
import com.myorgP.javacoursePackage.Stock;


public class PortfolioManger {

	
	
	public Portfolio getPortfolio(){
		

		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014,11,15);
		Date date= cal.getTime();
		
		Portfolio portfolio = new Portfolio("");
		portfolio.setTitle("Targil 5 Portfolio");
		
		Stock stock1=  new Stock("PIH",  date , ((float)(13.1)) , ((float)(12.4)) );
		portfolio.addStock(stock1);
		Stock stock2 = new Stock("AAL",  date ,((float) (5.78)) ,((float)(5.5)) );
		portfolio.addStock(stock2);
		Stock stock3 = new Stock("CAAS",  date , ((float)(32.2)) , ((float)(31.5))  );
		portfolio.addStock(stock3);
		
		return portfolio;
	}
}
