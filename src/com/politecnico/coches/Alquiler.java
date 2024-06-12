package com.politecnico.coches;

public class Alquiler {
	private Vehiculo vAlquilado;
	private Cliente cAlquilador;
	private int diasAlquilado;
	
	public Alquiler(Vehiculo vAlquilado, Cliente cAlquilador, int diasAlquilado) {
		this.vAlquilado = vAlquilado;
		this.cAlquilador = cAlquilador;
		this.diasAlquilado = diasAlquilado;
	}

	public Vehiculo getvAlquilado() {
		return vAlquilado;
	}

	public void setvAlquilado(Vehiculo vAlquilado) {
		this.vAlquilado = vAlquilado;
	}

	public Cliente getcAlquilador() {
		return cAlquilador;
	}

	public void setcAlquilador(Cliente cAlquilador) {
		this.cAlquilador = cAlquilador;
	}

	public int getDiasAlquilado() {
		return diasAlquilado;
	}

	public void setDiasAlquilado(int diasAlquilado) {
		this.diasAlquilado = diasAlquilado;
	}
	
	
	

}
