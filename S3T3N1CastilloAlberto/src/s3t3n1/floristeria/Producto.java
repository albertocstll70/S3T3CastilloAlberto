package s3t3n1.floristeria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import s3t3n1.obsever.ISubject;
import s3t3n1.obsever.Observer;

public abstract class Producto implements ISubject, Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private double precio;
	protected int stock = 0;
	protected Observer floristeria;
	protected ArrayList<Observer> listObserver = new ArrayList<>();

	public Producto(String nombre, double precio, Integer stock) {
		this.precio = precio;
		this.stock = stock;
		this.nombre = nombre;
	
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setStock(int stock) {
		this.stock = stock;
		
	}

	public int getStock() {
		return stock;
	}

	public Observer getFloristeria() {
		return floristeria;
	}

	public ArrayList<Observer> getListObserver() {
		return listObserver;
	}

	@Override
	public String toString() {
		return "Tipo: " + getTipo() + " " + "nombre: " + nombre + ", precio: " + precio + ", stock: " + stock;
	}

	@Override
	public void addStock(Integer stockAdd) {
		setStock(this.stock + stockAdd);
		

	}

	@Override

	public void restarStock(Integer stockRes) {
		setStock(this.stock - stockRes);
		
	}

	@Override
	public void agregar(Observer floristeria) {
		this.listObserver.add(floristeria);
	}

	@Override
	public void notificar() {
		floristeria.actualizar();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public abstract Tipo getTipo();

}
