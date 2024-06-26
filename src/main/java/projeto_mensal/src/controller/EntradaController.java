/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.controller;

import projeto_mensal.src.utils.ResultadoValidacao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projeto_mensal.src.dao.EntradaDAO;
import projeto_mensal.src.dao.FornecedorDAO;
import projeto_mensal.src.dao.ProdutoDAO;
import projeto_mensal.src.model.Entrada;
import projeto_mensal.src.model.Fornecedor;
import projeto_mensal.src.model.ItemEntrada;
import projeto_mensal.src.model.Produto;
import projeto_mensal.src.utils.Utils;

/**
 *
 * @author henri
 */
public class EntradaController {

    private EntradaDAO entradaDAO;

    public EntradaController() {
        entradaDAO = new EntradaDAO();
    }

    public ResultadoValidacao validar(String quantidadeStr, String IdFornecedor, String IdProduto) {
        ResultadoValidacao resultado = new ResultadoValidacao(); // Cria um objeto para armazenar o resultado da validação

        if (quantidadeStr.contains(",")) {
            quantidadeStr = quantidadeStr.replace(",", ".");
        }

        // Verifica se o valor é um número válido
        try {
            float quantidade = Float.parseFloat(quantidadeStr);
            if (quantidade <= 0) {
                resultado.setValido(false);
                resultado.setMensagem("Valor da quantidade deve ser um número positivo.");
                return resultado;
            }
        } catch (NumberFormatException e) {
            resultado.setValido(false);
            resultado.setMensagem("Valor da quantidade deve ser um número válido.");
            return resultado;
        }
        try {
            int id = Integer.parseInt(IdProduto);
            ProdutoDAO produtoDAO = new ProdutoDAO();
            Produto produto = produtoDAO.selectById(id);
            if (produto == null) {
                resultado.setValido(false);
                resultado.setMensagem("Produto não encontrado.");
                return resultado;
            }
        } catch (NumberFormatException e) {
            resultado.setValido(false);
            resultado.setMensagem("O id do produto deve ser um número válido.");
            return resultado;
        } catch (SQLException e) {
            resultado.setValido(false);
            resultado.setMensagem("Erro de comunicação com o db:" + e.getMessage() );
            return resultado;
        }

        // Verifica se o fornecedor foi selecionado
        if ("Selecione".equals(IdFornecedor)) {
            resultado.setValido(false);
            resultado.setMensagem("Selecione um fornecedor.");
            return resultado;
        }
        // Se passar por todas as verificações, define o resultado como válido e retorna
        resultado.setValido(true);
        return resultado;
    }

    public void carregarEntradasParaTabela(JTable table) {
        try {
            //  selecionando todos items da table na db
            List<Entrada> entradas = entradaDAO.selectAll();
            if (entradas != null) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                for (Entrada entrada : entradas) {
                    String fornecedor = entrada.getIdFornecedor() + " " + entrada.getFornecedor().getNome();
                    String produto = entrada.getIdProduto()   + " " + entrada.getNomeProduto();
                    String valorTotal = String.format("%.02f", entrada.getValorTotal());
                    String data = Utils.formatarData(entrada.getDataEntrada());
                    model.addRow(new Object[]{entrada.getId(), data, produto, fornecedor , entrada.getQuantidade(), valorTotal});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean cadastrar(String quantidadeStr, String IdFornecedorStr, String IdProdutoStr) {
        try {
            ResultadoValidacao resultado = validar(quantidadeStr, IdFornecedorStr, IdProdutoStr);
            if (resultado.isValido()) {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                FornecedorDAO fornecedorDAO = new FornecedorDAO();

                int IdFornecedor = Integer.parseInt(IdFornecedorStr);
                int IdProduto = Integer.parseInt(IdProdutoStr);
                float quantidade = Float.parseFloat(quantidadeStr);

                Fornecedor fornecedor = fornecedorDAO.selectById(IdFornecedor);
                Produto produto = produtoDAO.selectById(IdProduto);
                Entrada entrada = new Entrada();
                entrada.setDataEntrada(new Date());
                entrada.setFornecedor(fornecedor);
                ItemEntrada itemEntrada = new ItemEntrada(entrada, produto, quantidade);
                entrada.setItem(itemEntrada);

                entradaDAO.cadastrarEntrada(entrada);
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

    public boolean alterar(int id ,String quantidadeStr, String IdFornecedorStr, String IdProdutoStr) {
        try {
            ResultadoValidacao resultado = validar( quantidadeStr,  IdFornecedorStr,  IdProdutoStr);
            if (resultado.isValido()) {
           // todo
            }else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }
              ProdutoDAO produtoDAO = new ProdutoDAO();
              FornecedorDAO fornecedorDAO = new FornecedorDAO();
            // transformando as strings
            float quantidade = Float.parseFloat(quantidadeStr);
            int idFornecedor = Integer.parseInt(IdFornecedorStr);
            int idProduto = Integer.parseInt(IdProdutoStr);
  
               Fornecedor fornecedor = fornecedorDAO.selectById(idFornecedor);
                Produto produto = produtoDAO.selectById(idProduto);
                Entrada entrada = entradaDAO.selectById(id);
                
                entrada.setDataEntrada(new Date());
                entrada.setFornecedor(fornecedor);
                ItemEntrada itemEntrada = new ItemEntrada(entrada, produto, quantidade);
                entradaDAO.removerItemEntrada(id);
                // quando atualiza so a quantidade nao vaii
                entrada.setItem(itemEntrada);
                
            if (!entradaDAO.alterar(entrada)) {
            JOptionPane.showMessageDialog(null, " Erro ao alterar Receita no DB ");
                return false;
            } else {
                JOptionPane.showMessageDialog(null, " Receita alterada com sucesso!");
                return true;
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
                entradaDAO.removerEntrada(id);
            }
        } catch (SQLException e) {
            sucesso = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sucesso;
    }
//
//    public void carregarReceitasDoEntradaParaTabela(JTable table, int idEntrada) {
//        try {
//            Entrada entrada = entradaDAO.selectById(idEntrada);
//
//            List<EntradaReceita> receitas = entrada.getReceitas();
//
//            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//            tableModel.setRowCount(0);
//
//            for (EntradaReceita receita : receitas) {
//                Object[] dados = new Object[]{receita.getReceita().getId(), receita.getReceita().getNome(), receita.getReceita()};
//                tableModel.addRow(dados);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
//
//    public void SelecionarReceitasDoEntradaNaTable(int idEntrada, JTable tableReceita) {
//        try {
//            Entrada entrada = entradaDAO.selectById(idEntrada);
//            List<EntradaReceita> receitas = entrada.getReceitas();
//            List<Integer> receitasIds = new ArrayList<>();
//
//            // pegando as receitas pelo id
//            for (EntradaReceita entradaReceita : receitas) {
//                receitasIds.add(entradaReceita.getReceita().getId());
//            }
//            // Selecionando as Ingredientes da receita que tao na table            
//            for (int i = 0; i < tableReceita.getRowCount(); i++) {
//                int id = (int) tableReceita.getValueAt(i, 0);
//                if (receitasIds.contains(id)) {
//                    tableReceita.addRowSelectionInterval(i, i);
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }
//
//    public void receitasDoEntradaParaTable(JTable jTableReceitasEntrada, int idEntrada) {
//        try {
//            Entrada entrada = entradaDAO.selectById(idEntrada);
//
//            List<EntradaReceita> receitas = entrada.getReceitas();
//            DefaultTableModel tableModel = (DefaultTableModel) jTableReceitasEntrada.getModel();
//            tableModel.setRowCount(0);
//
//            for (EntradaReceita receita : receitas) {
//                Object[] dados = new Object[]{receita.getReceita().getId(), receita.getReceita().getNome(), receita.getQuantidade(), receita.getReceita().getTipo()};
//                tableModel.addRow(dados);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.getMessage());
//        }
//    }

}
