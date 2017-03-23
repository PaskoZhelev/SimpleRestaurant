package factories;

import chefs.ItalianChef;
import chefs.PastryChef;
import chefs.SushiChef;
import interfaces.Chef;

public class ChefFactory {

	public static Chef createChef(String[] input) {
		try {
			String chefType = input[0];
			String name = input[1];
			double cookTime = Double.valueOf(input[2]);
			double salary = Double.valueOf(input[3]);
			int yearsExperience = Integer.valueOf(input[4]);

			switch (chefType.toLowerCase()) {
			case "italian":
				return new ItalianChef(name, cookTime, salary, yearsExperience);
			case "sushi":
				return new SushiChef(name, cookTime, salary, yearsExperience);
			case "pastry":
				return new PastryChef(name, cookTime, salary, yearsExperience);
			default:
				throw new IllegalArgumentException("The Restaurant does not need this type of chefs at the moment");
			}
			
		} catch (Exception e) {
			System.out.println("Invalid input");
			return null;
		}
	}

}
