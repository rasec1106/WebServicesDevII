package model;

import java.io.Serializable;
import org.json.simple.JSONObject;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idProducto;
    private String descripcion;
    private int stock;
    private double precio;
    private String estado;
    
    public JSONObject convertToJson() {    	
    	JSONObject json = new JSONObject();
    	json.put("idProducto", idProducto);
    	json.put("descripcion", descripcion);
    	json.put("stock", stock);
    	json.put("precio", precio);
    	json.put("estado", estado);
    	return json;
    }
    
	public Product() {
		super();
	}

	public Product(int idProducto, String descripcion, int stock, double precio, String estado) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.estado = estado;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String isEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
    
}
