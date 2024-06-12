package com.politecnico.coches;

public class Cliente {
	String nombre, apellidos, email, tfno, dni;
	int nTarjeta;
	public Cliente(String dni, String nombre, String apellidos, String email, String tfno, int nTarjeta) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.tfno = tfno;
		this.nTarjeta = nTarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTfno() {
		return tfno;
	}
	public void setTfno(String tfno) {
		this.tfno = tfno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getnTarjeta() {
		return nTarjeta;
	}
	public void setnTarjeta(int nTarjeta) {
		this.nTarjeta = nTarjeta;
	}
	
	
}
