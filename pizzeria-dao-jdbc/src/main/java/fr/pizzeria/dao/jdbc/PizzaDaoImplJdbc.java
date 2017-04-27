package fr.pizzeria.dao.jdbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.exception.CreditException;
import fr.pizzeria.dao.exception.DebitException;
import fr.pizzeria.dao.exception.DeletePizzaException;
import fr.pizzeria.dao.exception.SavePizzaException;
import fr.pizzeria.dao.exception.StockageException;
import fr.pizzeria.dao.exception.UpdatePizzaException;
import fr.pizzeria.dao.fichier.DaoFichierFactory;
import fr.pizzeria.dao.fichier.PizzaDaoImplFichier;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.model.CategoriePizza;

public class PizzaDaoImplJdbc implements IPizzaDao{

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Connection myConnection;
	private Statement statement;
	
	
	
	private void connectDB(){
		
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		String urlDB=bundle.getString("urlDB.val");
		String userDB=bundle.getString("userDB.val");
		String mdpDB=bundle.getString("mdpDB.val");
		
		try {
			myConnection = DriverManager.getConnection(urlDB,userDB,mdpDB);
			myConnection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement=myConnection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	
	private void closeDB(){
		
		try{

			statement.close();
			myConnection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
		
	@Override
	public List<Pizza> findAllPizzas() {
		
		List<Pizza> listPizza=new ArrayList<>();
		
		this.connectDB();
		
		ResultSet resultat=null;
		
		try {
			resultat=statement.executeQuery("SELECT * FROM pizza");
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
		

		this.closeDB();
		
		
		return listPizza;
	}

	@Override
	public List<Client> findAllClient() {
		
		List<Client> listClient=new ArrayList<>();
		
		this.connectDB();
		
		ResultSet resultat=null;
		
		try {
			resultat=statement.executeQuery("SELECT * FROM client");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(resultat.next()){ 
				 Client client=new Client(resultat.getInt("ID"),
						 resultat.getString("Nom"),
						 resultat.getString("Prenom"),
						 resultat.getDouble("Solde"));
				 listClient.add(client);
				 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.closeDB();
		
		return listClient;
		
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		this.connectDB();
		
		int flag=0;
		String requete="INSERT INTO `pizza`(`Code`, `Name`, `Prix`, `Categorie`) "
				+ "VALUES ('"+pizza.getCode()+"','"+pizza.getNom()+"','"+pizza.getPrix()+"','"+pizza.getCategorie()+"')";
		try {
			flag=statement.executeUpdate(requete);
			myConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try{myConnection.rollback();}catch(SQLException x){x.printStackTrace();}
		}
		
		
		this.closeDB();
		
		if(flag==0){
		return false;
		}
		
		else{
			return true;
		}
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		this.connectDB();
		
		int flag=0;
		String requete="UPDATE `pizza` SET "
				+ "`Code`='"+pizza.getCode()+"',"
				+ "`Name`='"+pizza.getNom()+"',"
				+ "`Prix`='"+pizza.getPrix()+"',"
				+ "`Categorie`='"+pizza.getCategorie()+"' "
				+ "WHERE Code='"+codePizza+"';";
		try {
			flag=statement.executeUpdate(requete);
			myConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try{myConnection.rollback();}catch(SQLException x){x.printStackTrace();}
		}
		
		this.closeDB();
		
		if(flag==0){
		return false;
		}
		
		else{
			return true;
		}
		
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		this.connectDB();
		
		int flag=0;
		String requete="DELETE FROM `pizza` WHERE Code='"+codePizza+"';";
		try {
			flag=statement.executeUpdate(requete);
			myConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try{myConnection.rollback();}catch(SQLException x){x.printStackTrace();}
		}
		
		this.closeDB();
		
		if(flag==0){
			return false;
		}
			
		else{
			return true;
		}
	}

	@Override
	public void crediterCompteClient(int id, double montant) throws CreditException {
		
		
	}

	@Override
	public void debiterCompteClient(int id, double montant) throws DebitException {
		
		
	}

	public boolean importFichierEnBase(){
	
		List<Pizza> listPizza=new ArrayList<>();
		PizzaDaoImplFichier dao=new PizzaDaoImplFichier();
		
		listPizza=dao.findAllPizzas();
		
		this.connectDB();
		
		PreparedStatement insertPizza=null;
		
		try {
			insertPizza=myConnection.prepareStatement("INSERT INTO `pizza`(`Code`, `Name`, `Prix`, `Categorie`) VALUES (?,?,?,?);");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i;
		
		try{
			for(i=1;i<listPizza.size();i++){
				insertPizza.setString(1, listPizza.get(i-1).getCode());
				insertPizza.setString(2, listPizza.get(i-1).getNom());
				insertPizza.setDouble(3, listPizza.get(i-1).getPrix());
				insertPizza.setString(4, listPizza.get(i-1).getCategorie());
				insertPizza.execute();
				
				if(i%3==0){
					myConnection.commit();
				}
				
			}
			
		}catch(SQLException sql){
			sql.printStackTrace();
			try{myConnection.rollback();}catch(SQLException sql2){sql2.printStackTrace();}
			
		}
				
		
		return false;
		
	}
}
