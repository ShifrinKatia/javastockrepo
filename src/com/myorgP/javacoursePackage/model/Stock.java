package com.myorgP.javacoursePackage.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public class Stock {


	private String symbol;
	private float ask;
	private float bid;
	private java.util.Date date ;
	
	private int recommendation;
	private int stockQuantity;
	private static final int BUY = 0;
	private static final int	SELL = 1;
	private static final int REMOVE = 2;
	private static final int HOLD = 3; 

	public Stock(String symbol,Date date, float ask, float bid,  int recommendation, int stockQuantity){
		this.date = date;
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.recommendation = recommendation;
		this.stockQuantity = stockQuantity;
	}
	
	public Stock (Stock stock){
		this.date = new Date(stock.getDate().getTime());
		this.symbol = new String (stock.getSymbol());
		this.ask = stock.getAsk();
		this.bid = stock.getBid();
		this.recommendation = stock.getRecommendation();
		this.stockQuantity = stock.getStockQuantity();
	}
	
	
/*public Stock (Stock originalStock){
		
		this.symbol= new String(originalStock.getSymbol());
		this.date = new Date(originalStock.getDate().getTime());
		this.ask=  originalStock.getAsk();
		this.bid = originalStock.getBid();
}
*/

	
	/*מה שהיה בפעול
	 * public Stock(String symbol, Date date, float ask , float bid){
		this.symbol =symbol;
		this.date = date;
		this.ask = ask;
		this.bid =bid;
	}*/ 
	
	
	/*public Stock( Stock copyStock)
	{
		this.setSymbol(new String (copyStock.getSymbol()));
		this.setAsk(copyStock.getAsk());
		this.setBid(copyStock.getBid());
		this.date =new Date(copyStock.getDate().getTime());
		
	
	}*/





	/*public Stock(String string, Date date2, float f, float g) {
		// TODO Auto-generated constructor stub
	}*/

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public float getAsk() {
		return this.ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return this.bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return this.date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDateDay(){
		return this.date.getDate();
	}
	public int getDateMonth(){
		return this.date.getMonth();
	}
	public int getDateYear(){
		return this.date.getYear();
	}
	public int getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}








	public String getHtmlDescription() {

		SimpleDateFormat df= new SimpleDateFormat("MM/dd/yyyy");
		String dateStr =df.format(getDate());

		String desc = "<b>Stock symbol: </b>"+ getSymbol()+ ",<b> ask: </b>"+getAsk()+",<b> bid: </b>"+getBid()+", <b>date: </b>" +getDate()+"<b> recommendation:  </b>"+getRecommendation()+" <b> Quantity:  </b>"+getStockQuantity()+"</br>";

		return desc;
	}



}
