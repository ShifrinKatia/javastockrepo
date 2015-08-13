package com.myorg.javacourse.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.myorg.javacourse.exception.BalanceException;
import com.myorg.javacourse.exception.PortfolioFullException;
import com.myorg.javacourse.exception.StockAlreadyExistsException;
import com.myorg.javacourse.exception.StockNotExistException;

/**
 * portfolio.java Purpose: Represents an Intarfece for Portfolio
 *
 * @author katia Shifrin
 * @version 14/08/2015
 */
public class Portfolio implements PortfolioInterface {
	private final static int MAX_PORTFOLIO_SIZE = 5;

	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD
	};

	private String title;
	private StockInterface[] stocks;
	private int currPortfolioIndex;
	private float balance;

	public Portfolio() {
		super();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		currPortfolioIndex = 0;
		balance = 0;
	}

	public Portfolio(Stock[] stockArray) {
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		currPortfolioIndex = 0;
		balance = 0;

		for (int i = 0; i < stockArray.length; i++) {
			stocks[i] = stockArray[i];
			currPortfolioIndex++;
		}
	}

	public Portfolio(Portfolio portfolioToCopy) {
		title = portfolioToCopy.getTitle();
		currPortfolioIndex = portfolioToCopy.getCurrPortfolioIndex();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		balance = portfolioToCopy.getBalance();

		for (int i = 0; i < currPortfolioIndex; i++) {

			stocks[i] = new Stock(portfolioToCopy.getStocks()[i]);
		}
	}

	public Stock[] getStocks() {
		return (Stock[]) stocks;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		title = newTitle;
	}

	public int getCurrPortfolioIndex() {
		return currPortfolioIndex;
	}

	public void setCurrPortfolioIndex(int newIndex) {
		currPortfolioIndex = newIndex;
	}

	public float getBalance() {
		return balance;
	}

	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}

	public float getStocksValue() {
		float totalValue = 0;
		for (int i = 0; i < currPortfolioIndex; i++) {

			totalValue += ((Stock) stocks[i]).getStockQuantity()
					* stocks[i].getBid();
		}

		return (totalValue);
	}

	public float getTotalValue() {
		return (getStocksValue() + getBalance());
	}

	public int isStockInPortfolio(String symbolToFind) {
		for (int i = 0; i < currPortfolioIndex; i++) {
			if (stocks[i].getSymbol().equals(symbolToFind)) {
				return (i);
			}
		}

		return (-1);
	}

	public Stock findStock(String symbol) {
		for (int i = 0; i < currPortfolioIndex; i++) {
			if (stocks[i].getSymbol().equals(symbol)) {
				return (Stock) (stocks[i]);
			}
		}

		return (null);
	}

	public void addStock(Stock stockToAdd) throws StockNotExistException,
			StockAlreadyExistsException, PortfolioFullException {
		if (stockToAdd == null) {
			throw new StockNotExistException("Stock is not valid!");
		}

		else if (isStockInPortfolio(stockToAdd.getSymbol()) != -1) {
			throw new StockAlreadyExistsException(
					"Stock already exists in the current Portfolio!");
		}

		else if (currPortfolioIndex >= MAX_PORTFOLIO_SIZE) {
			throw new PortfolioFullException(
					"Can't add new Stock, portfolio can have only "
							+ MAX_PORTFOLIO_SIZE + " stocks");
		}

		else if (isStockInPortfolio(stockToAdd.getSymbol()) == -1) {
			stocks[currPortfolioIndex] = stockToAdd;

			((Stock) stocks[currPortfolioIndex]).setStockQuantity(0);

			currPortfolioIndex++;
		}
	}

	public void removeStock(String symbolToRemove) throws BalanceException,
			StockNotExistException {
		int indexToRemove = isStockInPortfolio(symbolToRemove);

		if (indexToRemove != -1) {
			sellStock(symbolToRemove, -1);

			for (int i = indexToRemove; i < currPortfolioIndex - 1; i++) {
				stocks[i] = stocks[i + 1];
			}
			stocks[currPortfolioIndex - 1] = null;

			currPortfolioIndex--;
		}
	}

	public void sellStock(String symbolToSell, int quantity)
			throws BalanceException, StockNotExistException {
		int indexToSell = isStockInPortfolio(symbolToSell);

		if (indexToSell == -1) {
			throw new StockNotExistException(
					"The Stock is not found in the Portfolio!");
		}

		else if (quantity > ((Stock) stocks[indexToSell]).getStockQuantity()) {
			throw new BalanceException("Not enough stocks to Sell");
		}

		else {
			if (quantity == -1) {
				quantity = ((Stock) stocks[indexToSell]).getStockQuantity();
			}

			((Stock) stocks[indexToSell])
					.setStockQuantity(((Stock) stocks[indexToSell])
							.getStockQuantity() - quantity);

			updateBalance(quantity * stocks[indexToSell].getBid());
		}

	}

	public void buyStock(Stock stockToBuy, int quantity)
			throws BalanceException, StockNotExistException,
			StockAlreadyExistsException, PortfolioFullException {
		int indexToBuy = isStockInPortfolio(stockToBuy.getSymbol());
		float totalPurchaseSum = 0;

		if (indexToBuy != -1) {
			if (quantity == -1) {
				quantity = (int) (getBalance() / stocks[indexToBuy].getAsk());
			}

			totalPurchaseSum = quantity * stocks[indexToBuy].getAsk();

			if (totalPurchaseSum > getBalance()) {
				throw new BalanceException("Not enough Balance to Purchase!");
			}

			else {
				((Stock) stocks[indexToBuy])
						.setStockQuantity(((Stock) stocks[indexToBuy])
								.getStockQuantity() + quantity);

				updateBalance((-1) * quantity * stocks[indexToBuy].getAsk());
			}
		}

		else {
			if (quantity == -1) {
				quantity = (int) (getBalance() / stockToBuy.getAsk());
			}

			totalPurchaseSum = quantity * stockToBuy.getAsk();

			if (totalPurchaseSum > getBalance()) {
				throw new BalanceException(
						"Not enough Balance to complete Purchase!");
			}

			else {
				addStock(stockToBuy);

				((Stock) stocks[currPortfolioIndex - 1])
						.setStockQuantity(quantity);
				updateBalance((-1) * quantity * stockToBuy.getAsk());
			}
		}
	}

	public void updateBalance(float amount) throws BalanceException {
		if (balance + amount < 0) {
			throw new BalanceException("Portfolio Balance cannot be negative!");
		} else {
			balance += amount;
		}
	}

	public String getHtmlString() {
		String retStr = new String("<h1>Portfolio Title: " + getTitle()
				+ "</h1>");
		retStr += "<b>Total Portfolio Value: </b>" + getTotalValue() + "$"
				+ " <b>Total Stocks Value: </b>" + getStocksValue() + "$"
				+ " <b>Balance: </b>" + getBalance() + "$<br>";
		retStr += "{<br>";

		for (int i = 0; i < currPortfolioIndex; i++) {
			retStr += "&nbsp;&nbsp;&nbsp;&nbsp;"
					+ ((Stock) stocks[i]).getHtmlDescription() + "<br>";
		}
		retStr += "}";
		return (retStr);
	}
}
