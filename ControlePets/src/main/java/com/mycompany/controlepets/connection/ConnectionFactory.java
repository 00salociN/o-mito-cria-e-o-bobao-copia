/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controlepets.connection;
/**
 *
 * @author Etec
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory {
private static final String URL = "jdbc:mysql://localhost:3306/bd_controle_pets";
private static final String USER = "root"; // Altere se o seu usuário for diferente
private static final String PASSWORD = ""; // Altere para a sua senha do MySQL
public static Connection getConnection() {
try {
// Tenta estabelecer a conexão
return DriverManager.getConnection(URL, USER, PASSWORD);
} catch (SQLException e) {
// Em caso de falha, lança uma exceção não verificada
throw new RuntimeException("Erro ao conectar ao banco de dados", e);
}
}

    
}
