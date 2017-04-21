package fr.pizzeria.console.ihm;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichierTest{
	
	@Test
	public void test_findAllPizza_a_l_initialisation(){
	
			PizzaDaoImplFichier pizzaDao=new PizzaDaoImplFichier();
			List<Pizza> listPizza=new ArrayList<>();
	
			listPizza=pizzaDao.findAllPizzas();
	
			Assert.assertTrue("La liste n'est pas null", !listPizza.isEmpty());
		}
	}