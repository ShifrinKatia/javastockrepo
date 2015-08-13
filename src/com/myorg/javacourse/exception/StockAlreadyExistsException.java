package com.myorg.javacourse.exception;
/**
 * @author katia Shifrin
 * @version 14/08/2015
 */
import org.algo.exception.PortfolioException;
public class StockAlreadyExistsException extends PortfolioException
{
	public StockAlreadyExistsException(String msg)
	{
		super(msg);
	}
}
