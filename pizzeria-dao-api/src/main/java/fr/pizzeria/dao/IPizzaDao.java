package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.dao.exception.CreditException;
import fr.pizzeria.dao.exception.DebitException;
import fr.pizzeria.dao.exception.DeletePizzaException;
import fr.pizzeria.dao.exception.SavePizzaException;
import fr.pizzeria.dao.exception.UpdatePizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	
	List<Client> findAllClient();

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

	boolean updatePizza(String codePizza, Pizza pizza)throws UpdatePizzaException;

	boolean deletePizza(String codePizza)throws DeletePizzaException;
	
	void crediterCompteClient(int id,double montant)throws CreditException;
	
	void debiterCompteClient(int id,double montant)throws DebitException;
}
