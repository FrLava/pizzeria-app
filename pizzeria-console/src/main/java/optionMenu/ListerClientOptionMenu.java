package optionMenu;

import fr.pizzeria.dao.IPizzaDao;

public class ListerClientOptionMenu extends OptionMenu {

	public ListerClientOptionMenu(IPizzaDao pizzaDao)
	{
		this.nomOptionMenu="5. Lister les Clients";
		this.pizzaDao=pizzaDao;
	}
	
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		int i;
		
		for(i=0;i<this.pizzaDao.findAllClient().size();i++)
		{
			System.out.println(this.pizzaDao.findAllClient().get(i).toString());
		}
		return false;
	}

}
