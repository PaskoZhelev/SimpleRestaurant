package factories;

import java.util.List;

import interfaces.Client;
import interfaces.Table;
import providers.Restaurant;

public class OrderFactory {
	
	public static final void completeOrder(Restaurant restaurant, String order){
		switch (order.toLowerCase()) {
		case "pizza":
			try {
				restaurant.getItalianChef().cook();
			} catch (Exception e) {
				System.out.println("There is no Italian Chef");
			}			
			break;
		case "sushi":
			try {
				restaurant.getSushiChef().cook();
			} catch (Exception e) {
				System.out.println("There is no Sushi Chef");
			}
			
			break;
		case "pastry":
			try {
				restaurant.getPastryChef().cook();
			} catch (Exception e) {
				System.out.println("There is no Pastry Chef");
			}
			break;
		default:
			break;
		}
	}
}
