package implementations;

import interfaces.Chef;

public abstract class ChefImpl implements Chef {
	
	private String name;
	
	private double cookTime;
	
	private double salary;
	
	private int yearsExperience;
	

	public ChefImpl(String name, double cookTime, double salary, int yearsExperience) {
		this.name = name;
		this.cookTime = cookTime;
		this.salary = salary;
		this.yearsExperience = yearsExperience;
	}

	public abstract void cook();
	
	public abstract void upgrade();
	
	public final String getName() {
		return this.name;
	}

	protected final void setName(String name) {
		this.name = name;
	}

	protected final double getCookTime() {
		return this.cookTime;
	}

	protected final void setCookTime(double cookTime) {
		this.cookTime = cookTime;
	}

	protected final double getSalary() {
		return this.salary;
	}

	protected final void setSalary(double salary) {
		this.salary = salary;
	}

	protected final int getYearsExperience() {
		return this.yearsExperience;
	}

	protected final void setYearsExperience(int yearsExperience) {
		this.yearsExperience = yearsExperience;
	}

}
