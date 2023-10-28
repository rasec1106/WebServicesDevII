package org.cibertec.edu.pe.repository;

import org.cibertec.edu.pe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduct extends JpaRepository<Product, Integer>{}
