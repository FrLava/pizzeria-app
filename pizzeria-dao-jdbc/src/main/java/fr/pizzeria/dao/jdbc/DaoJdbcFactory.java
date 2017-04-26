package fr.pizzeria.dao.jdbc;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoJdbcFactory implements DaoFactory {

	private IPizzaDao pizzaDao=new PizzaDaoImplJdbc();
	
	@Override
	public IPizzaDao getPizzaDao() {

		return pizzaDao;
	}

}
