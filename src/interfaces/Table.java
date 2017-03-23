package interfaces;

import java.util.List;

public interface Table {
	
	public List<Client> getClients();

	public void setClients(List<Client> clients);
	
	public boolean isOccupied();
	
	public void setOccupied(boolean occupied);
	
	public void clientsFinishEating();
	
	public void putNewClients();
}
