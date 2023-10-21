package org.cibertec.edu.pe.repository;

import org.cibertec.edu.pe.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudent extends JpaRepository<Student, Integer> {

}
