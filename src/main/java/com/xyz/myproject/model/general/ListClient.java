package com.xyz.myproject.model.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.xyz.myproject.model.general.Client.CLIENT;

/**
 * La liste des clients. Utile pour être observé par les controllers.
 * @author Raoul
 *
 */
public class ListClient extends Observable implements Observer{
	
	public enum LISTE_CLIENT{MODIF}

	private ArrayList<Client> clients;

	public ListClient(List<Client> clients) {
		super();
		this.clients = new ArrayList<Client>();
		for (Client client : clients) {
			this.clients.add(client);
		}
	}
	
	public ListClient(){
		this(new ArrayList<Client>());
	}

	public void add(Client client) {
		client.addObserver(this);
		this.clients.add(client);
		this.setChanged();
		this.notifyObservers(LISTE_CLIENT.MODIF);
	}

	public void delete(Client client) {
		this.clients.remove(client);
		this.setChanged();
		this.notifyObservers(LISTE_CLIENT.MODIF);
	}
	
	public Client get(int index){
		return this.clients.get(index);
	}
	
	public int size(){
		return this.clients.size();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(arg==CLIENT.MODIF){
			this.setChanged();
			this.notifyObservers(LISTE_CLIENT.MODIF);
		}
	}

}
