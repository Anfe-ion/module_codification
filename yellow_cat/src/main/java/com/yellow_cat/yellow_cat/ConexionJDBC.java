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

    /**
     * @param args the command line arguments
     */
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
            
            statement.executeUpdate("INSERT INTO usuarios (nombres, apellidos, cedula, correo_electronico, contrasena) VALUES (Juan, Guaviare, 1555888999, juan@gmail.com, Juan123");
            rs = statement.executeQuery("SELECT * FROM usuarios");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+" : "+rs.getString("apellidos")+", "+rs.getString("nombres"));
            }while(rs.next());
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
