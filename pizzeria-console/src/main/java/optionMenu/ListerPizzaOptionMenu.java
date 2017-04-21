package optionMenu;

import fr.pizzeria.dao.IPizzaDao;

//Cette classe permet de g�n�rer une option permettant de lister des pizzas
public class ListerPizzaOptionMenu extends OptionMenu {
	
	//Constructeur
	public ListerPizzaOptionMenu(IPizzaDao pizzaDao)
	{
		this.nomOptionMenu="1. Lister les pizzas";
		this.pizzaDao=pizzaDao;
	}
	
	//Methodes
	@Override
	public boolean execute() {
		
		int i;
		
		for(i=0;i<this.pizzaDao.findAllPizzas().size();i++)
		{
			this.pizzaDao.findAllPizzas().get(i).displayPizzas();
		}
		
		return true;
	}
	
	
}
