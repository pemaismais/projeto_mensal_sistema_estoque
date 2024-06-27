/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.controller;

import projeto_mensal.src.utils.ResultadoValidacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projeto_mensal.src.dao.ProdutoDAO;
import projeto_mensal.src.model.DTO.ProdutoDTO;
import projeto_mensal.src.model.Produto;
import projeto_mensal.src.utils.Utils;

/**
 *
 * @author henri
 */
public class ProdutoController {

    private ProdutoDAO produtoDAO;
    private Utils util;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO();
        this.util = new Utils();
    }

    public ResultadoValidacao validar(ProdutoDTO produto) {
        ResultadoValidacao resultado = new ResultadoValidacao(); // Cria um objeto para armazenar o resultado da validação
        // Verifica se o nome está vazio
        if (produto.getNome().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("Nome do produto não pode estar vazio.");
            return resultado;
        }
        if (produto.getValor().contains(",")) {
            produto.setValor(produto.getValor().replace(",", "."));
        }
        // Verifica se o valor é um número válido
        try {
            float valorFloat = produto.precoParaFloat();
            if (valorFloat <= 0) {
                resultado.setValido(false);
                resultado.setMensagem("Valor do preço deve ser um número positivo.");
                return resultado;
            }
        } catch (NumberFormatException e) {
            resultado.setValido(false);
            resultado.setMensagem("Valor do preço deve ser um número válido.");
            return resultado;
        }
        // Verifica se o tipo foi selecionado
        if ("Selecione o tipo".equals(produto.getTipo())) {
            resultado.setValido(false);
            resultado.setMensagem("Selecione um tipo.");
            return resultado;
        }

        // Se passar por todas as verificações, define o resultado como válido e retorna
        resultado.setValido(true);
        return resultado;
    }

    public boolean cadastrar(ProdutoDTO produtoDTO) {
        try {
            ResultadoValidacao resultado = validar(produtoDTO);
            if (resultado.isValido()) {
                Produto produto = new Produto(
                        produtoDTO.getNome(),
                        produtoDTO.precoParaFloat(),
                        produtoDTO.getTipo()
                );
                produtoDAO.cadastrar(produto);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean remover(ArrayList<Integer> ids) {
        boolean sucesso = true;
        try {
            for (Integer id : ids) {
                produtoDAO.remover(id);
            }
        } catch (SQLException e) {
            sucesso = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sucesso;
    }

    public boolean alterar(ProdutoDTO produtoDTO) {
        try {
            ResultadoValidacao resultado = validar(produtoDTO);
            if (resultado.isValido()) {
                Produto produto = produtoDAO.selectById(
                        produtoDTO.getId());
                produto.setNome(produtoDTO.getNome());
                produto.setPreco(produtoDTO.precoParaFloat());
                produto.setTipo(produtoDTO.getTipo());

                produtoDAO.alterar(produto);
                    return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar ingrediente: " + resultado.getMensagem());
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public void carregarProdutosParaTabela(List<Produto> produtos, JTable table) {
        try {
            //  selecionando todos items da table na db
            if (produtos != null) {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                for (Produto produto : produtos) {
                    tableModel.addRow(new Object[]{
                        produto.getId(),
                        produto.getNome(),
                        produto.getPreco(),
                        produto.getTipo()
                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarTodosProdutosParaTabela(JTable table) {
        try {
            List<Produto> produtos = produtoDAO.selectAll();
            carregarProdutosParaTabela(produtos, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarProdutosPeloNomeParaTabela(String nome, JTable table) {
        try {
            List<Produto> produtos = produtoDAO.selectByNomeAll(nome);
            carregarProdutosParaTabela(produtos, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarProdutosPeloIdParaTabela(String id, JTable table) {
        try {
            List<Produto> produtos = produtoDAO.selectByIdAll(id);
            carregarProdutosParaTabela(produtos, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public ProdutoDTO getDTObyId(int id){
        try{
            Produto produto = produtoDAO.selectById(id);
            ProdutoDTO produtoDTO = new ProdutoDTO(produto.getId(),
                    produto.getNome(), 
                    String.valueOf( produto.getPreco() ), 
                    produto.getTipo());
            return produtoDTO;
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

}
