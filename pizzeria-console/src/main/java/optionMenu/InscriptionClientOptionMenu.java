package optionMenu;

import fr.pizzeria.dao.IPizzaDao;

public class InscriptionClientOptionMenu extends OptionMenu {

	public InscriptionClientOptionMenu(IPizzaDao pizzaDao) {
		this.pizzaDao=pizzaDao;
	}
	
	@Override
	public boolean execute() {
		System.out.println("");
		return false;
	}

}
