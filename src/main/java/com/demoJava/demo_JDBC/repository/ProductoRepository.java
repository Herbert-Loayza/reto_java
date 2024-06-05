package com.demoJava.demo_JDBC.repository;

import com.demoJava.demo_JDBC.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface ProductoRepository extends JpaRepository <Producto, Integer> {

    List<Producto> findByFechaRegistro(Date fechaRegistro);
}
