package com.politecnico.coches;

public interface GestorCliente {
	
	public boolean addCliente(Cliente c);
	
	public boolean removeCliente(Cliente c);
	
	public Cliente buscarCliente(String dni);
}
