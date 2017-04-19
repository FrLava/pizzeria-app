package fr.pizzeria.model;

import java.util.Scanner;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.console.ihm.OptionMenu;
import fr.pizzeria.exception.CreditException;

public class CrediterCompteClientOptionMenu extends OptionMenu {

	public CrediterCompteClientOptionMenu(IPizzaDao pizzaDaoMenu) {
		this.nomOptionMenu="6. Crediter Compte Client";
		this.pizzaDao=pizzaDao;
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		
		Scanner scanModif=new Scanner(System.in);

		  
		 System.out.println("Crediter un compte");
	     System.out.println("Veuillez saisir le code du client a crediter");
	     int idClientCredit = scanModif.nextInt();
	     System.out.println("Veuillez saisir le montant");
		 double montant=scanModif.nextDouble();
		 
		 try 
		 {
			 this.pizzaDao.crediterCompteClient(idClientCredit, montant);
		 } 
		 catch (CreditException e) 
		 {
			// TODO Auto-generated catch block
			System.out.println("Trop d'argent");
		} 
		
		return false;
	}

}