/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.controller;

import projeto_mensal.src.utils.ResultadoValidacao;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import projeto_mensal.src.dao.ProdutoDAO;
import projeto_mensal.src.dao.SaidaDAO;
import projeto_mensal.src.model.ItemSaida;
import projeto_mensal.src.model.Saida;
import projeto_mensal.src.model.Produto;
import projeto_mensal.src.utils.Utils;

/**
 *
 * @author henri
 */
public class SaidaController {

    private SaidaDAO saidaDAO;

    public SaidaController() {
        this.saidaDAO = new SaidaDAO();
    }

    public ResultadoValidacao validar(String quantidadeStr, String IdProduto, String data) {
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
        // validando se o id  do produto existe
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
            resultado.setMensagem("Erro de comunicação com o db:" + e.getMessage());
            return resultado;
        }
        // verificando se a data ta certa
        try {
            Utils.formatarStringParaData(data);
        } catch (ParseException e) {
            resultado.setValido(false);
            resultado.setMensagem("Insira uma data/horario válida");
            return resultado;
        }

        // verificando se a quantidade é menor que o estoque
        int id = Integer.parseInt(IdProduto);
        float quantidade = Float.parseFloat(quantidadeStr);
        EstoqueController estoqueController = new EstoqueController();
        float estoque = estoqueController.consultarSaldoEstoque(id);

        if (quantidade > estoque) {
            resultado.setValido(false);
            resultado.setMensagem("Estoque insuficiente");
            return resultado;
        }
        // Se passar por todas as verificações, define o resultado como válido e retorna
        resultado.setValido(true);
        return resultado;
    }

    public void carregarSaidasParaTabela(JTable table) {
        try {
            //  selecionando todos items da table na db
            List<Saida> saidas = saidaDAO.selectAll();
            if (saidas != null) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                for (Saida saida : saidas) {
                    String produto = saida.getIdProduto() + " " + saida.getNomeProduto();
                    String valorTotal = String.format("%.02f", saida.getValorTotal());
                    String data = Utils.formatarDataParaString(saida.getDataSaida());
                    model.addRow(new Object[]{saida.getId(), data, produto, saida.getQuantidade(), valorTotal});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public boolean cadastrar(String quantidadeStr, String IdProdutoStr, String dataStr) {
        try {
            ResultadoValidacao resultado = validar(quantidadeStr, IdProdutoStr, dataStr);
            if (resultado.isValido()) {
                ProdutoDAO produtoDAO = new ProdutoDAO();

                int IdProduto = Integer.parseInt(IdProdutoStr);
                float quantidade = Float.parseFloat(quantidadeStr);
                Date data = Utils.formatarStringParaData(dataStr);

                Produto produto = produtoDAO.selectById(IdProduto);
                Saida saida = new Saida();
                saida.setDataSaida(data);
                ItemSaida itemSaida = new ItemSaida(saida, produto, quantidade);
                saida.setItem(itemSaida);

                saidaDAO.cadastrarSaida(saida);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean alterar(int id, String quantidadeStr, String IdProdutoStr, String dataStr) {
        try {
            ResultadoValidacao resultado = validar(quantidadeStr, IdProdutoStr, dataStr);
            if (resultado.isValido()) {
                // todo
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao processar dados: " + resultado.getMensagem());
                return false;
            }
            ProdutoDAO produtoDAO = new ProdutoDAO();
            // transformando as strings
            float quantidade = Float.parseFloat(quantidadeStr);
            int idProduto = Integer.parseInt(IdProdutoStr);
            Date data = Utils.formatarStringParaData(dataStr);

            Produto produto = produtoDAO.selectById(idProduto);
            Saida saida = saidaDAO.selectById(id);

            saida.setDataSaida(data);
            ItemSaida itemSaida = new ItemSaida(saida, produto, quantidade);
            saidaDAO.removerItem(id);
            saida.setItem(itemSaida);

            saidaDAO.alterar(saida);
            return true;
        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    public boolean remover(ArrayList<Integer> ids) {
        boolean sucesso = true;
        try {
            for (Integer id : ids) {
                saidaDAO.removerSaida(id);
            }
        } catch (SQLException e) {
            sucesso = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sucesso;
    }

}
