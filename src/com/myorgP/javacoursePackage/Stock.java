package com.myorgP.javacoursePackage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock {


	private String symbol;
	private float ask;
	private float bid;
	private Date date ;


public Stock (Stock originalStock){
		
		this.symbol= new String(originalStock.getSymbol());
		this.date = new Date(originalStock.getDate().getTime());
		//this.ask=  originalStock.getAsk();
		//this.bid = originalStock.getBid();
}
	public Stock(String symbol, Date date, float ask , float bid){
		this.symbol =symbol;
		this.date = date;
		this.ask = ask;
		this.bid =bid;
	}





	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public float getAsk() {
		return ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}
	public float getBid() {
		return bid;
	}
	public void setBid(float bid) {
		this.bid = bid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}









	public String getHtmlDescription() {

		SimpleDateFormat df= new SimpleDateFormat("MM/dd/yyyy");
		String dateStr =df.format(getDate());

		String desc = "<b>Stock symbol: </b>"+ this.getSymbol()+ ",<b> ask: </b>"+this.getAsk()+",<b> bid: </b>"+this.getBid()+", <b>date: </b>" +dateStr;

		return desc;
	}



}
