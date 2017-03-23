package providers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import interfaces.Table;

public class TableAvailability {
		
	public final void getFreeTables(Restaurant restaurant){
		TreeMap<Integer, Table> tables = restaurant.getTables();
		List<Integer> freeTables = new ArrayList<>();
		for (Map.Entry<Integer, Table> entry: tables.entrySet()) {
			if(!entry.getValue().isOccupied()){
				freeTables.add(entry.getKey());
			}
		}
		StringBuilder sb = new StringBuilder();
		
		if(!freeTables.isEmpty()){
			sb.append("The free tables are: ");
			freeTables.stream()
						.forEach(table -> {
							sb.append(table);
							sb.append(" ");
						});
			System.out.println(sb.toString());
		} else{
			System.out.println("There are no free tables!");
		}
	}

	public final int getNumberFreeTables(Restaurant restaurant){
		int free = 0;
		TreeMap<Integer, Table> tables = restaurant.getTables();
		for (Table table : tables.values()) {
			if(!table.isOccupied()){
				free++;
			}
		}
		
		return free;
	}
	
	public final void getOcuppiedTables(Restaurant restaurant){
		TreeMap<Integer, Table> tables = restaurant.getTables();
		List<Integer> ocuppiedTables = new ArrayList<>();
		for (Map.Entry<Integer, Table> entry: tables.entrySet()) {
			if(entry.getValue().isOccupied()){
				ocuppiedTables.add(entry.getKey());
			}
		}
		StringBuilder sb = new StringBuilder();
		
		if(!ocuppiedTables.isEmpty()){
			sb.append("The ocuppied tables are: ");
			ocuppiedTables.stream()
						.forEach(table -> {
							sb.append(table);
							sb.append(" ");
						});
			System.out.println(sb.toString());
		} else{
			System.out.println("There are no ocuppied tables!");
		}
	}
	
}
