package optionMenu;

import java.util.Scanner;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

//Cette classe permet de g�nerer une option permettant de modifer une pizza
public class ModifierPizzaOptionMenu extends OptionMenu {

	//Attributs
	private String codePizzaAModif;
	Pizza pizza;
	
	//Constructeur
	public ModifierPizzaOptionMenu(IPizzaDao pizzaDao)
	{
		this.nomOptionMenu="3. Mettre à jour une pizza";
		this.pizzaDao=pizzaDao;
	}
	
	//Methodes
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		
		 Scanner scanModif=new Scanner(System.in);

		  
		 System.out.println("Modifier une pizza");
	     System.out.println("Veuillez saisir le code de la pizza � modifier");
	     codePizzaAModif=scanModif.nextLine();
	     System.out.println("Veuillez saisir le code");
		 String codePizza=scanModif.nextLine();
		 System.out.println("Veuillez saisir le nom (sans espace)");
		 String nomPizza=scanModif.nextLine();
		 System.out.println("Veuillez saisir le prix");
		 double prixPizza=scanModif.nextDouble();
		  
		 pizza=new Pizza(codePizza, nomPizza, prixPizza,CategoriePizza.VIANDE);
		 
		 try 
		 {
			 this.pizzaDao.updatePizza(codePizzaAModif, pizza);
		 } 
		 catch (UpdatePizzaException e) 
		 {
			// TODO Auto-generated catch block
			System.out.println("Mauvaise entrée");
		} 
		 
		
		return true;
	}

}
