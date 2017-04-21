package fr.pizzeria.dao;

import fr.pizzeria.dao.IPizzaDao;

public interface DaoFactory {
	
	public IPizzaDao getPizzaDao();
}
