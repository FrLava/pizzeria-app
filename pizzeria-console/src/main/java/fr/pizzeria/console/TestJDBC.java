package fr.pizzeria.console;

import java.sql.Statement;

//import com.mysql.fabric.proto.xmlrpc.ResultSetParser;

import java.sql.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int i;
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection myConnection =DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false","root","");
		 
		Statement statementLigne=myConnection.createStatement();
		Statement statementQuery=myConnection.createStatement();
		 
		ResultSet resultat=statementQuery.executeQuery("SELECT * FROM pizza");
		ResultSet resultPrepared=null;
		
		PreparedStatement selectClient=myConnection.prepareStatement("SELECT * FROM client WHERE ID=?");
		
		int nbrLigne=0;
		ResultSet tableSize=statementLigne.executeQuery("SELECT COUNT(*) FROM client");
		if(tableSize.next()){
			nbrLigne=tableSize.getInt(1);
		}
		tableSize.close();
		
		for(i=1;i<=nbrLigne;i++){
			 selectClient.setInt(1, i);
			 resultPrepared=selectClient.executeQuery();
			 if(resultPrepared.next()){
				 System.out.print(resultPrepared.getString("ID")+" ");
				 System.out.print(resultPrepared.getString("Nom")+" ");
				 System.out.print(resultPrepared.getString("Prenom")+" ");
				 System.out.print(resultPrepared.getString("Adresse")+" ");
				 System.out.println(resultPrepared.getString("Ville"));
			 }
		}
		
		
		while(resultat.next()){
			 System.out.print(resultat.getString("ID")+" ");
			 System.out.print(resultat.getString("Code")+" ");
			 System.out.print(resultat.getString("Name")+" ");
			 System.out.print(resultat.getString("Prix")+" ");
			 System.out.println(resultat.getString("Categorie"));
		}
		
		resultPrepared.close();
		resultat.close();
		statementQuery.close();
		myConnection.close();
	}

}
