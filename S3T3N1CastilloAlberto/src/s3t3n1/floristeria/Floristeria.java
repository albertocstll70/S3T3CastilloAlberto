package s3t3n1.floristeria;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Floristeria implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	public static ArrayList<Producto> listProducto = new ArrayList<>();

	public Floristeria(String nombre) {
		this.nombre = nombre;

	}

	public void addProducto(Producto producto) {
		Floristeria.listProducto.add(producto);
	}

	public static double valorTotal() {
		double aux = 0;

		for (Producto i : Floristeria.listProducto) {
			aux = aux + i.getStock() * i.getPrecio();

		}

		return aux;

	}

	public void addLista(ArrayList<Producto> lista) {

		Floristeria.listProducto.addAll(lista);

	}

	public void recuperar(File archivo) {

		try {
			InputStream recuperarDatos = new FileInputStream(archivo);
			InputStream buffer = new BufferedInputStream(recuperarDatos);
			ObjectInput input = new ObjectInputStream(buffer);

			ArrayList<Producto> recuperado = new ArrayList<Producto>();
			recuperado.addAll((Collection<? extends Producto>) input.readObject());
			addLista(recuperado);
			input.close();
			buffer.close();

		} catch (IOException | ClassNotFoundException e) {
			e.getLocalizedMessage();

		}

	}

}
