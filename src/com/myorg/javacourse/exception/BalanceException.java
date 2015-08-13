package com.myorg.javacourse.exception;
/**
 * @author katia Shifrin
 * @version 14/08/2015
 */
import org.algo.exception.PortfolioException;
public class BalanceException extends PortfolioException
{
	public BalanceException(String msg)
	{
		super(msg);
	}
}
