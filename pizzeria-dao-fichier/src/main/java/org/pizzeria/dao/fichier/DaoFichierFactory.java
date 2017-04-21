package org.pizzeria.dao.fichier;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.console.ihm.PizzaDaoImplFichier;
import fr.pizzeria.dao.DaoFactory;

public class DaoFichierFactory implements DaoFactory {

	private static final String DATA_DIR_PIZZA="data/pizzas";
	private static final String DAT_DIR_CLIENT="data/clients";
	
	private IPizzaDao pizzaDao=new PizzaDaoImplFichier();
	
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}
	
	public static String getDIRPizza(){
		return DATA_DIR_PIZZA;
	}

	public static String getDIRClient() {
		return DAT_DIR_CLIENT;
	}
}
