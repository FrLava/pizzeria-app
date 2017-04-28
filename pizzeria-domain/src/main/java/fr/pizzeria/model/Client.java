package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	//######################## Attribut ########################
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Nom")
	private String nom; 
	
	@Column(name="Prenom")
	private String prenom;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MDP")
	private String mdp;
	
	@OneToMany(mappedBy="mappedClient")
	private Set<Commande> setCommandes;
	
	//######################## Constructeur par defaut ########################
	public Client()
	{
		this.id=0;
		this.nom="Doe";
		this.prenom="Jhon";
	}
	
	//######################## Constructeur ########################
	public Client(int id, String nom, String prenom,String email,String mdp)
	{
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.mdp=mdp;
	}
	

	



	public String toString()
	{
		String info=this.nom+" "+this.prenom;
		return info;
	}

	//######################## Getters ########################
	
	public Set<Commande> getSetCommandes() {
		return setCommandes;
	}

	public String getEmail() {
		return email;
	}

	public String getMdp() {
		return mdp;
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

	//######################## Setters ########################
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	public void setSetCommandes(Set<Commande> setCommandes) {
		this.setCommandes = setCommandes;
	}

}
