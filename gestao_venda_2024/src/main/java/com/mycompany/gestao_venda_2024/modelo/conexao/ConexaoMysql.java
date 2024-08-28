/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda_2024.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daniellysilva
 */
public class ConexaoMysql implements Conexao{

    private Connection connection;
    private final String URL = "jdbc:mysql://localhost/gestao_venda2024?useTimezone=true&serverTimezone=America/Sao_Paulo";
    private final String USER = "root";
    private final String PASSWORD = "dani1208";

    @Override
    public Connection obterConexao() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

    @Override
    public void fecharConexao() throws SQLException {
        if(connection != null)
            connection.close();
    }
    
}
