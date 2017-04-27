package fr.pizzeria.dao.jpa;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoJpaFactory implements DaoFactory {

	private IPizzaDao pizzaDao=new PizzaDaoImplJpa();
	
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
