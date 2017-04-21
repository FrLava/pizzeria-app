package fr.pizzeria.console;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.dao.IPizzaDao;
import optionMenu.AjouterPizzaOptionMenu;
import optionMenu.CrediterCompteClientOptionMenu;
import optionMenu.DebiterCompteClientOptionMenu;
import optionMenu.ListerClientOptionMenu;
import optionMenu.ListerPizzaOptionMenu;
import optionMenu.ModifierPizzaOptionMenu;
import optionMenu.OptionMenu;
import optionMenu.SupprimerPizzaOptionMenu;

public class Menu {
	
	//############### Attributs ###############
	private String titreMenu; 
	
	private static final int AFFICHER_PIZZAS=1;
	private static final int AJOUTER_PIZZA=2;
	private static final int MODIFIER_PIZZA=3;
	private static final int SUPPRIMER_PIZZA=4;
	private static final int AFFICHER_CLIENTS=5;
	private static final int CREDITER_CLIENT=6;
	private static final int DEBITER_CLIENT=7;
	
	//OptionMenu[] optionMenu=new OptionMenu[5];
	Map<Integer,OptionMenu> optionMenu=new TreeMap<>();
	
	//############### Méthodes ###############
	public Menu(String titre, IPizzaDao pizzaDaoMenu)
	{
		titreMenu=titre;

		optionMenu.put(AFFICHER_PIZZAS,new ListerPizzaOptionMenu(pizzaDaoMenu));
		optionMenu.put(AFFICHER_PIZZAS,new ListerPizzaOptionMenu(pizzaDaoMenu));
		optionMenu.put(AJOUTER_PIZZA,new AjouterPizzaOptionMenu(pizzaDaoMenu));
		optionMenu.put(MODIFIER_PIZZA,new ModifierPizzaOptionMenu(pizzaDaoMenu));
		optionMenu.put(SUPPRIMER_PIZZA,new SupprimerPizzaOptionMenu(pizzaDaoMenu));
		optionMenu.put(AFFICHER_CLIENTS, new ListerClientOptionMenu(pizzaDaoMenu));
		optionMenu.put(CREDITER_CLIENT, new CrediterCompteClientOptionMenu(pizzaDaoMenu));
		optionMenu.put(DEBITER_CLIENT, new DebiterCompteClientOptionMenu(pizzaDaoMenu)); 
	}
	
	public void afficherMenu()
	{
		System.out.println(titreMenu);
		System.out.println(optionMenu.get(AFFICHER_PIZZAS).getLibelle());
		System.out.println(optionMenu.get(AJOUTER_PIZZA).getLibelle());
		System.out.println(optionMenu.get(MODIFIER_PIZZA).getLibelle());
		System.out.println(optionMenu.get(SUPPRIMER_PIZZA).getLibelle());
		System.out.println(optionMenu.get(AFFICHER_CLIENTS).getLibelle());
		System.out.println(optionMenu.get(CREDITER_CLIENT).getLibelle());
		System.out.println(optionMenu.get(DEBITER_CLIENT).getLibelle());
		System.out.println("99 Quitter l'application");
		
	} 
	
	public void getNumOption(int numOption)
	{
		if(numOption!=99)
		{
			if(numOption==3||numOption==4)
			{
				optionMenu.get(AFFICHER_PIZZAS).execute();
			}
			optionMenu.get(numOption).execute();
		}
		
	}
	
}
