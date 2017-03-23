package implementations;

import interfaces.Warehouse;

public class WarehouseImpl implements Warehouse {
	private int doughQuantity;
	private int noriQuantity;
	private int sugarQuantity;
	
	public WarehouseImpl(){
		this.doughQuantity = 0;
		this.noriQuantity = 0;
		this.sugarQuantity = 0;
	}
	
	public WarehouseImpl(int doughQuantity, int noriQuantity, int sugarQuantity) {
		this.doughQuantity = doughQuantity;
		this.noriQuantity = noriQuantity;
		this.sugarQuantity = sugarQuantity;
	}

	public final int getDoughQuantity() {
		return this.doughQuantity;
	}

	public final void setDoughQuantity(int doughQuantity) {
		this.doughQuantity = doughQuantity;
	}

	public final int getNoriQuantity() {
		return this.noriQuantity;
	}

	public final void setNoriQuantity(int noriQuantity) {
		this.noriQuantity = noriQuantity;
	}

	public final int getSugarQuantity() {
		return this.sugarQuantity;
	}

	public final void setSugarQuantity(int sugarQuantity) {
		this.sugarQuantity = sugarQuantity;
	}
}
