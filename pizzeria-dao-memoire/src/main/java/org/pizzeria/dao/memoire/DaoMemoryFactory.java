package org.pizzeria.dao.memoire;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.console.ihm.PizzaDaoImplTableau;
import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.console.ihm.PizzaDaoImplFichier;

public class DaoMemoryFactory implements DaoFactory {

	private IPizzaDao pizzaDao=new PizzaDaoImplTableau();
	
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}