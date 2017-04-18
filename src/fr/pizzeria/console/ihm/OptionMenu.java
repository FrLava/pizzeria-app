package fr.pizzeria.console.ihm;

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
