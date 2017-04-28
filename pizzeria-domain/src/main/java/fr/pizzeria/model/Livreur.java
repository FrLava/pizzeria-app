package fr.pizzeria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="livreur")
public class Livreur {

	//############### Attributs ###############
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="Prenom")
	private String prenom;
	
	@OneToMany(mappedBy="mappedLivreur")
	private Set<Commande> commandes;
	
	//############### Constructeur ###############
	
	public Livreur (int id,String nom,String prenom){
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		commandes=new HashSet<Commande>();
	}

	//############### Getters ###############
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	public Set<Commande> getCommandes() {
		return commandes;
	}
	
	//############### Setters ###############

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
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
	
}
