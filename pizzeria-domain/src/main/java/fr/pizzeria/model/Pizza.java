package fr.pizzeria.model;

public class Pizza {
	
	//############### Attributs ###############
	
	//private int idPizza;
	@ToString
	private String codePizza;
	@ToString
	private String nomPizza;
	@ToString
	private double prixPizza;
	private CategoriePizza catPizza;
	
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
	
	/*public int getId()
	{
		return idPizza;
	}*/
	
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
	
	/*public void setId(int id)
	{
		idPizza=id;
	}*/
}
