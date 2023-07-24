/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.yellow_cat.yellow_cat;

/**
 *
 * @author Andrés
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionJDBC {

    public static void main(String[] args) {
        
        // Configuración de la conexión JDBC        
        String usuario  = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/SQL_db";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;       
        
        
        try {
            // TODO code application logic here
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            
            // Inserción de un nuevo usuario
            String insertQuery = "INSERT INTO usuarios (nombres, apellidos, cedula, correo_electronico, contrasena) VALUES "
                    + "('Juan', 'Guaviare', '1555888999', 'juan@gmail.com', 'Juan123')";
            int filasInsertadas = statement.executeUpdate(insertQuery);
            
            if (filasInsertadas > 0) {
                System.out.println("Usuario insertado correctamente.");
            } else {
                System.out.println("Error al insertar el usuario.");
            }
            
            // Consulta de usuarios
            rs = statement.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                
                System.out.println(id + " : " + apellidos + ", " + nombres);
            }
            
            // Actualización de nombre de usuario
            String updateQuery = "UPDATE usuarios SET nombres = 'Marcos', apellidos = 'Rosas' WHERE nombres = 'Marco' AND apellidos = 'Rossi'";
            int filasActualizadas = statement.executeUpdate(updateQuery);
            
            if (filasActualizadas > 0) {
                System.out.println("Nombre actualizado correctamente.");
            } else {
                System.out.println("No se encontró el usuario para actualizar.");
            }
            
            // Eliminación de usuario
            String deleteQuery = "DELETE FROM usuarios WHERE nombres = 'Elisa' AND apellidos = 'Rinaldi'";
            int filasEliminadas = statement.executeUpdate(deleteQuery);
            
            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró el usuario para eliminar.");
            }
            
            rs.close();
            statement.close();
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
