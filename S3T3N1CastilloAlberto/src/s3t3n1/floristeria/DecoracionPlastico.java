package s3t3n1.floristeria;

import java.util.ArrayList;

import s3t3n1.obsever.Observer;

public class DecoracionPlastico extends Producto {
	private Tipo tipo;
	
	

	public DecoracionPlastico(String nombre, double precio, Integer stock) {
		super(nombre, precio, stock);
		
		new Observer(this);

	}	
	public Tipo getTipo() {
		return Tipo.PLASTICO;		
	}

}
