package s3t3n1.floristeria;

import java.io.Serializable;

import s3t3n1.obsever.Observer;

public class Flor extends Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String color;

	public Flor(String nombre, String color, double precio, Integer stock) {
		super(nombre, precio, stock);

		this.color = color;
		new Observer(this);
	}

	@Override
	public Tipo getTipo() {

		return Tipo.FLOR;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
