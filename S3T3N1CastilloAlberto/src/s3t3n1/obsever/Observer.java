package s3t3n1.obsever;

import java.util.ArrayList;

import s3t3n1.floristeria.Floristeria;
import s3t3n1.floristeria.Producto;

public class Observer implements IObserver {

	public Observer(Producto producto) {
		super();
		producto.agregar(this);
	}

	@Override
	public void actualizar() {
		for (Producto i : Floristeria.listProducto) {
			if (i.equals(producto)) {
				i.setStock(producto.getStock());

			}

		}

	}

}
