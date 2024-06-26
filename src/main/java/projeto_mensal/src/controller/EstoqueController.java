/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projeto_mensal.src.dao.EntradaDAO;
import projeto_mensal.src.dao.ProdutoDAO;
import projeto_mensal.src.dao.SaidaDAO;
import projeto_mensal.src.model.DTO.EstoqueDTO;
import projeto_mensal.src.model.ItemEntrada;
import projeto_mensal.src.model.ItemSaida;
import projeto_mensal.src.model.Produto;

/**
 *
 * @author henri
 */

public class EstoqueController {

    private EntradaDAO entradaDAO;
    private SaidaDAO saidaDAO;

    public EstoqueController() {
        this.entradaDAO = new EntradaDAO();
        this.saidaDAO = new SaidaDAO();
    }

    public float consultarSaldoEstoque(int produtoId) {
        List<ItemEntrada> entradas = entradaDAO.listarEntradasPorProduto(produtoId);
        List<ItemSaida> saidas = saidaDAO.listarSaidasPorProduto(produtoId);

        return calcularSaldoEstoque(entradas, saidas);
    }

    public float calcularSaldoEstoque(List<ItemEntrada> itemEntradas, List<ItemSaida> itemSaidas) {
        float totalEntradas = calcularTotalEntradas(itemEntradas);
        float totalSaidas = calcularTotalSaidas(itemSaidas);

        return totalEntradas - totalSaidas;
    }
    
    private float calcularTotalEntradas(List<ItemEntrada> itemEntradas) {
        return (float) itemEntradas.stream()
                           .mapToDouble(itemEntrada -> itemEntrada.getQuantidade())
                           .sum();
    }

    private float calcularTotalSaidas(List<ItemSaida> itemSaidas) {
     return (float) itemSaidas.stream()
                         .mapToDouble(itemSaida -> itemSaida.getQuantidade())
                         .sum();
    }
    
    public List<EstoqueDTO> pegarTodosEstoques(){
        try{
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.selectAll();
        List<EstoqueDTO> estoqueDTOs = new ArrayList<>();
        
            for (Produto produto : produtos) {                
               Float saldoEstoque = consultarSaldoEstoque(produto.getId());               
                EstoqueDTO estoqueDTO = new EstoqueDTO(produto.getId(), produto.getNome(), saldoEstoque);
                estoqueDTOs.add(estoqueDTO);
            }
        return estoqueDTOs;
        }catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    } 
        private void carregarEstoqueParaTabela(List<EstoqueDTO> estoqueDTOs, JTable table) {
        try {
            //  selecionando todos items da table na db
            if (estoqueDTOs != null) {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                for (EstoqueDTO estoqueDTO : estoqueDTOs) {
                    tableModel.addRow(new Object[]{
                        estoqueDTO.getId(),
                        estoqueDTO.getNome(),
                        estoqueDTO.getQuantidade(),
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
            public void carregarTodosProdutosParaTabela(JTable table) {
        try {

            List<EstoqueDTO> estoqueDTOs = pegarTodosEstoques();
        carregarEstoqueParaTabela(estoqueDTOs, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
