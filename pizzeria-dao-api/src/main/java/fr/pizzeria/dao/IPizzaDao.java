package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
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
