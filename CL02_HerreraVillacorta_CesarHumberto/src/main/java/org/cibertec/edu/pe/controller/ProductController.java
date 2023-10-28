package org.cibertec.edu.pe.controller;

import java.util.List;
import org.cibertec.edu.pe.model.Product;
import org.cibertec.edu.pe.repository.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProduct product;
	@GetMapping
	public List<Product> list(){
		return (List<Product>)product.findAll();
	}
	@GetMapping(value="/{id}")
	public Product search(@PathVariable("id") int id){
		return product.findById(id).get();
	}
	@PostMapping
	public void insert(@RequestBody Product p) {
		product.save(p);
	}
	@PutMapping
	public void update(@RequestBody Product p) {
		product.save(p);
	}
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") int id) {
		product.deleteById(id);
	}
}
