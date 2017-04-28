package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pizza")
public class Pizza {
	
	//############### Attributs ###############
	
	//private int idPizza;
	@Column(name="Code")
	private String codePizza;
	
	@Column(name="Name")
	private String nomPizza;
	
	@Column(name="Prix")
	private double prixPizza;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Categorie")
	private CategoriePizza catPizza;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
	joinColumns=@JoinColumn(name="Pizza_ID", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="Commande_ID", referencedColumnName="ID"))
	private Set<Commande> setCommande;
	
	//############### Méthodes ###############
	
	//Constructeur par défaut
	public Pizza()
	{
		codePizza="";
		nomPizza="";
		prixPizza=0;
		catPizza=CategoriePizza.VIANDE;
	}
	
	//Constructeur
	public Pizza(String code,String nom,double prix, CategoriePizza cat)
	{
		codePizza=code;
		nomPizza=nom;
		prixPizza=prix;
		catPizza=cat;
		//idPizza=id;
		
	}
	
	//Permet d'afficher une pizza au format suivant : Id: 0 | PEP -> pépéroni (12.5) 
	public void displayPizzas()
	{
		//System.out.print("Id: "+idPizza+" | ");
		System.out.print(this.codePizza);
		System.out.print(" -> ");
		System.out.print(this.nomPizza);
		System.out.print(" ("+this.getPrix()+") ");
		System.out.println(this.getCategorie());
		
	}
	
	public String toString(){
		return this.codePizza
				+" -> "
				+this.nomPizza
				+" ("+this.getPrix()+") "
				+this.getCategorie();
	}
	

	//Accesseurs
	public String getCode()
	{
		return codePizza;
	}
	
	public String getNom()
	{
		return nomPizza;
	}
	
	public double getPrix()
	{
		return prixPizza;
	}
	
	public String getCategorie()
	{
		return catPizza.name();
	}
	
	public int getId()
	{
		return ID;
	}
	
	//Mutateurs
	public void setCode(String code)
	{
		codePizza=code;
	}
	
	public void setNom(String nom)
	{
		nomPizza=nom;
	}
	
	public void setPrix(double prix)
	{
		prixPizza=prix;
	}
	
	public void setId(int id)
	{
		ID=id;
	}
}
