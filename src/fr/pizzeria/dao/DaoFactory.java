package fr.pizzeria.dao;

import fr.pizzeria.console.ihm.IPizzaDao;

public interface DaoFactory {
	
	public IPizzaDao getPizzaDao();
}
