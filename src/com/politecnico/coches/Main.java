package com.politecnico.coches;

import java.util.Scanner;

public class Main {
	public static void main(String Args[]) {
		Coche coche1 = new Coche("123", "Corsa", "Opel","diesel",0 , 32, false, 4, 4, 32, "deportivo" );
		Cliente cliente1 = new Cliente("537", "Alvaro", "Millan", "gmail", "tfno", 111);
		
		Scanner sc = new Scanner(System.in);
		int resp = 0;
		String atrResp;
		int respInt = 0;
		String respuesta;
		
		//Atributos generales
		String atr;
		String atrMatricula;
		String atrModelo;
		String atrMarca;
		String atrMotor = null;
		String atrConductor;
		int atrKms_recorridos, atrDias_alquilado;
		float atrPrecio_dia;
		String tipos = null;
		
		//Atributos de coche
		int atrPlazas;
		int atrPuertas;
		int atrV_maletero;
		String atrTipo = null;
		
		//Atributos de furgoneta
		int atrCarga;
		
		//Atributos de camion
		int atrLongitud;
		
		//Atributos cliente
		String atrNombre;
		String atrApellidos;
		String atrEmail;
		String atrTfno;
		String atrDni;
		int atrNtarjeta;
		float pago;
		int atrKms_cliente;
		
		//Atributos lista
		String xMotor;
		int nPlazas, xCarga, mLongitud;
		
		Coche listaCoches[];
		Furgoneta listaFurgonetas[];
		Camion listaCamiones[];
		Cliente listaClientes[];

		boolean loop = true;
		boolean loopMotor = true;
		boolean loopTipo = true;
		
		Empresa Opel = new Empresa("Opel");
		
		Opel.addCoche("123", "Corsa", "Opel","diesel",0 , 32, 4, 4, 1, "deportivo");
		Opel.addCoche("111", "Fiesta", "Ford", "híbrido", 0, 33, 4, 2, 2, "deportivo");
		Opel.addFurgoneta("321", "Bull", "Wolkswagen", "gasolina", 0, 48, 1000, 4);
		Opel.addFurgoneta("222", "Ulysse", "fiat", "híbrido", 0, 51, 500, 3);
		Opel.addCamion("456", "grande", "Camión", "diesel", 0, 61, 3000, 10);
		Opel.addCliente(cliente1);
		
		while(loop==true) {
			System.out.println("Bienvenido a la empresa de alquileres del politécnico:");
			System.out.println("¿Qué operación desea realizar?");
			System.out.println("1. Dar de alta un vehículo");
			System.out.println("2. Eliminar un vehículo");
			System.out.println("3. Alquilar un vehículo");
			System.out.println("4. Devolver un vehículo");
			System.out.println("5. Mostrar lista de los vehículos por parámetros");
			System.out.println("6. Mostrar lista de todos los vehículos ");
			System.out.println("7. Dar de alta un cliente");
			System.out.println("8. Eliminar un cliente");
			System.out.println("9. listar los clientes");
			System.out.println("10. Salir");
			
			
			try {
				resp = Integer.valueOf(sc.nextLine());
			}catch(NumberFormatException n) {
				System.out.println("opción no válida");		
				resp=0;
			}finally {
				if(resp>10 || resp<1) {
					System.out.println("opción no válida");
				}
			}
			
			switch(resp) {
			case 1:
				System.out.println("¿Qué tipo de vehículo quiere dar de alta?");
				System.out.println("1. Dar de alta un coche");
				System.out.println("2. Dar de alta una furgoneta");
				System.out.println("3. Dar de alta un camión");
				try {
					respInt = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Opción no válida");
					break;
				}finally {
					if(respInt<1 || respInt>3) {
						System.out.println("Opción no válida");
						break;
					}
				}
			
				
				if(respInt==1) {
					System.out.println("introduzca la matrícula: ");
					atrMatricula = sc.nextLine();
					
					if(Opel.buscaCoche(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					if(Opel.buscaFurgoneta(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					if(Opel.buscaCamion(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					
					System.out.println("introduzca el modelo: ");
					atrModelo = sc.nextLine();
					System.out.println("introduzca la marca: ");
					atrMarca = sc.nextLine();
					loopMotor=true;
					while(loopMotor==true) {
						System.out.println("introduzca el tipo de motor-> \n"
								+ "A. eléctrico \n"
								+ "B. híbrido enchufable. \n"
								+ "C. híbrido \n"
								+ "D. gasolina \n"
								+ "E. diesel \n ");
						atrMotor=sc.nextLine();
						switch(atrMotor) {
						case "A":
							atrMotor = "eléctrico";
							loopMotor=false;
							break;
						case "B":
							atrMotor = "híbrido enchufable";
							loopMotor=false;
							break;
						case "C":
							atrMotor = "híbrido";
							loopMotor=false;
							break;
						case "D":
							atrMotor = "gasolina";
							loopMotor=false;
							break;
						case "E":
							atrMotor = "diesel";
							loopMotor=false;
							break;
						}
						if (loopMotor!=false) {
							System.out.println("Opción no válida");
						}
						
					}
					System.out.println("introduzca su precio por día: ");
					try {
						atrPrecio_dia = Float.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					System.out.println("introduzca el número de plazas: ");
					try {
						atrPlazas = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de plazas no válido");
						break;
					}
					System.out.println("introduzca el número de puertas: ");	
					try {
						atrPuertas = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de puertas no válido");
						break;
					}
					System.out.println("introduzca el volumen del maletero: ");
					try {
						atrV_maletero = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("volumen no válido");
						break;
					}
					System.out.println("introduzca el tipo: ");
					loopTipo=true;
					while(loopTipo==true) {
						System.out.println("introduzca el tipo de Coche-> \n"
								+ "A. utilitario \n"
								+ "B. berlina. \n"
								+ "C. monovolumen \n"
								+ "D. suv \n");
						atrTipo = sc.nextLine();
						switch(atrTipo) {
						case "A":
							atrTipo = "utilitario";
							loopTipo=false;
							break;
						case "B":
							atrTipo = "berlina";
							loopTipo=false;
							break;
						case "C":
							atrTipo = "monovolumen";
							loopTipo=false;
							break;
						case "D":
							atrMotor = "suv";
							loopTipo=false;
							break;
						}
						if (loopTipo!=false) {
							System.out.println("Opción no válida");
						}
					}
					
					atrKms_recorridos = 0;
					
					if(Opel.addCoche(atrMatricula, atrModelo, atrMarca, atrMotor, atrKms_recorridos, atrPrecio_dia, atrPlazas, atrPuertas, atrV_maletero, atrTipo)== true) {
						System.out.println("El coche se agregó correctamente");
					}
					else {
						System.out.println("No se agregó el coche");
					}
					break;
				}
				else if(respInt==2) {
					System.out.println("introduzca la matrícula: ");
					atrMatricula = sc.nextLine();
					
					if(Opel.buscaCoche(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					if(Opel.buscaFurgoneta(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					if(Opel.buscaCamion(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					
					System.out.println("introduzca el modelo: ");
					atrModelo = sc.nextLine();
					System.out.println("introduzca la marca: ");
					atrMarca = sc.nextLine();
					loopMotor=true;
					while(loopMotor==true) {
						System.out.println("introduzca el tipo de motor-> \n"
								+ "A. eléctrico \n"
								+ "B. híbrido enchufable. \n"
								+ "C. híbrido \n"
								+ "D. gasolina \n"
								+ "E. diesel \n ");
						atrMotor=sc.nextLine();
						switch(atrMotor) {
						case "A":
							atrMotor = "eléctrico";
							loopMotor=false;
							break;
						case "B":
							atrMotor = "híbrido enchufable";
							loopMotor=false;
							break;
						case "C":
							atrMotor = "híbrido";
							loopMotor=false;
							break;
						case "D":
							atrMotor = "gasolina";
							loopMotor=false;
							break;
						case "E":
							atrMotor = "diesel";
							loopMotor=false;
							break;
						}
						if (loopMotor!=false) {
							System.out.println("Opción no válida");
						}
						
					}
					System.out.println("introduzca su precio por día: ");
					try {
						atrPrecio_dia = Float.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					System.out.println("introduzca su carga máxima: ");
					try {
						atrCarga = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					System.out.println("introduzca el número de asientos: ");
					try {
						atrPlazas = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					
					atrKms_recorridos = 0;
					
					if(Opel.addFurgoneta(atrMatricula, atrModelo, atrMarca, atrMotor, atrKms_recorridos, atrPrecio_dia, atrCarga, atrPlazas)== true) {
						System.out.println("La furgoneta se agregó correctamente");
					}
					else {
						System.out.println("No se agregó la furgoneta");
					}
					break;
				}
				else {
					System.out.println("introduzca la matrícula: ");
					atrMatricula = sc.nextLine();
					
					if(Opel.buscaCoche(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					if(Opel.buscaFurgoneta(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					if(Opel.buscaCamion(atrMatricula)!= null) {
						System.out.println("La matrícula ya existe");
						break;
					}
					
					System.out.println("introduzca el modelo: ");
					atrModelo = sc.nextLine();
					System.out.println("introduzca la marca: ");
					atrMarca = sc.nextLine();
					loopMotor=true;
					while(loopMotor==true) {
						System.out.println("introduzca el tipo de motor-> \n"
								+ "A. eléctrico \n"
								+ "B. híbrido enchufable. \n"
								+ "C. híbrido \n"
								+ "D. gasolina \n"
								+ "E. diesel \n ");
						atrMotor=sc.nextLine();
						switch(atrMotor) {
						case "A":
							atrMotor = "eléctrico";
							loopMotor=false;
							break;
						case "B":
							atrMotor = "híbrido enchufable";
							loopMotor=false;
							break;
						case "C":
							atrMotor = "híbrido";
							loopMotor=false;
							break;
						case "D":
							atrMotor = "gasolina";
							loopMotor=false;
							break;
						case "E":
							atrMotor = "diesel";
							loopMotor=false;
							break;
						}
						if (loopMotor!=false) {
							System.out.println("Opción no válida");
						}
						
					}
					
					System.out.println("introduzca su precio por día: ");
					try {
						atrPrecio_dia = Float.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					System.out.println("introduzca su carga máxima: ");
					try {
						atrCarga = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					System.out.println("introduzca la longitud: ");
					try {
						atrLongitud = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("precio no válido");
						break;
					}
					
					atrKms_recorridos = 0;
					
					if(Opel.addCamion(atrMatricula, atrModelo, atrMarca, atrMotor, atrKms_recorridos, atrPrecio_dia, atrCarga, atrLongitud)== true) {
						System.out.println("El camión se agregó correctamente");
					}
					else {
						System.out.println("No se agregó el camión");
					}
					break;
				}
			case 2:
				System.out.println("Introduzca la matrícula del vehículo que desea eliminar: ");
				atrMatricula = sc.nextLine();
				if(Opel.buscaCoche(atrMatricula)!=null) {
					Opel.removeVehiculo(atrMatricula);
					System.out.println("Coche eliminado correctamente");
				}
				else if(Opel.buscaFurgoneta(atrMatricula)!=null) {
					Opel.removeVehiculo(atrMatricula);
					System.out.println("Furgoneta eliminada correctamente");
				}
				else if(Opel.buscaCamion(atrMatricula)!=null) {
					Opel.removeVehiculo(atrMatricula);
					System.out.println("Camion eliminado correctamente");
				}
				else {
					System.out.println("No se pudo eliminar el vehículo");
				}
				break;
			case 3:
				System.out.println("Introduzca la matrícula del vehículo que desea alquilar: ");
				atrMatricula = sc.nextLine();
				if(Opel.buscaVehiculo(atrMatricula)!=null) {
					Vehiculo comprobacion = Opel.buscaVehiculo(atrMatricula);
					if(comprobacion.isAlquilado()==true) {
						System.out.println("El vehículo ya está alquilado");
						break;
					}
				}else {
					System.out.println("No hay ningún vehículo con esa matrícula");
					break;
				}
				System.out.println("Introduzca su DNI: ");
				atrDni = sc.nextLine();
				if(!Opel.mapaClientes.containsKey(atrDni)) {
					System.out.println("No existe ningún cliente con ese DNI");
					break;
				}
				System.out.println("Introduzca el número de días a alquilar: ");
				try {
					atrDias_alquilado = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("Número de días no válido");
					break;
				}
				
				if(Opel.buscarCliente(atrDni)!=null) {
					Cliente c = Opel.buscarCliente(atrDni);
					
					if(Opel.buscaVehiculo(atrMatricula)!=null) {
						Vehiculo co = Opel.buscaVehiculo(atrMatricula);
						if(Opel.crearAlquiler(co, c, atrDias_alquilado)==true) {
							co.setAlquilado(true);
							System.out.println("Vehiculo alquilado correctamente");
						}else {
							System.out.println("No se pudo alquilar el vehículo");
						}
					}
					else {
						System.out.println("No se pudo alquilar el vehículo");
					}
				}
				else {
					System.out.println("No se pudo alquilar el vehículo");
				}
				break;
			case 4:
				System.out.println("Introduzca la matrícula del vehículo que desea devolver: ");
				atrMatricula = sc.nextLine();
				if(Opel.buscaVehiculo(atrMatricula)!=null) {
					Vehiculo comprobacion = Opel.buscaVehiculo(atrMatricula);
					if(comprobacion.isAlquilado()==false) {
						System.out.println("El vehículo no está alquilado");
						break;
					}
				}else {
					System.out.println("No hay ningún vehículo con esa matrícula");
					break;
				}
				
				System.out.println("Introduzca los kilómetros recorridos: ");
				try {
					atrKms_recorridos = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("kilómetros no válido");
					break;
				}
				
				System.out.println("Introduzca los días que alquiló el coche");
				try {
					atrDias_alquilado = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("kilómetros no válido");
					break;
				}
				
				
				Opel.devolverVehiculo(atrMatricula, atrKms_recorridos, atrDias_alquilado);
				Vehiculo ve = Opel.buscaVehiculo(atrMatricula);
				ve.setAlquilado(false);
				System.out.println("Coche devuelto");
				System.out.println("Precio a pagar: "+ Opel.devolverVehiculo(atrMatricula, atrKms_recorridos, atrDias_alquilado));
				break;
			case 5: 
				System.out.println("Introduzca que tipo de vehículo desea visualizar: \n"
						+ "A. Coches \n"
						+ "B. Furgonetas \n"
						+ "C. Camiones \n");
				tipos = sc.nextLine();
				if(tipos.compareTo("A")==0) {
					System.out.println("Introduzca el número mínimo de plazas: ");
					try {
						nPlazas = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de plazas no válido");
						break;
					}
					System.out.println("introduzca el tipo de motor que desea: \n"
							+ "A. eléctrico \n"
							+ "B. híbrido enchufable. \n"
							+ "C. híbrido \n"
							+ "D. gasolina \n"
							+ "E. diesel \n ");
					xMotor = sc.nextLine();
					switch(xMotor) {
					case "A":
						xMotor = "eléctrico";
						break;
					case "B":
						xMotor = "híbrido enchufable";
						break;
					case "C":
						xMotor = "híbrido";
						break;
					case "D":
						xMotor = "gasolina";
						break;
					case "E":
						xMotor = "diesel";
						break;
					}
					
					/*if(xMotor!="eléctrico" || xMotor!="híbrido enchufable" || xMotor!="gasolina" || xMotor!="diesel") {
						System.out.println("Opción no válida");
						break;
					}*/
					
					System.out.println("Coches: ");
					
					listaCoches = Opel.listarLosCoches();
					
					for(Coche cualquiera: listaCoches) {
						if(cualquiera.getPlazas()>= nPlazas && cualquiera.getMotor().compareTo(xMotor)==0) {
							System.out.println("// "+cualquiera.getMarca()+" "+cualquiera.getModelo()+" "+cualquiera.getMatricula()+": ");
							System.out.println("- número de plazas: "+cualquiera.getPlazas());
							System.out.println("- tipo de motor: "+cualquiera.getMotor());
							System.out.println("- volumen del maletero: "+ cualquiera.getV_maletero()+ " m3");
							System.out.println("- número de puertas: "+ cualquiera.getPuertas());
							System.out.println("- tipo: "+cualquiera.getTipo());
							System.out.println("- Precio por día: "+ cualquiera.getPrecio_dia()+ "€");
						}
					}

				}else if(tipos.compareTo("B")==0) {
					System.out.println("Introduzca el número mínimo de plazas: ");
					try {
						nPlazas = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de plazas no válido");
						break;
					}
					System.out.println("Introduzca la carga mínima: ");
					try {
						xCarga = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de plazas no válido");
						break;
					}
					
					System.out.println("Furgones: ");
					
					listaFurgonetas = Opel.listarLasFurgonetas();
					
					for(Furgoneta cualquiera: listaFurgonetas) {
						if(cualquiera.getCarga()>= xCarga && cualquiera.getAsientos()>= nPlazas) {
							System.out.println("// "+cualquiera.getMarca()+" "+cualquiera.getModelo()+" "+cualquiera.getMatricula()+": ");
							System.out.println("- Carga máxima: "+cualquiera.getCarga()+ "Kg");
							System.out.println("- número de asientos: "+cualquiera.getAsientos());
							System.out.println("- tipo de motor: "+cualquiera.getMotor());
							System.out.println("- Precio por día: "+ cualquiera.getPrecio_dia()+ "€");
						}
					}
					
				}else if(tipos.compareTo("C")==0) {
					System.out.println("Introduzca la carga mínima: ");
					try {
						xCarga = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de plazas no válido");
						break;
					}
					System.out.println("Introduzca la longitud máxima: ");
					try {
						mLongitud = Integer.valueOf(sc.nextLine());
					}catch(NumberFormatException n) {
						System.out.println("número de plazas no válido");
						break;
					}
					
					System.out.println("Camiones: ");
					
					listaCamiones = Opel.listarLosCamiones();
					
					for(Camion cualquiera: listaCamiones) {
						if(cualquiera.getCarga()>= xCarga && cualquiera.getLongitud() <= mLongitud) {
							System.out.println("// "+cualquiera.getMarca()+" "+cualquiera.getModelo()+" "+cualquiera.getMatricula()+": ");
							System.out.println("- Carga máxima: "+cualquiera.getCarga()+ "Kg");
							System.out.println("- tipo de motor: "+cualquiera.getMotor());
							System.out.println("- Longitud: "+cualquiera.getLongitud()+ "m");
							System.out.println("- Precio por día: "+ cualquiera.getPrecio_dia()+ "€");
						}
					}
					
				}else {
					System.out.println("Opción no válida");				
				}
				
				
				
				
				
				
				break;
			case 6:
				listaCoches = Opel.listarLosCoches();
				listaFurgonetas = Opel.listarLasFurgonetas();
				listaCamiones = Opel.listarLosCamiones();
				
				for(Coche cualquiera: listaCoches) {
					System.out.println("// "+cualquiera.getMarca()+" "+cualquiera.getModelo()+" "+cualquiera.getMatricula()+": ");
					System.out.println("- número de plazas: "+cualquiera.getPlazas());
					System.out.println("- tipo de motor: "+cualquiera.getMotor());
					System.out.println("- volumen del maletero: "+ cualquiera.getV_maletero()+ " m3");
					System.out.println("- número de puertas: "+ cualquiera.getPuertas());
					System.out.println("- tipo: "+cualquiera.getTipo());
					System.out.println("- Precio por día: "+ cualquiera.getPrecio_dia()+ "€");
				}
				
				for(Furgoneta cualquiera: listaFurgonetas) {
					System.out.println("// "+cualquiera.getMarca()+" "+cualquiera.getModelo()+" "+cualquiera.getMatricula()+": ");
					System.out.println("- Carga máxima: "+cualquiera.getCarga()+ "Kg");
					System.out.println("- número de asientos: "+cualquiera.getAsientos());
					System.out.println("- tipo de motor: "+cualquiera.getMotor());
					System.out.println("- Precio por día: "+ cualquiera.getPrecio_dia()+ "€");
				}
				
				for(Camion cualquiera: listaCamiones) {
					System.out.println("// "+cualquiera.getMarca()+" "+cualquiera.getModelo()+" "+cualquiera.getMatricula()+": ");
					System.out.println("- Carga máxima: "+cualquiera.getCarga()+ "Kg");
					System.out.println("- tipo de motor: "+cualquiera.getMotor());
					System.out.println("- Longitud: "+cualquiera.getLongitud()+ "m");
					System.out.println("- Precio por día: "+ cualquiera.getPrecio_dia()+ "€");
				}
				break;
			case 7:
				System.out.println("Introduzca su DNI: ");
				atrDni = sc.nextLine();
				
				if(Opel.buscarCliente(atrDni)!=null) {
					System.out.println("Ya existe un cliente con ese DNI");
					break;
				}	
				System.out.println("Introduzca su nombre: ");
				atrNombre = sc.nextLine();
				System.out.println("Introduzca sus apellidos: ");
				atrApellidos = sc.nextLine();
				System.out.println("Introduzca su email: ");
				atrEmail = sc.nextLine();
				System.out.println("Introduzca su teléfono: ");
				atrTfno = sc.nextLine();
				
				
				System.out.println("Introduzca su número de tarjeta: ");
				try {
					atrNtarjeta = Integer.valueOf(sc.nextLine());
				}catch(NumberFormatException n) {
					System.out.println("número de tarjeta no válido");
					break;
				}
				
				Cliente c = new Cliente(atrDni, atrNombre, atrApellidos, atrEmail, atrTfno, atrNtarjeta);
				
				if(Opel.addCliente(c)== true) {
					System.out.println("El cliente se creó correctamente");
				}
				else {
					System.out.println("No se creó el cliente");
				}
				Opel.addCliente(c);
				break;
			case 8:	
				System.out.println("Introduzca el DNI del cliente que quiere eliminar");
				atrDni = sc.nextLine();
				if(Opel.buscarCliente(atrDni)!=null) {
					c = Opel.buscarCliente(atrDni);
					Opel.removeCliente(c);
					System.out.println("El cliente se eliminó correctamente");
				}else {
					System.out.println("No se pudo eliminar el cliente");
				}
				break;
			case 9:
				listaClientes = Opel.listarTodoslosCliente();
				
				for(Cliente unCliente :listaClientes) {
					System.out.println("Clientes:");
					System.out.println("//"+unCliente.getNombre()+" "+unCliente.getApellidos()+": ");
					System.out.println("- DNI: "+unCliente.getDni());
					System.out.println("- Email: "+unCliente.getEmail());
					System.out.println("- Teléfono: "+unCliente.getTfno());
					System.out.println("- Número de tarjeta: "+unCliente.getnTarjeta());
				}
				break;
			case 10:
				System.out.println("Adios");
				loop = false;
				
			}
		}
		
			
	}
		
}
