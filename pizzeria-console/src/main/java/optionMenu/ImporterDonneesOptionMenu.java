package optionMenu;

import fr.pizzeria.dao.IPizzaDao;

public class ImporterDonneesOptionMenu extends OptionMenu {

	//Constructeur
	public ImporterDonneesOptionMenu(IPizzaDao pizzaDao) {
		this.nomOptionMenu="10. Importer des données";
		this.pizzaDao=pizzaDao;
		}
	
	@Override
	public boolean execute() {
		this.pizzaDao.importFichierEnBase();
		return false;
	}

}
