package fr.pizzeria.console.client;

import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.dao.IPizzaDao;
import optionMenu.ConnexionClientOptionMenu;
import optionMenu.InscriptionClientOptionMenu;
import optionMenu.OptionMenu;

public class Menu_Client {

	//############### Attributs ###############
		private String titreMenu; 
		
		private static final int INSCRIPTION=1;
		private static final int CONNEXION=2;
	
		
		//OptionMenu[] optionMenu=new OptionMenu[5];
		Map<Integer,OptionMenu> optionMenu=new TreeMap<>();
		
		//############### Méthodes ###############
		public Menu_Client(String titre, IPizzaDao pizzaDaoMenu)
		{
			titreMenu=titre;

			optionMenu.put(INSCRIPTION,new InscriptionClientOptionMenu(pizzaDaoMenu));
			optionMenu.put(CONNEXION,new ConnexionClientOptionMenu(pizzaDaoMenu));
			
		}
		
		public void afficherMenu()
		{
			System.out.println(titreMenu);
			System.out.println(optionMenu.get(INSCRIPTION).getLibelle());
			System.out.println(optionMenu.get(CONNEXION).getLibelle());
			
			System.out.println("99 Quitter l'application");
			
		} 
		
		public void getNumOption(int numOption)
		{
			if(numOption!=99)
			{
				
				optionMenu.get(numOption).execute();
			}
			
		}
		
	}
	

