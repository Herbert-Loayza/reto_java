package com.demoJava.demo_JDBC.controller;

import com.demoJava.demo_JDBC.dao.ProductoDao;
import com.demoJava.demo_JDBC.entity.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {

    private final ProductoDao productoDao;

    public ProductoController(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    @PostMapping("/guardar")
    public List<Producto> GuardarYListarProductos(@RequestParam int id, @RequestParam String producto, @RequestParam Date fecha) throws SQLException {
        List<Producto>lstProductos= productoDao.insertarYListarProductos(id,producto, fecha);

        for (Producto e : lstProductos){
            System.out.println("Producto: " + e.getNombre());
        }
        return lstProductos;
    }
}
