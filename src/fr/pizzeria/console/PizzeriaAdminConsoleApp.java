package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.console.ihm.IPizzaDao;
import fr.pizzeria.console.ihm.Menu;
import fr.pizzeria.console.ihm.PizzaDaoImpl;
import fr.pizzeria.console.ihm.PizzaDaoImplFichier;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//IPizzaDao pizzaDaoMenu=new PizzaDaoImpl();
		IPizzaDao pizzaDaoMenu=new PizzaDaoImplFichier();
		Menu menu=new Menu("##############################PIZZAAAAAAAAAAA########################",pizzaDaoMenu);
		int resultScan=0;
		
		do
		{
			menu.afficherMenu();
			Scanner scan=new Scanner(System.in);
			
			resultScan=scan.nextInt();
			menu.getNumOption(resultScan);
			
		}while(resultScan!=99);
		
		System.out.println("Au revoir :)");
		
		
	}
	
}
