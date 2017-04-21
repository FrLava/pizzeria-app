package optionMenu;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.exception.DeletePizzaException;

//Cette classe permet de génerer une option permettant de supprimer une pizza
public class SupprimerPizzaOptionMenu extends OptionMenu {

	//Attributs
	private String codePizza;
	
	//Constructeur
	public SupprimerPizzaOptionMenu(IPizzaDao pizzaDao)
	{
		this.nomOptionMenu="4. Supprimer une pizza";
		this.pizzaDao=pizzaDao;
	}
	
	//Methodes
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		
		Scanner scanSuppr=new Scanner(System.in);
		  
		System.out.println("Supprimer une pizza");
	    System.out.println("Veuillez saisir le code");
		codePizza=scanSuppr.nextLine();   

		try 
		{
			this.pizzaDao.deletePizza(codePizza);
		}
		catch (DeletePizzaException e)
		{
			// TODO Auto-generated catch block
			System.out.println("Mauvais Code");
		}
		
		return true;
	}
	
	public void setParam(String codePizza)
	{
		this.codePizza=codePizza;
	}

}
