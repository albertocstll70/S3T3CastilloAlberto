package s3t3n1.floristeria;

import java.io.Serializable;
import java.util.ArrayList;

import s3t3n1.obsever.Observer;

public class Floristeria implements Serializable{
	
	
    private Observer observer;
	private String nombre;
	public static ArrayList<Producto> listProducto = new ArrayList<>();
	
	public Floristeria(String nombre) {
		this.nombre = nombre;
		
	}
	
	
	public void addProducto(Producto producto) {		
		this.listProducto.add(producto);	
	}
	
	public static double valorTotal() {
		double aux = 0;

		for (Producto i : Floristeria.listProducto) {
			aux = aux + i.getStock() * i.getPrecio();

		}
		
		return aux;
		
	}
	
	
	
	

}
