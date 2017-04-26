package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.DaoFactory;

import com.github.lalyos.jfiglet.FigletFont;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		// TODO Auto-generated method stub
		
		//DaoFactory factory=new DaoFichierFactory();
		
		ResourceBundle bundle=ResourceBundle.getBundle("application");
		String valueDao=bundle.getString("pizzeriaDao.val");
		
		System.out.println(valueDao);
		
		Class<?> implDao=Class.forName(valueDao);
		
		DaoFactory factory=(DaoFactory) implDao.newInstance();
		
		//IPizzaDao pizzaDaoMenu=new PizzaDaoImpl();
		//IPizzaDao pizzaDaoMenu=new PizzaDaoImplFichier();
		
		String asciiArt = FigletFont.convertOneLine("Pizza Ascii");
	    System.out.println(asciiArt);
		
		Menu menu=new Menu("##############################PIZZAAAAAAAAAAA########################",factory.getPizzaDao());
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
