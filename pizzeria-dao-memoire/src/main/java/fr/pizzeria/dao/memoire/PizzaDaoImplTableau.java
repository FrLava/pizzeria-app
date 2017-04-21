package fr.pizzeria.dao.memoire;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.exception.CreditException;
import fr.pizzeria.dao.exception.DebitException;
import fr.pizzeria.dao.exception.DeletePizzaException;
import fr.pizzeria.dao.exception.SavePizzaException;
import fr.pizzeria.dao.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

//Cette classe implemente l'interface IPizzaDao et permet de manipuler des listes de pizzas
public class PizzaDaoImplTableau implements IPizzaDao {

	//Attributs
	private List<Pizza> ListPizza=new ArrayList();	
	private List<Client> ListClient=new ArrayList();
	private int indexAjout;

	//Constructeur
	public PizzaDaoImplTableau()
	{
		
		//ListPizza=new Pizza[50];
		ListPizza.add(0,new Pizza("PEP","Pépéroni",12.50, CategoriePizza.VIANDE));
		ListPizza.add(1,new Pizza("MAR","Margherita",14.00, CategoriePizza.VIANDE));
		ListPizza.add(2,new Pizza("REI","La Reine",11.50, CategoriePizza.POISSON));
		ListPizza.add(3,new Pizza("FRO","La 4 Fromages",12.00, CategoriePizza.SANS_VIANDE));
		ListPizza.add(4,new Pizza("CAN","La Cannibale",12.50,CategoriePizza.VIANDE));
		ListPizza.add(5,new Pizza("SAV","La Savoyarde",13.56,CategoriePizza.VIANDE));
		ListPizza.add(6,new Pizza("ORI","L'Orientale",13.50, CategoriePizza.SANS_VIANDE));
		ListPizza.add(7,new Pizza ("IND","L'indienne",14.00,CategoriePizza.POISSON));
		
		ListClient.add(0,new Client(0,"LAVAUD","Franc",100));
		ListClient.add(1,new Client(1,"toto","Abdel",23));
		ListClient.add(2,new Client(2,"tio","osdhvo",56));
	}
	
	//Méthodes
	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		return ListPizza;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException{
		// TODO Auto-generated method stub
	
		int i;
		
		if(this.codeEstPresent(pizza.getCode()))
		{
			throw new SavePizzaException("Mauvaise saisie");
		}

		
		ListPizza.add(pizza);
		
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		// TODO Auto-generated method stub
		
		int i;
		
		
		if(!this.codeEstPresent(codePizza))
		{
			throw new UpdatePizzaException("Code non existant");
		}
		
		for(i=0;i<ListPizza.size();i++)
		{
			if(ListPizza.get(i).getCode().equals(codePizza))
			{
				ListPizza.set(i, pizza);
			}
		}
		
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException{
		// TODO Auto-generated method stub
		
		int i;
			
		if(!this.codeEstPresent(codePizza))
		{
			throw new DeletePizzaException("Code non existant");
		}

		for(i=0;i<ListPizza.size();i++)
		{
			if(ListPizza.get(i).getCode().equals(codePizza))
			{
				ListPizza.remove(i);
			}
		}
		
		
		return true;
	}
	
	public  List<Client> findAllClient()
	{
		return ListClient;
	}
	
	public void crediterCompteClient(int id,double montant) throws CreditException
	{
		
		if((montant+ListClient.get(id).getSolde())>5000)
			throw new CreditException("");
		
		ListClient.get(id).crediterCompte(montant);
		
	}
	
	public void debiterCompteClient(int id,double montant) throws DebitException
	{
		
		if((montant+ListClient.get(id).getSolde())<0)
			throw new DebitException("");
		
		ListClient.get(id).crediterCompte(montant);
	}

	private boolean codeEstPresent(String code)
	{
		
		int i;
		for(i=0;i<ListPizza.size();i++)
		{	
			if(ListPizza.get(i).getCode().equals(code))
			{
				return true;
			}
		}	
		
		return false;
	}
	
}
