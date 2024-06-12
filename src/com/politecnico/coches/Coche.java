package com.politecnico.coches;

public class Coche extends Vehiculo{
	private int plazas, puertas, v_maletero;
	private String tipo;

	public Coche(String matricula, String modelo, String marca, String motor, int kms_recorridos, float precio_dia, boolean alquilado,int plazas, int puertas, int v_maletero, String tipo) {
		super(matricula, modelo, marca, motor, kms_recorridos, precio_dia, alquilado);
		this.plazas = plazas;
		this.puertas = puertas;
		this.v_maletero = v_maletero;
		this.tipo = tipo;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public int getV_maletero() {
		return v_maletero;
	}

	public void setV_maletero(int v_maletero) {
		this.v_maletero = v_maletero;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
