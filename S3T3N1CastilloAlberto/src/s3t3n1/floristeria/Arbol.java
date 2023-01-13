package s3t3n1.floristeria;

import java.io.Serializable;

import s3t3n1.obsever.Observer;

public class Arbol extends Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private double altura;

	public Arbol(String nombre, double altura, double precio, Integer stock) {
		super(nombre, precio, stock);
		this.altura = altura;
		new Observer(this);

	}

	@Override
	public Tipo getTipo() {

		return Tipo.ARBOL;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	

}
