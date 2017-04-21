package fr.pizzeria.dao.memoire;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.memoire.PizzaDaoImplTableau;
import fr.pizzeria.dao.DaoFactory;


public class DaoMemoryFactory implements DaoFactory {

	private IPizzaDao pizzaDao=new PizzaDaoImplTableau();
	
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
