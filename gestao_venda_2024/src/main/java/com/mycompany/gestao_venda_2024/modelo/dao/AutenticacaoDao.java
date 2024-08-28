/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda_2024.modelo.dao;

import com.mycompany.gestao_venda_2024.modelo.dominio.PERFIL;
import com.mycompany.gestao_venda_2024.modelo.dominio.Usuario;
import com.mycompany.gestao_venda_2024.modelo.exception.NegocioException;
import com.mycompany.gestao_venda_2024.view.modelo.LoginDto;
import javax.swing.JOptionPane;

/**
 *
 * @author daniellysilva
 */
public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;

    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }
    
    /**
     *
     * @param usuario
     * @return
     */
    public boolean temPermissao(Usuario usuario) {
        try {
            permissao(usuario);
            return true;
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissao", 0);
            System.out.println("ERROR: " + e.getMessage());
            return false;
        }
    }
    
    private void permissao(Usuario usuario) {
        if(!PERFIL.ADMIN.equals(usuario.getPerfil())) {
            throw new NegocioException("Sem permissao para realizar essa acao.");
        }
    }

    public Usuario login(LoginDto login) {
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsername(login.getUsername());
        
        if(usuario == null || !usuario.isEstado()) 
            return null;
       
        if(usuario.isEstado() && validaSenha(usuario.getSenha(), login.getSenha())) {
            usuarioDao.actualizarUltimoLogin(usuario);
            return usuario;
        }
        return null;
    }
    
//    private boolean validaSenha(String usuarioSenha, String loginSenha) {
//        return usuarioSenha.equals(loginSenha);
//    }
    
    private boolean validaSenha(String usuarioSenha, String loginSenha) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(loginSenha, usuarioSenha);
    }
    
}
