package implementations;

import java.util.List;

import interfaces.Client;

public class ClientImpl implements Client{
	
	private List<String> orders;
	
	
	public ClientImpl(List<String> orders){
		this.orders = orders;
	}

	@Override
	public final List<String> getOrders() {
		return this.orders;
	}

	@Override
	public final void setOrders(List<String> orders) {
		this.orders = orders;
	}

}
