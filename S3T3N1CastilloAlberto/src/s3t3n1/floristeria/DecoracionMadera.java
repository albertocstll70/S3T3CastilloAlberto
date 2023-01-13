package s3t3n1.floristeria;

import java.io.Serializable;

import s3t3n1.obsever.Observer;

public class DecoracionMadera extends Producto implements Serializable{


	private static final long serialVersionUID = 1L;

	public DecoracionMadera(String nombre, double precio, Integer stock) {
		super(nombre, precio, stock);
		
		
		new Observer(this);

	}
	
	public Tipo getTipo() {
		return Tipo.MADERA;
		
	}

}
