package fr.pizzeria.dao;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.console.ihm.PizzaDaoImplFichier;

public class DaoFichierFactory implements DaoFactory {

	private static final String DATA_DIR="data";
	
	private IPizzaDao pizzaDao=new PizzaDaoImplFichier();
	
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}
	
	public static String getDIRName(){
		return DATA_DIR;
	}

}
