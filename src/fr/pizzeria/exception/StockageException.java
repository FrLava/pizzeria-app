package fr.pizzeria.exception;

import java.io.IOException;

import fr.pizzeria.console.Pizza;

public class StockageException extends RuntimeException{

	public StockageException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public StockageException(IOException e) {
		// TODO Auto-generated constructor stub
	}

	

}
