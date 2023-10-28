package org.cibertec.edu.pe.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProduct;
	private String description;
	private Date registerDate;
	private double unitPrice;
	private int stock;
	private int minStock;
	private char status;
	/*
	 * Para el estado, hemos decidido utilizar la siguiente convencion
	 * 'A': available
	 * 'U': unavailable
	 */
}
