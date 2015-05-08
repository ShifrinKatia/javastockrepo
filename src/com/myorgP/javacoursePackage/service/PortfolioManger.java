package com.myorgP.javacoursePackage.service;

import java.util.Calendar;
import java.util.Date;

import com.myorgP.javacoursePackage.model.Portfolio;
import com.myorgP.javacoursePackage.model.Stock;


public class PortfolioManger {

	
	
	public Portfolio getPortfolio(){
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014,11,15);
		
		
		Portfolio portfolio = new Portfolio("");
		portfolio.setTitle("Portfolio");
		
		Stock stock1=  new Stock("PIH",  cal.getTime() , 13.1f , 12.4f , 0, 0 );
		portfolio.addStock(stock1);
		Stock stock2 = new Stock("AAL",  cal.getTime(),((float) (5.78)) ,((float)(5.5)),0,0 );
		portfolio.addStock(stock2);
		Stock stock3 = new Stock("CAAS",  cal.getTime() , ((float)(32.2)) , ((float)(31.5)) ,0,0 );
		portfolio.addStock(stock3);
		
		return portfolio;
	}
	
	/*public Portfolio copyPortfolio(  ){
		
		
	}*/
	
	
}
