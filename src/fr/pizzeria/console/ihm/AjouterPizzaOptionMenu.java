package fr.pizzeria.console.ihm;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;

//Cette classe permet de génerer une option permettant d'ajouter une pizza
public class AjouterPizzaOptionMenu extends OptionMenu {

	//Attributs
	Pizza pizza;
	
	//Constructeur
	public AjouterPizzaOptionMenu(IPizzaDao pizzaDao)
	{
		this.nomOptionMenu="2. Ajouter une pizza";
		this.pizzaDao=pizzaDao;
	}
	
	//Methodes

	@Override
	public boolean execute(){
		// TODO Auto-generated method stub
		
		  Scanner scanAjout=new Scanner(System.in);
			
		  System.out.println("Ajout d'une pizza");
	      System.out.println("Veuillez saisir le code");
		  String codePizza=scanAjout.nextLine();
		  System.out.println("Veuillez saisir le nom (sans espace)");
		  String nomPizza=scanAjout.nextLine();
		  System.out.println("Veuillez saisir le prix");
		  double prixPizza=scanAjout.nextDouble();
		  
		  pizza=new Pizza(codePizza, nomPizza, prixPizza,CategoriePizza.VIANDE);
		  
		  try
		  {
			this.pizzaDao.saveNewPizza(this.pizza);
		  } 
		  catch (SavePizzaException e) 
		  {
			// TODO Auto-generated catch block
			System.out.println("Mauvaise entrée");
		  }
		
		return true;
	}

	
}
