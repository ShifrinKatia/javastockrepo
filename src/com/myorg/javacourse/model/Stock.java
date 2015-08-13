package com.myorg.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;

import com.myorg.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * Stock.java 
 * Purpose: Represents a Stock (Interface)
 * @author katia Shifrin
 * @version 14/08/2015
 */
public class Stock implements StockInterface {

	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

	public Stock() {
	}

	public Stock(String symbol, float ask, float bid, Date date,
			int stockQuantity) {
		super();
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
		this.stockQuantity = stockQuantity;
	}

	public Stock(Stock stockToCopy) {
		this(new String(stockToCopy.getSymbol()), stockToCopy.getAsk(),
				stockToCopy.getBid(),
				new Date(stockToCopy.getDate().getTime()), stockToCopy
						.getStockQuantity());
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

	public void setDate(long time) {
		this.date = new Date(time);
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Enum<ALGO_RECOMMENDATION> getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION valueOf) {
		this.recommendation = valueOf;
	}

	public String getHtmlDescription() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateToStr = simpleDateFormat.format(getDate());

		return (new String("<b>Stock Symbol: </b>" + getSymbol()
				+ " <b>Bid: </b>" + getBid() + " <b>Ask: </b>" + getAsk()
				+ " <b>Date: </b>" + dateToStr + " <b>Quantity: </b>"
				+ getStockQuantity()));
	}
}
