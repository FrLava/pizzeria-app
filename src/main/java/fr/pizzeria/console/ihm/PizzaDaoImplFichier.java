package fr.pizzeria.console.ihm;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.DaoFichierFactory;
import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;

public class PizzaDaoImplFichier implements IPizzaDao {

	@Override
	public List<Pizza> findAllPizzas() { //permet de récuperer une liste de pizza depuis un fichier
		try (Stream<Path> list = Files.list(Paths.get(DaoFichierFactory.getDIRName()))){ 	//Recupère la liste des fichier present 
																							// dans le repertoire DIRName de DaoFichierFactory
														
			return list.map(path->{ //map le path en pizzas 
			String code=path.toFile().getName().replaceAll(".txt", ""); //Recupère le code de pizza avec le nom du 
																		//fichier en enlevant le .txt
			
			try(Stream<String> lines = Files.lines(path);){ //Cette notation permet de fermer le stream à la fin du bloc try et de liberer la ressource
				
				Optional<String> premiereLigneDuFichier=lines.findFirst(); 	//Recupère la première ligne du fichier, 
																						//on utilise un Optional pour eviter l'exception
																						//si le fichier est vide
				
				String premiereLigne=premiereLigneDuFichier.orElseThrow(()->new StockageException("fichier vide"));	//Permet de gèrer l'exception si le fichier est vide
				
				String[] valueTab=premiereLigne.split(";");	//Recupère les éléments de la ligne avec pour séparateur un ";"
				
				return new Pizza(code,valueTab[0],Double.valueOf(valueTab[1]),CategoriePizza.valueOf(valueTab[2])); //Retourne la pizza créer
				
			}catch(IOException e){
				throw new StockageException(e);
				
			}
			}).collect(Collectors.toList()); //Collecte toutes les pizzas
		}catch(IOException e){
			throw new StockageException(e);
		}
	}
	

	@Override
	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		List<String> ligneAEcrire=Arrays.asList(pizza.getNom()+";"+pizza.getPrix()+";"+pizza.getCategorie());
		String nomDuFichier=DaoFichierFactory.getDIRName()+"/"+pizza.getCode()+".txt";
		
		try {
			
			Path file = Paths.get(nomDuFichier);
			Files.write(file, ligneAEcrire, Charset.forName("UTF-8"));
			
			
		} catch (IOException e) {

			throw new StockageException(e);
		}
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
//		List<String> ligneAEcrire=Arrays.asList(pizza.getNom()+";"+pizza.getPrix()+";"+pizza.getCategorie());
//		String nomDuFichier=DaoFichierFactory.getDIRName()+"/"+codePizza+".txt";
//		
//		try {
//			
//			Path file = Paths.get(nomDuFichier);
//			
//			Files.write(file, ligneAEcrire, Charset.forName("UTF-8"),StandardOpenOption.WRITE,StandardOpenOption.TRUNCATE_EXISTING);
//			
//			
//		} catch (IOException e) {
//
//			throw new StockageException(e);
//		}
//		
		
		this.deletePizza(codePizza);
		this.saveNewPizza(pizza);
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		try {
			Files.deleteIfExists(Paths.get(DaoFichierFactory.getDIRName(),codePizza+".txt"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DeletePizzaException(e);
		}
		return true;
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
