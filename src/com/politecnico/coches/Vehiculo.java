package com.politecnico.coches;

public class Vehiculo {
	String matricula, modelo, marca, motor;
	int kms_recorridos; 
	float precio_dia;
	boolean alquilado = false;
	
	public Vehiculo(String matricula, String modelo, String marca, String motor, int kms_recorridos, float precio_dia, boolean alquilado) {
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.motor = motor;
		this.kms_recorridos = kms_recorridos;
		this.precio_dia = precio_dia;
		this.alquilado = false;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public int getKms_recorridos() {
		return kms_recorridos;
	}

	public void setKms_recorridos(int kms_recorridos) {
		this.kms_recorridos = kms_recorridos;
	}

	public float getPrecio_dia() {
		return precio_dia;
	}

	public void setPrecio_dia(int precio_dia) {
		this.precio_dia = precio_dia;
	}
	
	public boolean isAlquilado() {
		return alquilado;
	}
	
	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	

}
