/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestao_venda_2024.modelo.util;

import com.mycompany.gestao_venda_2024.modelo.dominio.Produto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniellysilva
 */
public class ProdutoTableModel extends AbstractTableModel{
    
    private List<Produto> produtos;
    private final String [] colunas = {"ID", "NOME", "PRECO", "QUANTIDADE", "CATEGORIA", "DATA", "CRIADO POR"};

    public ProdutoTableModel(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public int getRowCount() {
        return produtos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Produto produto = produtos.get(linha);
        
        switch(coluna) {
            case 0: return produto.getId();
            case 1: return produto.getNome();
            case 2: return produto.getPreco();
            case 3: return produto.getQuantidade();
            case 4: return produto.getCategoria().getNome();
            case 5: return produto.getDataHoraCriaco();
            case 6: return produto.getUsuario().getNome();
            default: return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    
}
