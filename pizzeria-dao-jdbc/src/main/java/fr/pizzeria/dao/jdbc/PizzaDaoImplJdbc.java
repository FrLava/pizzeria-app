package fr.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.exception.CreditException;
import fr.pizzeria.dao.exception.DebitException;
import fr.pizzeria.dao.exception.DeletePizzaException;
import fr.pizzeria.dao.exception.SavePizzaException;
import fr.pizzeria.dao.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.CategoriePizza;;

public class PizzaDaoImplJdbc implements IPizzaDao{

	@Override
	public List<Pizza> findAllPizzas() {
		
		List<Pizza> listPizza=new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection myConnection=null;
		try {
			myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Statement statementQuery=null;
		
		try {
			statementQuery=myConnection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ResultSet resultat=null;
		
		try {
			resultat=statementQuery.executeQuery("SELECT * FROM pizza");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(resultat.next()){ 
				 Pizza pizza=new Pizza(resultat.getString("Code"),
						 resultat.getString("Name"),
						 resultat.getDouble("Prix"),
						 CategoriePizza.valueOf(resultat.getString("Categorie")));
				 listPizza.add(pizza);
				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listPizza;
	}

	@Override
	public List<Client> findAllClient() {
		
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		
		return false;
	}

	@Override
	public void crediterCompteClient(int id, double montant) throws CreditException {
		
		
	}

	@Override
	public void debiterCompteClient(int id, double montant) throws DebitException {
		
		
	}

}
