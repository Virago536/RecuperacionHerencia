package com.politecnico.coches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Empresa implements GestorCliente{
	private String nombre;
	
	public ArrayList<Vehiculo> listaVehiculos;
	/*public ArrayList<Coche> listaCoches;
	public ArrayList<Furgoneta> listaFurgonetas;
	public ArrayList<Camion> listaCamiones;*/
	public Map <String, Cliente> mapaClientes = new HashMap<String, Cliente>();
	public ArrayList<Alquiler> listaAlquileres;
	
	
	public Empresa(String nombre) {
		this.nombre = nombre;
		listaVehiculos = new ArrayList<>();
		/*listaCoches = new ArrayList<>();
		listaFurgonetas = new ArrayList<>();
		listaCamiones = new ArrayList<>();*/
		mapaClientes = new HashMap<>();
		listaAlquileres = new ArrayList<>();
	}
	
	public boolean addFurgoneta(String matricula, String modelo, String marca, String motor, int kms_recorridos, float precio_dia, int carga, int asientos) {
		Furgoneta furgoNueva = new Furgoneta(matricula, modelo, marca, motor, kms_recorridos, precio_dia,false, carga, asientos);
		if(!this.estaFurgoneta(matricula)) {
			listaVehiculos.add(furgoNueva);
			return true;
		}
		else return false;
	} 
	
	public boolean estaFurgoneta(String matricula) {
		return (buscaFurgoneta(matricula)!=null);
	}
	
	
	public Vehiculo buscaFurgoneta(String matricula) {
		for(Vehiculo v: listaVehiculos) {
			if(v instanceof Furgoneta && v.getMatricula().equals(matricula)) {
				return v;
			}
		}
		return null;
	}
	
	public boolean removeVehiculo(String matricula) {
		for(Vehiculo cualquierFurgo: listaVehiculos) {
			if(cualquierFurgo.getMatricula().equals(matricula)) {
				listaVehiculos.remove(cualquierFurgo);
				return true;
			}
		}
		return false;
	}
	
	public Furgoneta[] listarLasFurgonetas() {
		ArrayList<Furgoneta> nuevaListaFurgos = new ArrayList<>();
		
		for(int i = 0; i<listaVehiculos.size(); i++) {
			if(listaVehiculos.get(i) instanceof Furgoneta)
				nuevaListaFurgos.add((Furgoneta)listaVehiculos.get(i));
		}
		return nuevaListaFurgos.toArray(new Furgoneta[0]);
		
	}
	
	public boolean addCoche(String matricula, String modelo, String marca, String motor, int kms_recorridos, float precio_dia, int plazas, int puertas, int v_maletero, String tipo) {
		Coche cocheNuevo = new Coche(matricula, modelo, marca, motor, kms_recorridos, precio_dia,false, plazas, puertas, v_maletero, tipo);
		if(!this.estaCoche(matricula)) {
			listaVehiculos.add(cocheNuevo);
			return true;
		}
		else return false;
	} 
	
	public boolean estaCoche(String matricula) {
		return (buscaCoche(matricula)!=null);
	}
	
	
	public Vehiculo buscaCoche(String matricula) {
		for(Vehiculo v: listaVehiculos) {
			if(v instanceof Coche && v.getMatricula().equals(matricula)) {
				return v;
			}
		}
		return null;
	}
	
	
	public Coche[] listarLosCoches() {
		ArrayList<Coche> nuevaListaCoches = new ArrayList<>();
		
		for(int i = 0; i<listaVehiculos.size(); i++) {
			if(listaVehiculos.get(i) instanceof Coche)
			nuevaListaCoches.add((Coche)listaVehiculos.get(i));
		}
		return nuevaListaCoches.toArray(new Coche[0]);
		
	}
	
	public boolean addCamion(String matricula, String modelo, String marca, String motor, int kms_recorridos, float precio_dia, int carga, int longitud) {
		Camion camionNuevo = new Camion(matricula, modelo, marca, motor, kms_recorridos, precio_dia,false, carga, longitud);
		if(!this.estaCamion(matricula)) {
			listaVehiculos.add(camionNuevo);
		return true;
		}
		else return false;
	} 
	
	public boolean estaCamion(String matricula) {
		return (buscaCoche(matricula)!=null);
	}
	
	
	public Vehiculo buscaCamion(String matricula) {
		for(Vehiculo v: listaVehiculos) {
			if(v instanceof Camion && v.getMatricula().equals(matricula)) {
				return v;
			}
		}
		return null;
	}
	
	public Camion[] listarLosCamiones() {
		ArrayList<Camion> nuevaListaCamiones = new ArrayList<>();
		
		for(int i = 0; i<listaVehiculos.size(); i++) {
			if(listaVehiculos.get(i) instanceof Camion)
			nuevaListaCamiones.add((Camion)listaVehiculos.get(i));
		}
		return nuevaListaCamiones.toArray(new Camion[0]);
		
	}

	
	public boolean estaVehiculo(String matricula) {
		return (buscaVehiculo(matricula)!=null);
	}
	
	
	public Vehiculo buscaVehiculo(String matricula) {
		for(Vehiculo v : listaVehiculos) {
			if(v.getMatricula().equals(matricula)) {
				return v;
			}
			
		}
		return null;
	}
	
	
	
	
	public boolean addCliente(Cliente c) {
		if(c != null && !mapaClientes.containsValue(c)) {
			mapaClientes.put(c.getDni(), c);
			return true;
		}
		else return false;
	}


	public boolean removeCliente(Cliente c) {
		if(c != null && mapaClientes.containsValue(c)) {
			mapaClientes.remove(c.getDni(), c);
			return true;
		}
		return false;
	}

	public boolean estaCliente(String dni) {
		if(mapaClientes.get(dni) != null) {
			return true;
		}
		else return false;
	}
	
	

	public Cliente buscarCliente(String dni) {
		if(dni!= null) {
			return mapaClientes.get(dni); 
		}
		else return null;
	}
	
	public Cliente[] listarTodoslosCliente() {
		return mapaClientes.values().toArray(new Cliente[0]);
	}
	
	
	

	public boolean crearAlquiler(Vehiculo v, Cliente c, int diasAlquilado) {
		if(estaVehiculo(v.getMatricula()) == true && estaCliente(c.getDni()) == true) {
			Alquiler al = new Alquiler(v, c, diasAlquilado);
			listaAlquileres.add(al);
			return true;
		}
		return false;
	}
	
	public float devolverVehiculo(String matricula, int kms_recorridos, int diasAlquilado) {
		if(estaVehiculo(matricula)) {
			for(Alquiler al : listaAlquileres) {
				if(al.getvAlquilado().getMatricula().equalsIgnoreCase(matricula)) {
					if(kms_recorridos > 500) {
						return (float) al.getvAlquilado().getPrecio_dia() * diasAlquilado + al.getvAlquilado().getPrecio_dia() * 20/100;
					}else {
						return (float) al.getvAlquilado().getPrecio_dia() * diasAlquilado;
					}
				}else {
					return 0.0f;
				}
			}
		}else {
			return 0.0f;
		}
		return 0.0f;
	}
	
	
	
}

