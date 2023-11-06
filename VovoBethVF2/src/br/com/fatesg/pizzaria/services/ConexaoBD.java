package br.com.fatesg.pizzaria.services;

import java.sql.*;
public class ConexaoBD {
    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzaria", "root", "aluno");
    }
}
