package chefs;

import implementations.ChefImpl;

public class ItalianChef extends ChefImpl {

	public ItalianChef(String name, double cookTime, double salary, int yearsExperience) {
		super(name, cookTime, salary, yearsExperience);		
	}

	@Override
	public void cook() {
		System.out.println("The Italian Chef made a Pizza!");
	}

	@Override
	public void upgrade() {
		if(!(this.getCookTime() < 0.5)) {
			this.setCookTime(this.getCookTime() - 0.3);
		}
		
		this.setSalary(this.getSalary() + 250);
		this.setYearsExperience(this.getYearsExperience() + 1);
	}

}
