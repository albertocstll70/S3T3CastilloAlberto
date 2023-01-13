package s3t3n1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import s3t3n1.floristeria.Arbol;
import s3t3n1.floristeria.DecoracionMadera;
import s3t3n1.floristeria.DecoracionPlastico;
import s3t3n1.floristeria.Flor;
import s3t3n1.floristeria.Floristeria;
import s3t3n1.floristeria.Producto;

public class Main implements Serializable {

	private static final long serialVersionUID = 1L;
	private static ObjectOutput output;

	public static void main(String[] args) {

		File archivoFloristeria = new File(System.getProperty("user.dir") + File.separator + "datosFloristeria.txt");
		System.out.println(archivoFloristeria);

		if (archivoFloristeria.exists()) {
			Floristeria recuperarFloristeria = new Floristeria("Floristeria");
			recuperarFloristeria.recuperar(archivoFloristeria);

		}

		File archivoTicket = new File(System.getProperty("user.dir") + File.separator + "datosTicket.txt");

		if (archivoTicket.exists()) {
			Map<Producto, Integer> copiaT = new HashMap<Producto, Integer>();

			try {
				InputStream recuperarDatos = new FileInputStream(archivoTicket);
				InputStream buffer = new BufferedInputStream(recuperarDatos);
				ObjectInput input = new ObjectInputStream(buffer);

				ArrayList<Ticket> recuperado = new ArrayList<Ticket>();
				recuperado = (( ArrayList<Ticket>) input.readObject());			
				
				
				for (Ticket i : recuperado) {

					Ticket ticke = new Ticket(i.getListProducto());

				}
				
				input.close();
				buffer.close();
				
				

			} catch (IOException | ClassNotFoundException e) {
				e.getLocalizedMessage();

			}

		}

//		Producto arbol1 = new Arbol("Helecho", 0.25, 5.99, 50);
//		Producto arbol2 = new Arbol("Aloe vera", 0.30, 7.95, 35);
//		Producto arbol3 = new Arbol("Bromelia", 0.20, 10.50, 40);
//
//		Producto flor1 = new Flor("Anturio", "Rojo", 12.45, 75);
//		Producto flor2 = new Flor("Caléndula", "Amarillo", 15.25, 25);
//		Producto flor3 = new Flor("Gardenia", "Blanco", 9.55, 64);
//
//		Producto decoracion1 = new DecoracionMadera("Decoracion m", 8.50, 200);
//		Producto decoracion2 = new DecoracionPlastico("Decoracion p", 7.50, 200);
//
//		Floristeria floristeria = new Floristeria("La floristeria");
//
//		floristeria.addProducto(arbol1);
//		floristeria.addProducto(arbol2);
//		floristeria.addProducto(arbol3);
//
//		floristeria.addProducto(flor1);
//		floristeria.addProducto(flor2);
//		floristeria.addProducto(flor3);
//
//		floristeria.addProducto(decoracion1);
//		floristeria.addProducto(decoracion2);

		boolean salir = false;
		do {
			switch (menu()) {
			case 1:
				CrearFloristeria();

				break;
			case 2:
				addProducto();
				break;
			case 3:
				mostrarProductos();
				break;
			case 4:
				retirarProducto();
				break;
			case 5:
				mostrarStocks();
				break;
			case 6:
				mostrarValorTotal();
				break;
			case 7:
				crearTikets();
				break;
			case 8:
				mostrarListaCompraAnteriores();
				break;
			case 9:
				mostrarTotalRecaudacion();
				break;

			case 0:

				if (archivoFloristeria.exists()) {

					archivoFloristeria.delete();
				}
				ArrayList<Producto> copiaListProducto = new ArrayList<Producto>();

				copiaListProducto.addAll(Floristeria.listProducto);

				try {
					OutputStream escribeDatos = new FileOutputStream(
							System.getProperty("user.dir") + File.separator + "datosFloristeria.txt");
					OutputStream buffer = new BufferedOutputStream(escribeDatos);
					ObjectOutput output = new ObjectOutputStream(buffer);
					output.writeObject(copiaListProducto);

					output.close();
					buffer.close();

				} catch (Exception e) {

				}

				if (archivoTicket.exists()) {

					archivoTicket.delete();
				}
				ArrayList<Ticket> copiaTicket = new ArrayList<Ticket>();
				copiaTicket.addAll(Ticket.listCompras);
				try {
					OutputStream escribeTicket = new FileOutputStream(
							System.getProperty("user.dir") + File.separator + "datosTicket.txt");
					OutputStream buffer = new BufferedOutputStream(escribeTicket);
					ObjectOutput output = new ObjectOutputStream(buffer);
					output.writeObject(copiaTicket);
					output.close();
					buffer.close();

				} catch (Exception e) {

				}

				salir = true;
				break;

			default:

			}
		} while (!salir);

	}

	public static byte menu() {
		Scanner scan = new Scanner(System.in);
		byte opcion;
		final byte MINIMO = 0;
		final byte MAXIMO = 9;
		do {
			System.out.println("\n** Menu Principal**");
			System.out.println("1.-  Crear Floristería");
			System.out.println("2.-  Añadir Producto ");
			System.out.println("3.-  Mostrar Productos ");
			System.out.println("4.-  Retirar Producto");
			System.out.println("5.-  Mostrar Productos y stock ");
			System.out.println("6.-  Mostrar el valor total de las existecias ");
			System.out.println("7.-  Crear tickets");
			System.out.println("8.-  Mostras tickets anterior");
			System.out.println("9.-  Mostrar importe total ventas ");
			System.out.println("0.-  Salir\n");
			opcion = scan.nextByte();
			if (opcion < MINIMO || opcion > MAXIMO) {
				System.out.println("Escoje una opción valida");
			}

		} while (opcion < MINIMO || opcion > MAXIMO);

		return opcion;
	}

	public static void CrearFloristeria() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nombre de la floristeria");
		String nombre = scan.nextLine();
	}

	public static byte menu2() {
		Scanner scan = new Scanner(System.in);
		byte opcion;
		final byte MINIMO = 0;
		final byte MAXIMO = 4;

		do {
			System.out.println("**Productos **");
			System.out.println("1.- Arbol");
			System.out.println("2.- Flor");
			System.out.println("3.- Decoracion madera");
			System.out.println("4.- Decoracion plastico");
			System.out.println("0.- Finalizar");
			opcion = scan.nextByte();
			if (opcion < MINIMO || opcion > MAXIMO) {
				System.out.println("Escoje una opción valida");
			}

		} while (opcion < MINIMO || opcion > MAXIMO);

		return opcion;
	}

	public static void addProducto() {
		Scanner scan = new Scanner(System.in);

		boolean salir = false;
		do {
			String nombre;
			String color;
			int stock;
			double precio;
			double altura;

			switch (menu2()) {
			case 1:
				System.out.println("Introduce el nombre");
				nombre = scan.nextLine();
				System.out.println("Introduce la altura");
				altura = scan.nextDouble();
				System.out.println("Introduce el precio");
				precio = scan.nextDouble();
				System.out.println("Introduce el stock");
				stock = scan.nextInt();
				Producto arbol = new Arbol(nombre, altura, precio, stock);
				Floristeria.listProducto.add(arbol);
				scan.nextLine();
				break;
			case 2:
				System.out.println("Introduce el nombre");
				nombre = scan.nextLine();
				System.out.println("Introduce el color");
				color = scan.nextLine();
				System.out.println("Introduce el precio");
				precio = scan.nextDouble();
				System.out.println("Introduce el stock");
				stock = scan.nextInt();
				Producto flor = new Flor(nombre, color, precio, stock);
				Floristeria.listProducto.add(flor);
				scan.nextLine();
				break;
			case 3:
				System.out.println("Introduce el nombre");
				nombre = scan.nextLine();
				System.out.println("Introduce el precio");
				precio = scan.nextDouble();
				System.out.println("Introduce el stock");
				stock = scan.nextInt();
				Producto decoracionM = new DecoracionMadera(nombre, precio, stock);
				Floristeria.listProducto.add(decoracionM);
				scan.nextLine();
				break;
			case 4:
				System.out.println("Introduce el nombre");
				nombre = scan.nextLine();
				System.out.println("Introduce el precio");
				precio = scan.nextDouble();
				System.out.println("Introduce el stock");
				stock = scan.nextInt();
				Producto decoracionP = new DecoracionPlastico(nombre, precio, stock);
				Floristeria.listProducto.add(decoracionP);
				scan.nextLine();
				break;
			case 0:
				salir = true;
				break;

			}
		} while (!salir);

	}

	public static void mostrarProductos() {

		for (Producto i : Floristeria.listProducto) {

			System.out.println(i.getTipo() + "  " + i.getNombre() + " precio " + i.getPrecio());

		}

	}

	public static void retirarProducto() {

		Scanner scan = new Scanner(System.in);

		boolean salir = false;

		do {
			switch (menu2()) {

			case 1:

				int aux = 0;
				int posicionArbol;

				ArrayList<Arbol> listArbol = new ArrayList<Arbol>();

				clasificarProducto(listArbol, 1);

				System.out.println("*** Elije el producto");
				for (Arbol i : listArbol) {
					aux++;
					System.out.println(aux + ".- " + i.getNombre() + "Stock " + i.getStock());
				}

				int size = listArbol.size();
				int cantidadArbol;
				posicionArbol = scan.nextInt();
				posicionArbol = posicionArbol - 1;

				if (posicionArbol < size && posicionArbol >= 0) {
					System.out.println("¿Cantidad a retirar?");
					cantidadArbol = scan.nextInt();

					if (cantidadArbol <= listArbol.get(posicionArbol).getStock()) {

						listArbol.get(posicionArbol).restarStock(cantidadArbol);

					} else {
						System.err.println("La cantidad es superior al stock");

					}

				} else {
					System.err.println(" Introduzca una opción correcta");
				}

				break;
			case 2:
				int aux2 = 0;
				int posicionFlor;

				ArrayList<Flor> listFlor = new ArrayList<Flor>();

				clasificarProducto(listFlor, 2);

				System.out.println("*** Elije el producto");
				for (Flor i : listFlor) {
					aux2++;
					System.out.println(aux2 + ".- " + i.getNombre() + "Stock " + i.getStock());
				}

				int size2 = listFlor.size();
				int cantidadFlor;
				posicionFlor = scan.nextInt();
				posicionFlor = posicionFlor - 1;

				if (posicionFlor < size2 && posicionFlor >= 0) {
					System.out.println("¿Cantidad a retirar?");
					cantidadFlor = scan.nextInt();

					if (cantidadFlor <= listFlor.get(posicionFlor).getStock()) {

						listFlor.get(posicionFlor).restarStock(cantidadFlor);

					} else {
						System.err.println("La cantidad es superior al stock");

					}

				} else {
					System.err.println(" Introduzca una opcion correcta");
				}

				break;
			case 3:
				int aux3 = 0;
				int posicionDMadera;

				ArrayList<DecoracionMadera> listMadera = new ArrayList<DecoracionMadera>();

				clasificarProducto(listMadera, 3);

				System.out.println("*** Elije el producto");
				for (DecoracionMadera i : listMadera) {
					aux3++;
					System.out.println(aux3 + ".- " + i.getNombre() + "Stock " + i.getStock());
				}

				int size3 = listMadera.size();
				int cantidadDMadera;
				posicionDMadera = scan.nextInt();
				posicionDMadera = posicionDMadera - 1;

				if (posicionDMadera <= size3 && posicionDMadera >= 0) {
					System.out.println("¿Cantidad a retirar?");
					cantidadDMadera = scan.nextInt();

					if (cantidadDMadera <= listMadera.get(posicionDMadera).getStock()) {

						listMadera.get(posicionDMadera).restarStock(cantidadDMadera);

					} else {
						System.err.println("La cantidad es superior al stock");

					}

				} else {
					System.err.println(" Introduzca una opción correcta");
				}
				break;
			case 4:
				int aux4 = 0;
				int posicionDPlastico;

				ArrayList<DecoracionPlastico> listPlastico = new ArrayList<DecoracionPlastico>();

				clasificarProducto(listPlastico, 4);

				System.out.println("*** Elije el producto");
				for (DecoracionPlastico i : listPlastico) {
					aux4++;
					System.out.println(aux4 + ".- " + i.getNombre() + "Stock " + i.getStock());
				}

				int size4 = listPlastico.size();
				int cantidadDPlastico;
				posicionDPlastico = scan.nextInt();
				posicionDPlastico = posicionDPlastico - 1;

				if (posicionDPlastico < size4 && posicionDPlastico >= 0) {
					System.out.println("¿Cantidad a retirar?");
					cantidadDPlastico = scan.nextInt();

					if (cantidadDPlastico <= listPlastico.get(posicionDPlastico).getStock()) {

						listPlastico.get(posicionDPlastico).restarStock(cantidadDPlastico);

					} else {
						System.err.println("La cantidad es superior al stock");

					}

				} else {
					System.err.println(" Introduzca una opción correcta");
				}
				break;
			case 0:
				salir = true;
				break;

			default:
				System.err.println("escoje una opción valida");
			}

		} while (!salir);

	}

	public static void mostrarStocks() {
		for (Producto i : Floristeria.listProducto) {
			System.out.println(i);

		}

	}

	public static void mostrarValorTotal() {
		System.out.println("El valor total del Stock en tienda es: " + Floristeria.valorTotal() + "€");

	}

	public static void crearTikets() {

		Map<Producto, Integer> lista = new HashMap<Producto, Integer>();

		addCarrito(lista);
		Ticket ticket = new Ticket(lista);
		ticket.printarTicket();

		// actualizar stock productos

		for (Producto producto : lista.keySet()) {

			producto.restarStock(lista.get(producto));

		}

	}

	public static void addCarrito(Map<Producto, Integer> lista) {
		Scanner scan = new Scanner(System.in);

		boolean salir = false;

		do {
			switch (menu2()) {

			case 1:

				int aux = 0;
				int posicionArbol;

				ArrayList<Arbol> listArbol = new ArrayList<Arbol>();

				clasificarProducto(listArbol, 1);

				System.out.println("*** elije el arbol");
				for (Arbol i : listArbol) {
					aux++;
					System.out.println(
							aux + ".- " + i.getNombre() + " altura " + i.getAltura() + " precio" + i.getPrecio());
				}

				int size = listArbol.size();
				int cantidadArbol;
				posicionArbol = scan.nextInt();

				if (posicionArbol <= size && posicionArbol >= 0) {
					System.out.println("¿Cuantas unidades?");
					cantidadArbol = scan.nextInt();
					lista.put(listArbol.get(posicionArbol - 1), cantidadArbol);

				} else {
					System.err.println(" Introduzca una opción correcta");
				}

				break;
			case 2:
				int aux2 = 0;
				int posicionFlor;

				ArrayList<Flor> listFlor = new ArrayList<Flor>();

				clasificarProducto(listFlor, 2);

				System.out.println("*** elije la flor");
				for (Flor i : listFlor) {
					aux2++;
					System.out.println(
							aux2 + ".- " + i.getNombre() + " color " + i.getColor() + " precio" + i.getPrecio());
				}

				int size2 = listFlor.size();
				int cantidadFlor;
				posicionFlor = scan.nextInt();

				if (posicionFlor <= size2 && posicionFlor >= 0) {
					System.out.println("¿Cuantas unidades?");
					cantidadFlor = scan.nextInt();
					lista.put(listFlor.get(posicionFlor - 1), cantidadFlor);

				} else {
					System.err.println(" Introduzca una opcion correcta");
				}

				break;
			case 3:
				int aux3 = 0;
				int posicionDMadera;

				ArrayList<DecoracionMadera> listMadera = new ArrayList<DecoracionMadera>();

				clasificarProducto(listMadera, 3);

				System.out.println("*** Elije la decoración");
				for (DecoracionMadera i : listMadera) {
					aux3++;
					System.out.println(
							aux3 + ".- " + i.getNombre() + " Material " + i.getTipo() + " precio " + i.getPrecio());
				}

				int size3 = listMadera.size();
				int cantidadDMadera;
				posicionDMadera = scan.nextInt();

				if (posicionDMadera <= size3 && posicionDMadera >= 0) {
					System.out.println("¿Cuantas unidades?");
					cantidadDMadera = scan.nextInt();
					lista.put(listMadera.get(posicionDMadera - 1), cantidadDMadera);

				} else {
					System.err.println(" Introduzca una opción correcta");
				}
				break;
			case 4:
				int aux4 = 0;
				int posicionDPlastico;

				ArrayList<DecoracionPlastico> listPlastico = new ArrayList<DecoracionPlastico>();

				clasificarProducto(listPlastico, 4);

				System.out.println("*** Elije la decoración");
				for (DecoracionPlastico i : listPlastico) {
					aux4++;
					System.out.println(
							aux4 + ".- " + i.getNombre() + " Material  " + i.getTipo() + " Precio " + i.getPrecio());
				}

				int size4 = listPlastico.size();
				int cantidadDPlastico;
				posicionDPlastico = scan.nextInt();

				if (posicionDPlastico <= size4 && posicionDPlastico >= 0) {
					System.out.println("¿Cuantas unidades?");
					cantidadDPlastico = scan.nextInt();
					lista.put(listPlastico.get(posicionDPlastico - 1), cantidadDPlastico);

				} else {
					System.err.println(" Introduzca una opción correcta");
				}
				break;
			case 0:
				salir = true;
				break;

			default:
				System.err.println("escoje una opción valida");
			}

		} while (!salir);

	}

	public static void mostrarListaCompraAnteriores() {

		Scanner scan = new Scanner(System.in);

		int aux = 1;
		int posicion;
		DecimalFormat formato = new DecimalFormat("#.00");

		System.out.println("*** Elije el ticket");
		for (Ticket i : Ticket.listCompras) {

			System.out.println(
					aux + ".-  " + "númro de tike:" + i.getId() + " Importe: " + formato.format(i.importeTotal()));
			aux++;

		}

		posicion = scan.nextInt();
		posicion = posicion - 1;
		int size = Ticket.listCompras.size();

		if (posicion <= size && posicion >= 0) {

			Ticket.listCompras.get(posicion).printarTicket();

		} else {
			System.err.println(" Introduzca una opción correcta");
		}

	}

	public static void mostrarTotalRecaudacion() {
		double total = 0;
		for (Ticket i : Ticket.listCompras) {

			total = total + i.importeTotal();
		}

		System.out.printf("Total recaudado : %.2f ", total);

	}

	public static <T> void clasificarProducto(ArrayList<T> listP, int opcion) {

		if (opcion == 1) {

			for (Producto i : Floristeria.listProducto) {
				if (i instanceof Arbol) {
					listP.add((T) i);
				}
			}

		} else if (opcion == 2) {

			for (Producto i : Floristeria.listProducto) {
				if (i instanceof Flor) {
					listP.add((T) i);
				}
			}

		} else if (opcion == 3) {
			for (Producto i : Floristeria.listProducto) {
				if (i instanceof DecoracionMadera) {

					listP.add((T) i);
				}
			}

		} else if (opcion == 4) {
			for (Producto i : Floristeria.listProducto) {
				if (i instanceof DecoracionPlastico) {

					listP.add((T) i);
				}

			}

		}

	}
}
