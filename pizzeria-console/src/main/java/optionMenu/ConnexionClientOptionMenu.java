package optionMenu;

import fr.pizzeria.dao.IPizzaDao;

public class ConnexionClientOptionMenu extends OptionMenu {

	public ConnexionClientOptionMenu(IPizzaDao pizzaDaoMenu) {
		this.pizzaDao=pizzaDaoMenu;
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		return false;
	}

}
