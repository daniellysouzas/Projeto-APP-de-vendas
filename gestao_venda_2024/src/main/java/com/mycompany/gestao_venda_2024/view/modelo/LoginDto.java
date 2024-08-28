/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda_2024.view.modelo;

/**
 *
 * @author daniellysilva
 */
public class LoginDto {
    
    private String username;
    private String senha;

    public LoginDto() {
    }

    public LoginDto(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }
   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
