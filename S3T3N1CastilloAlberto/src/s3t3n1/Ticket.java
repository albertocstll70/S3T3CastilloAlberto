package s3t3n1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

import s3t3n1.floristeria.Producto;

public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int cont = 1;
	private int id;
	
	public   Map<Producto, Integer> listProducto;
	public static ArrayList<Ticket> listCompras = new ArrayList<Ticket>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ticket(Map<Producto, Integer> listProducto) {
		this.listProducto = listProducto;
		this.id = cont;
		if (cont >= 1) {
			Ticket.cont = cont + 1;
					}		
		addListaCompras();
		
	}

	public double importeTotal() {

		double total = 0;
		for (Producto producto : listProducto.keySet()) {
			int cantidad = listProducto.get(producto);
			total = total + cantidad * producto.getPrecio();
		}

		return total;

	}

	public void printarTicket() {

		for (Producto producto : listProducto.keySet()) {

			System.out.println("-- " + listProducto.get(producto) + " " + producto.getNombre() + " " + producto.getPrecio());

		}
		System.out.println("Total --> " + importeTotal());

	}

	public void addListaCompras() {
		
		listCompras.add(this);
	}

	public  Map<Producto, Integer> getListProducto() {
		return listProducto;
	}

	
	
	
	

	
	
	
	

}
