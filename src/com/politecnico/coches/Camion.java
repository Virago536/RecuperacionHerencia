package com.politecnico.coches;

public class Camion extends Vehiculo{
	int carga, longitud;

	public Camion(String matricula, String modelo, String marca, String motor, int kms_recorridos, float precio_dia, boolean alquilado,int carga, int longitud) {
		super(matricula, modelo, marca, motor, kms_recorridos, precio_dia, alquilado);
		this.carga = carga;
		this.longitud = longitud;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	
}

