package chefs;

import implementations.ChefImpl;

public class PastryChef extends ChefImpl {

	public PastryChef(String name, double cookTime, double salary, int yearsExperience) {
		super(name, cookTime, salary, yearsExperience);
		
	}

	@Override
	public void cook() {
		System.out.println("The Pastry Chef made a Pastry!");
	}

	@Override
	public void upgrade() {
		if(!(this.getCookTime() < 0.2)) {
			this.setCookTime(this.getCookTime() - 0.5);
		}
		
		this.setSalary(this.getSalary() + 330);
		this.setYearsExperience(this.getYearsExperience() + 1);
	}

}
