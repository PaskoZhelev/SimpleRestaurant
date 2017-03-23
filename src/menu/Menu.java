package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import factories.ChefFactory;
import factories.OrderFactory;
import implementations.ClientImpl;
import implementations.TableImpl;
import interfaces.Chef;
import interfaces.Client;
import interfaces.Table;
import interfaces.Warehouse;
import providers.Restaurant;


public class Menu {
	
	private Scanner scanner;
	private String input;
	private Restaurant restaurant;
	
	public Menu(Restaurant restaurant){
		scanner = new Scanner(System.in);
		input = "";
		this.restaurant = restaurant;
	}

	public final Restaurant getRestaurant() {
		return this.restaurant;
	}

	public final void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public final int mainMenuChoice(){
		System.out.println();
		System.out.println("What is your choice? Press the specified number:");
		System.out.println();
		System.out.println("1. New Clients and Orders");
		System.out.println("2. Complete Orders");
		System.out.println("3. Clients finished eating");
		System.out.println("4. Hire Chef");
		System.out.println("5. Upgrade Chef");
		System.out.println("6. Buy Ingredient");
		System.out.println("7. Buy new Tables");
		System.out.println("8. Restaurant Information");
		System.out.println("9. Close Restaurant");
		System.out.println();
		
		input = scanner.nextLine();
		int choice = Integer.valueOf(input);
		
		return choice;		
	}
	
	public final void newClientsOption() {
		try {
			input = scanner.nextLine();
			StringBuilder sb = new StringBuilder();
			sb.append("Menu:");
			this.getRestaurant().getMenu().stream().forEach(meal -> {
				sb.append(" ");
				sb.append(meal);
			});
			System.out.println(sb.toString());
			System.out.println();
			String[] tokens = input.split("\\s+");
			int numTable = Integer.valueOf(tokens[0]);
			int numClients = Integer.valueOf(tokens[1]);
			Table chosenTable = this.getRestaurant().getTables().get(numTable);
			List<Client> clients = new ArrayList<>();
			for (int i = 1; i <= numClients; i++) {
				System.out.printf("Client %d orders: ", i);
				input = scanner.nextLine();
				String[] orderTokens = input.split("\\s+");
				Client client = new ClientImpl(Arrays.asList(orderTokens));
				clients.add(client);
			}
			System.out.println("Orders Received!");
			chosenTable.setClients(clients);
			chosenTable.setOccupied(true);

		} catch (Exception e) {
			System.out.println("Invalid orders");
		}
	}

	public final void completeOrdersOption() {
		try {
			input = scanner.nextLine();
			int tableNum = Integer.valueOf(input);
			List<Client> clientsOnTable = this.getRestaurant().getTables().get(tableNum).getClients();
			clientsOnTable.stream().forEach(client -> {
				List<String> orders = client.getOrders();
				orders.stream().forEach(order -> {
					OrderFactory.completeOrder(this.getRestaurant(), order);
				});
			});
		} catch (Exception e) {
			System.out.println("Order cannot be completed");
		}
	}

	public final void clientsFinishEatingOption() {
		input = scanner.nextLine();
		int tableNum = Integer.valueOf(input);
		this.getRestaurant().getTables().get(tableNum).setClients(null);
		this.getRestaurant().getTables().get(tableNum).setOccupied(false);
	}

	public final void hireChefOption() {
		// [Type][Name][Cook Time][Salary][Years Of Experience]
		try {
			input = scanner.nextLine();
			String[] tokens = input.split("\\s+");
			String chefType = tokens[0];
			Chef chef = ChefFactory.createChef(tokens);
			if(!chef.equals(null)){
				this.getRestaurant().hireChef(chef, chefType);
				System.out.println("Chef is hired!");
			} else{
				System.out.println("Invalid input");
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
		}

	}
	
	public final void upgradeChefOption() {
		System.out.println("Name of the Chef: ");
		input = scanner.nextLine();
		String name = input;
		List<Chef> chefs = this.getRestaurant().getAllChefs();
		Chef chefForUpgrade = null;
		for (Chef chef : chefs) {
			if(chef.getName().equals(name)){
				chefForUpgrade = chef;
				break;
			}
		}
		
		chefForUpgrade.upgrade();
	}
	
	public final void buyIngredients(){
		System.out.println("[Type][Quantity]:");
		try {
			input = scanner.nextLine();
			String[] tokens = input.split("\\s+");
			String ingredientType = tokens[0];
			int quantity = Integer.valueOf(tokens[1]);
			
			Warehouse warehouse = this.getRestaurant().getWarehouse();
			
			switch (ingredientType.toLowerCase()) {
			case "dough":
				warehouse.setDoughQuantity(warehouse.getDoughQuantity() + quantity);
				System.out.println("Ingredient Bought successfully!");
				break;
			case "nori":
				warehouse.setNoriQuantity(warehouse.getNoriQuantity() + quantity);
				System.out.println("Ingredient Bought successfully!");
				break;
			case "sugar":
				warehouse.setSugarQuantity(warehouse.getSugarQuantity() + quantity);
				System.out.println("Ingredient Bought successfully!");
				break;
			default:
				System.out.println("There is no need of this ingredient");
				break;
			}
		} catch (Exception e) {
			System.out.println("Invalid ingredient input");
		} 

	}
	
	public final void buyNewTableOption(){
		Table table = new TableImpl<>();
		this.getRestaurant().addTable(table);
		System.out.println("A new table is bought!");
	}
	
	
	
}
