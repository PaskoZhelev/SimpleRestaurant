package providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import chefs.ItalianChef;
import chefs.PastryChef;
import chefs.SushiChef;
import factories.ChefFactory;
import factories.OrderFactory;
import implementations.ClientImpl;
import implementations.WarehouseImpl;
import interfaces.Chef;
import interfaces.Client;
import interfaces.Table;
import interfaces.Warehouse;

public class Restaurant {

	private String name;
	private Chef italianChef;
	private Chef sushiChef;
	private Chef pastryChef;
	// private List<Table> tables;
	private TreeMap<Integer, Table> tables;
	private Warehouse warehouse;
	private List<String> menu;
	private Scanner scanner;
	private String input;

	public Restaurant(String name) {
		this.name = name;
		tables = new TreeMap<>();
		warehouse = new WarehouseImpl();
		menu = new ArrayList<>();
		menu.add("Pizza");
		menu.add("Sushi Roll");
		menu.add("Pastry");
		scanner = new Scanner(System.in);
		input = "";
	}

	public final void hireChef(Chef chef, String chefType) {
		switch (chefType.toLowerCase()) {
		case "italian":
			this.setItalianChef(chef);
			break;
		case "sushi":
			this.setSushiChef(chef);
			break;
		case "pastry":
			this.setPastryChef(chef);
			break;
		default:
			throw new IllegalArgumentException("The Restaurant does not need this type of chefs at the moment");
		}
	}

	public final List<Chef> getAllChefs(){
		List<Chef> chefs = new ArrayList<>();
		if (!(this.getItalianChef() == null)) chefs.add(this.getItalianChef());
		if (!(this.getSushiChef() == null)) chefs.add(this.getSushiChef());
		if (!(this.getPastryChef() == null)) chefs.add(this.getPastryChef());
		
		return chefs;
	}
	
	public final Chef getItalianChef() {
		return this.italianChef;
	}

	public final void setItalianChef(Chef italianChef) {
		this.italianChef = italianChef;
	}

	public final Chef getSushiChef() {
		return this.sushiChef;
	}

	public final void setSushiChef(Chef sushiChef) {
		this.sushiChef = sushiChef;
	}

	public final Chef getPastryChef() {
		return this.pastryChef;
	}

	public final void setPastryChef(Chef pastryChef) {
		this.pastryChef = pastryChef;
	}

	
	public final String getName() {
		return this.name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void addTable(Table table) {
		if (!this.getTables().isEmpty()) {
			int nextNumTable = this.getTables().size() + 1;
			this.getTables().put(nextNumTable, table);
		} else {
			this.getTables().put(1, table);
		}
	}

	public final TreeMap<Integer, Table> getTables() {
		return this.tables;
	}

	public final void setTables(TreeMap<Integer, Table> tables) {
		this.tables = tables;
		
	}

	public final List<String> getMenu() {
		return this.menu;
	}

	public final Warehouse getWarehouse() {
		return this.warehouse;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Name: %s", this.getName()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Number Of Chefs: %d", this.getAllChefs().size()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Number Of Tables: %d", this.getTables().size()));
		sb.append(System.lineSeparator());
		sb.append("Products in the Warehouse: ");
		sb.append(System.lineSeparator());
		sb.append(String.format("Dough: %d", this.getWarehouse().getDoughQuantity()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Nori: %d", this.getWarehouse().getNoriQuantity()));
		sb.append(System.lineSeparator());
		sb.append(String.format("Sugar: %d", this.getWarehouse().getSugarQuantity()));
		sb.append(System.lineSeparator());
		
		return sb.toString();
	}

}
