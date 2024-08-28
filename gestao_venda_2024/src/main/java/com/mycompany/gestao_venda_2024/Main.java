/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda_2024;

import com.mycompany.gestao_venda_2024.modelo.conexao.Conexao;
import com.mycompany.gestao_venda_2024.modelo.conexao.ConexaoMysql;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author daniellysilva
 */
public class Main {
    
    public static void main (String[] args) throws SQLException {
        
        String sql = "Select * from categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()){
            System.out.println(result.getString("nome"));
        }
    }
}
