import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import factories.ChefFactory;
import implementations.ClientImpl;
import implementations.TableImpl;
import interfaces.Client;
import interfaces.Table;
import menu.Menu;
import providers.Restaurant;
import providers.TableAvailability;

public class OpenRestaurant {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";

		Restaurant restaurant = new Restaurant("Magnificent");
		TableAvailability tableAvailability = new TableAvailability();
		Menu menu = new Menu(restaurant);

		MenuBlock: {
			while (true) {
				int choice = menu.mainMenuChoice();

				switch (choice) {
				case 1:
					tableAvailability.getFreeTables(restaurant);
					System.out.println("[Table Number][Number of Clients]: ");
					menu.newClientsOption();
					break;
				case 2:
					tableAvailability.getOcuppiedTables(restaurant);
					System.out.println("Complete Orders of table: ");
					menu.completeOrdersOption();
					break;
				case 3:
					tableAvailability.getOcuppiedTables(restaurant);
					System.out.println("Clients have finished eating on table: ");
					menu.clientsFinishEatingOption();
					break;
				case 4:
					System.out.println("[Type][Name][Cook Time][Salary][Years Of Experience]");
					menu.hireChefOption();
					break;
				case 5:
					menu.upgradeChefOption();
					break;
				case 6:
					menu.buyIngredients();
					break;
				case 7:
					menu.buyNewTableOption();
					break;
				case 8:
					System.out.println(restaurant);
					break;
				case 9:
					System.out.println("The Restaurant is closed!");
					System.exit(0);
				default:
					System.out.println("Invalid input choice");
					break;
				}
			}
		}
	}

}
