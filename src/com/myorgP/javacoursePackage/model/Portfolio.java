package com.myorgP.javacoursePackage.model;



public class Portfolio {
	
	
	
	
	private static final int MAX_PORTFOLIO_SIZE= 5;
	private Stock[] stocks=new Stock [MAX_PORTFOLIO_SIZE];
	private String title;
	private int stockIndex;
	

/*	public Portfolio(){
		stocks =new Stock [MAX_PORTFOLIO_SIZE];
		stockIndex=0;
		
		}*/
	
	/*public Portfolio( String title, int stockIndex) {
		
		this.title = title;
		this.stockIndex = stockIndex;
		this.stocks=new Stock[MAX_PORTFOLIO_SIZE];
	}*/
	
	public Portfolio( String title) {
		this.title= title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.stockIndex=0;
	}
	
	//copy Constructor

public Portfolio(Portfolio copyMe){
	
		this.title = new String (copyMe.getTitle());
		this.stockIndex= copyMe.getStockIndex();
		
		
		Stock[] coppied =copyMe.getStocks();
		for (int i =0; i< this.stockIndex;i++){
			this.stocks[i] =new Stock (coppied[i]);
		}//for
		
	}//end copy
		
		
/*	public Portfolio(String title){
		this.title= title;
	}*/
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
		

/*public void addStock(Stock newStock) {
	if(newStock!= null && stockIndex < MAX_PORTFOLIO_SIZE){
		this.stocks[stockIndex]=newStock;
		stockIndex++;
	}else
		System.out.println("Sorry, porfolio is full, or new stock is null!");
}//add*/
	
	public int getStockIndex() {
		return stockIndex;
	}

	public void setStockIndex(int stockIndex) {
		this.stockIndex = stockIndex;
	}

	public void addStock(Stock newStock) {
		if(newStock!= null && stockIndex < MAX_PORTFOLIO_SIZE) {
			this.stocks[stockIndex]= newStock;
			stockIndex++;}
		else
			System.out.println("Sorry, porfolio is full, or new stock is null!");
			
		}
	public void removeStock (String symbol){
		for (int i=0; i < stockIndex; i++){
			if (this.stocks[i].getSymbol().equals(symbol)){
				this.stocks[i]= this.stocks[stockIndex-1];
				this.stocks[stockIndex-1]=null;
				stockIndex--;
			}
		}
			
	}
	
	

public String getHtmlString() {
	String ret = new String( "<h1>" + getTitle() + "</h1>" );
	for(int i = 0; i < stockIndex ;i++) {
		
		ret += this.stocks[i].getHtmlDescription();	
	}
	return ret;	
}


}
