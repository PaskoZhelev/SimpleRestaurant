package chefs;

import implementations.ChefImpl;

public class SushiChef extends ChefImpl{

	public SushiChef(String name, double cookTime, double salary, int yearsExperience) {
		super(name, cookTime, salary, yearsExperience);
		
	}

	@Override
	public void cook() {
		System.out.println("The Sushi Chef made a Sushi Roll!");
	}

	@Override
	public void upgrade() {
		if(!(this.getCookTime() < 0.3)) {
			this.setCookTime(this.getCookTime() - 0.15);
		}
		
		this.setSalary(this.getSalary() + 180);
		this.setYearsExperience(this.getYearsExperience() + 1);
	}

}
