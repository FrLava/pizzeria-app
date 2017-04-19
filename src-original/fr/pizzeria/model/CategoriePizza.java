package fr.pizzeria.model;

public enum CategoriePizza {
	
	POISSON ("Poisson"), 
	VIANDE ("Viande"),
	SANS_VIANDE ("Sans Viande");
	
	private String nomCategorie;
	
	CategoriePizza(String nomCategorie)
	{
		this.nomCategorie=nomCategorie;
	}
	
	public String toString()
	{
		return nomCategorie;
	}
}
