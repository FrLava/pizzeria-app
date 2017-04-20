package fr.pizzeria.model;

public class Client {
	
	//######################## Attribut ########################
	private int id;
	private String nom; 
	private String prenom;
	private double solde;
	
	//######################## Constructeur par defaut ########################
	public Client()
	{
		this.id=0;
		this.nom="Doe";
		this.prenom="Jhon";
		this.solde=0;
	}
	
	//######################## Constructeur ########################
	public Client(int id, String nom, String prenom, double solde)
	{
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.solde=solde;
	}
	
	public void crediterCompte(double montant)
	{
		this.solde+=montant;
	}
	
	public void debiterCompte(double montant)
	{
		this.solde-=montant;
	}
	
	public String toString()
	{
		String info=this.nom+" "+this.prenom+" ("+this.solde+"€) ";
		return info;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public double getSolde() {
		return solde;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}
