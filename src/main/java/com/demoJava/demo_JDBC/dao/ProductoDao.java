package com.demoJava.demo_JDBC.dao;

import com.demoJava.demo_JDBC.database.ConectaDB;
import com.demoJava.demo_JDBC.entity.Producto;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ProductoDao {
    private Connection connection;

    CallableStatement cst = null;

    public List<Producto>insertarYListarProductos(int idProducto, String nombre, Date fecRegistro) throws SQLException {
        String query = "{CALL sp_insertAndListProducts(?, ?, ?, ?, ?)}";
        String s_msg = "";
        List<Producto> productos = new ArrayList<>();


        try{
            connection = ConectaDB.getConnection();
            cst = connection.prepareCall(query);

            cst.setInt(1, idProducto);
            cst.setString(2, nombre);
            cst.setDate(3, (java.sql.Date) fecRegistro);

            cst.registerOutParameter(4, Types.INTEGER);
            cst.registerOutParameter(5, Types.VARCHAR);
            boolean hasResult= cst.execute();

            int codRespuesta = cst.getInt(4);
            s_msg = cst.getString(5);

            System.out.println("Código de respuesta: " + codRespuesta);
            System.out.println("Mensaje de respuesta: " + s_msg);

            if (hasResult){
                try(ResultSet rs = cst.getResultSet()) {
                    while (rs.next()) {
                        Producto producto = new Producto();
                        producto.setId(rs.getInt("id"));
                        producto.setNombre(rs.getString("nombre"));
                        producto.setFechaRegistro(rs.getDate("fecha_registro"));
                        productos.add(producto);
                    }
                }
            }

        }catch (SQLDataException e){
            e.printStackTrace();
        }
     return productos;
    }
}
