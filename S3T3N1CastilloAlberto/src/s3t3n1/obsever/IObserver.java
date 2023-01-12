package s3t3n1.obsever;

import s3t3n1.floristeria.Producto;

public interface  IObserver {
	
	Producto producto = null;
	void actualizar();
	
	
}
