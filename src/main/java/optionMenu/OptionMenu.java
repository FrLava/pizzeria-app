package optionMenu;

import fr.pizzeria.console.ihm.IPizzaDao;

//Cette Super classe permet de concevoir des options pour un menu
public abstract class OptionMenu {
	
	//Attribut
	protected String nomOptionMenu;
	protected IPizzaDao pizzaDao;
	
	//Methodes
	public String getLibelle()
	{
		return nomOptionMenu;
	}
	
	public abstract boolean execute();

}
