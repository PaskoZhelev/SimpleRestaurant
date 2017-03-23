package implementations;


import java.util.ArrayList;
import java.util.List;
import interfaces.Client;
import interfaces.Table;



public class TableImpl<T> implements Table  {
	
	private List<Client> clients;

	private boolean occupied;
	
	public TableImpl() {
		this.clients = new ArrayList<Client>();
		this.occupied = false;
	}

	@Override
	public final boolean isOccupied() {
		return this.occupied;
	}

	@Override
	public final void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	@Override
	public final List<Client> getClients() {
		return this.clients;
	}

	@Override
	public final void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public void clientsFinishEating() {
	}

	@Override
	public void putNewClients() {
	}
	
}
