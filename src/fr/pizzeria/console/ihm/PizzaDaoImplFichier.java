package fr.pizzeria.console.ihm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PizzaDaoImplFichier implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() {
		try{ 
			return Files.list(Paths.get("data"))
			.map(path->{
				String code=path.toFile().getName().replaceAll(".txt", "");
				try{
					Optional<String> premiereLigneDuFichier=Files.lines(path).findFirst();
					
					String premiereLigne=premiereLigneDuFichier.orElseThrow(()->new StockageException("fichier vide"));
					
					String[] valueTab=premiereLigne.split(";");
					System.out.println();
					
					return new Pizza(code,valueTab[0],Double.valueOf(valueTab[1]),CategoriePizza.valueOf(valueTab[2]));
					
				}catch(IOException e){
					throw new StockageException(e);
					
				}
				}).collect(Collectors.toList());
		}catch(IOException e){
			throw new StockageException(e);
		}
	}
	

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void crediterCompteClient(int id, double montant) throws CreditException {
		// TODO Auto-generated method stub

	}

	@Override
	public void debiterCompteClient(int id, double montant) throws DebitException {
		// TODO Auto-generated method stub

	}

}
