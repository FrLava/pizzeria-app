package fr.pizzeria.console.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Client;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	
	List<Client> findAllClient();

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

	boolean updatePizza(String codePizza, Pizza pizza)throws UpdatePizzaException;

	boolean deletePizza(String codePizza)throws DeletePizzaException;
	
	void crediterCompteClient(int id,double montant)throws CreditException;
	
	void debiterCompteClient(int id,double montant)throws DebitException;
}
