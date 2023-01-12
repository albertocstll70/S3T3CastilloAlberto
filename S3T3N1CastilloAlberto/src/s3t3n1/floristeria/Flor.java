package s3t3n1.floristeria;

import s3t3n1.obsever.Observer;

public class Flor extends Producto {

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
