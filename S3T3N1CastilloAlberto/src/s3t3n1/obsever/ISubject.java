package s3t3n1.obsever;

public interface ISubject {
	void setStock(int stock);
	void addStock(Integer stockAdd);
	void restarStock(Integer stockRes);
	public void agregar(Observer producto);
	void notificar();
	
	

}
