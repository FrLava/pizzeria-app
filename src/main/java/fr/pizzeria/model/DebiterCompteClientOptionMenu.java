package fr.pizzeria.model;

import java.util.Scanner;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.console.ihm.OptionMenu;
import fr.pizzeria.exception.DebitException;

public class DebiterCompteClientOptionMenu extends OptionMenu {

	public DebiterCompteClientOptionMenu(IPizzaDao pizzaDaoMenu) {
		this.nomOptionMenu="7. Debiter Compte Client";
		this.pizzaDao=pizzaDao;
	}
	
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		Scanner scanModif=new Scanner(System.in);

		  
		 System.out.println("Debiter un compte");
	     System.out.println("Veuillez saisir le code du client a debiter");
	     int idClientDebit = scanModif.nextInt();
	     System.out.println("Veuillez saisir le montant");
		 double montant=scanModif.nextDouble();
		 
		 try 
		 {
			 this.pizzaDao.debiterCompteClient(idClientDebit, montant);
		 } 
		 catch (DebitException e) 
		 {
			// TODO Auto-generated catch block
			System.out.println("T'es pauvre");
		} 
		return false;
	}

}
