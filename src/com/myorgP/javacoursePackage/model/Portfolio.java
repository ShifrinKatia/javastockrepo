package com.myorgP.javacoursePackage.model;


import com.myorgP.javacoursePackage.Stock;

public class Portfolio {
	
	
	
	
	private static final int MAX_PORTFOLIO_SIZE= 5;
	private Stock[] stocks = new Stock[MAX_PORTFOLIO_SIZE];
	private String title;
	private int stockIndex=0;
	
	
	public Portfolio(String title){
		this.title= title;
	}

	
public Stock[] getStocks() {
		return stocks;
	}
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


public void addStock(Stock newStock) {
	if(newStock!= null && stockIndex < MAX_PORTFOLIO_SIZE){
		this.stocks[stockIndex]=newStock;
		stockIndex++;
	}else
		System.out.println("Sorry, porfolio is full, or new stock is null!");
}//add

public String getHtmlString() {
	String ret = new String( "<h1>" + getTitle() + "</h1>" );
	for(int i = 0; i < stockIndex ;i++) {
		//stock current = this.stocks[i];
		ret += this.stocks[i].getHtmlDescription() + "<br>";	
	}
	return ret;	
}


}
