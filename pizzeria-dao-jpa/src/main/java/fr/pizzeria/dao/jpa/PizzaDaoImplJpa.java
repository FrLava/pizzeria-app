package fr.pizzeria.dao.jpa;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.exception.CreditException;
import fr.pizzeria.dao.exception.DebitException;
import fr.pizzeria.dao.exception.DeletePizzaException;
import fr.pizzeria.dao.exception.SavePizzaException;
import fr.pizzeria.dao.exception.UpdatePizzaException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJpa implements IPizzaDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzeria-unit");

	@Override
	public List<Pizza> findAllPizzas() {
		EntityManager em=emf.createEntityManager();
		
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		
		//em.close();
		
		return query.getResultList();
	}

	@Override
	public List<Client> findAllClient() {
		EntityManager em=emf.createEntityManager();
		
		TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
	
		return query.getResultList();
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		
		em.persist(pizza);
			
		et.commit();
		
		em.close();
		
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		TypedQuery<Pizza> pQuery=em.createQuery("select p from Pizza p where p.codePizza=:Code",Pizza.class);
		pQuery.setParameter("Code", codePizza);
		Pizza p=pQuery.getResultList().get(0);
		
		et.begin();
		
		if(p!=null){
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
		}
		
		et.commit();
		em.close();
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		TypedQuery<Pizza> pQuery=em.createQuery("select p from Pizza p where p.codePizza=:Code",Pizza.class);
		pQuery.setParameter("Code", codePizza);
        
		Pizza p=pQuery.getResultList().get(0);
		
        et.begin();
        
		if(p!=null){
			em.remove(p);
		}
		
		et.commit();
        em.close();
		
		return false;
	}

	@Override
	public boolean importFichierEnBase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void crediterCompteClient(int id, double montant) throws CreditException {
		// TODO Auto-generated method stub

	}

	@Override
	public void debiterCompteClient(int id, double montant) throws DebitException {
		// TODO Auto-generated method stub

	}

}
