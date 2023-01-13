package s3t3n1.floristeria;

import java.io.Serializable;
import java.util.ArrayList;

import s3t3n1.obsever.Observer;

public class DecoracionPlastico extends Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Tipo tipo;
	
	

	public DecoracionPlastico(String nombre, double precio, Integer stock) {
		super(nombre, precio, stock);
		
		new Observer(this);

	}	
	public Tipo getTipo() {
		return Tipo.PLASTICO;		
	}

}
