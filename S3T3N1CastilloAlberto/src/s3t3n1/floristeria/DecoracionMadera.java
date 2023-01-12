package s3t3n1.floristeria;

import s3t3n1.obsever.Observer;

public class DecoracionMadera extends Producto {


	public DecoracionMadera(String nombre, double precio, Integer stock) {
		super(nombre, precio, stock);
		
		
		new Observer(this);

	}
	
	public Tipo getTipo() {
		return Tipo.MADERA;
		
	}

}
