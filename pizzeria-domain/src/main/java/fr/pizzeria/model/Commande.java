package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	//############### Attributs ###############
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Numéro")
	private int numero_commande;
	
	@Column(name="Status")
	private String statut;
	
	@Column(name="Date")
	private String date_commande;
	
	@Column(name="Livreur_ID")
	private int livreur_id;
	
	@Column(name="Client_ID")
	private int client_id;
	
	@ManyToOne
	@JoinColumn(name="Livreur_ID",insertable = false, updatable = false)
	private Livreur mappedLivreur;
	
	@ManyToOne
	@JoinColumn(name="Client_ID",insertable = false, updatable = false)
	private Client mappedClient;
	
	@ManyToMany
	@JoinTable(name="commande_pizza",
	joinColumns=@JoinColumn(name="Commande_ID", referencedColumnName="ID"),
	inverseJoinColumns=@JoinColumn(name="Pizza_ID", referencedColumnName="ID"))
	private Set<Pizza> setPizza;
	
	//############### Constructeur ###############

	public Commande(int id, int numero_commande, String statut, String date_commande, int livreur_id, int client_id) {
		this.id = id;
		this.numero_commande = numero_commande;
		this.statut = statut;
		this.date_commande = date_commande;
		this.livreur_id = livreur_id;
		this.client_id = client_id;
	}

	//############### Getters ###############

	public Livreur getLivreur() {
		return mappedLivreur;
	}

	public Client getClient() {
		return mappedClient;
	}

	public Set<Pizza> getSetPizza() {
		return setPizza;
	}

	public int getId() {
		return id;
	}

	public int getNumero_commande() {
		return numero_commande;
	}

	public String getStatut() {
		return statut;
	}

	public String getDate_commande() {
		return date_commande;
	}

	public int getLivreur_id() {
		return livreur_id;
	}

	public int getClient_id() {
		return client_id;
	}

	//############### Setters ###############
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNumero_commande(int numero_commande) {
		this.numero_commande = numero_commande;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public void setDate_commande(String date_commande) {
		this.date_commande = date_commande;
	}

	public void setLivreur_id(int livreur_id) {
		this.livreur_id = livreur_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	
	public void setLivreur(Livreur livreur) {
		this.mappedLivreur = livreur;
	}

	public void setClient(Client client) {
		this.mappedClient = client;
	}

	public void setSetPizza(Set<Pizza> setPizza) {
		this.setPizza = setPizza;
	}
	

}
