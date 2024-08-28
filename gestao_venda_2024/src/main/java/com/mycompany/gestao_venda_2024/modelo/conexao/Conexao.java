/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestao_venda_2024.modelo.conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author daniellysilva
 */
public interface Conexao {
    
    public Connection obterConexao() throws SQLException;
    public void fecharConexao()throws SQLException;
}
