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
import projeto_mensal.src.dao.FornecedorDAO;
import projeto_mensal.src.model.Fornecedor;
import projeto_mensal.src.model.DTO.FornecedorDTO;
import projeto_mensal.src.utils.Utils;

/**
 *
 * @author henri
 */
public class FornecedorController {

    private FornecedorDAO fornecedorDAO;
    private Utils util;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
        this.util = new Utils();
    }

    public ResultadoValidacao validar(FornecedorDTO fornecedor) {
        ResultadoValidacao resultado = new ResultadoValidacao(); // Cria um objeto para armazenar o resultado da validação

        // Verifica se o nome está vazio
        if (fornecedor.getNome().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("Nome do ingrediente não pode estar vazio.");
            return resultado;
        }

        if (fornecedor.getCnpjcpf().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("cnpj/cpf não pode estar vazio.");
            return resultado;
        }
        fornecedor.setCnpjcpf(util.desformatarNumero(
                fornecedor.getCnpjcpf()));

        if (fornecedor.getCnpjcpf().length() != 11 && fornecedor.getTelefone().length() != 14) {
            resultado.setValido(false);
            resultado.setMensagem("Insira um cpnj/cpf válido.");
            return resultado;
        }

        if (fornecedor.getCep().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("cep não pode estar vazio.");
            return resultado;
        }

        fornecedor.setCep(util.desformatarNumero(
                fornecedor.getCep()));

        if (fornecedor.getCep().length() != 8) {
            resultado.setValido(false);
            resultado.setMensagem("Insira um cep válido.");
            return resultado;
        }

        if (fornecedor.getTelefone().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("telefone não pode estar vazio.");
            return resultado;
        }
        fornecedor.setTelefone(util.desformatarNumero(
                fornecedor.getTelefone()));

        if (fornecedor.getTelefone().length() != 11) {
            resultado.setValido(false);
            resultado.setMensagem("Insira um telefone válido.");
            return resultado;
        }

        if (fornecedor.getUf().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("uf não pode estar vazio.");
            return resultado;
        }
        if (fornecedor.getCidade().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("cidade não pode estar vazio.");
            return resultado;
        }
        if (fornecedor.getLogradouro().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("Logradouro não pode estar vazio.");
            return resultado;
        }
        if (fornecedor.getBairro().isEmpty()) {
            resultado.setValido(false);
            resultado.setMensagem("Bairro não pode estar vazio.");
            return resultado;
        }

        fornecedor.setCnpjcpf(util.formatarCNPJ(
                fornecedor.getCnpjcpf()));
        fornecedor.setCnpjcpf(util.formatarCPF(
                fornecedor.getCnpjcpf()));
        fornecedor.setCep(util.formatarCEP(
                fornecedor.getCep()));
        fornecedor.setTelefone(util.formatarTelefone(
                fornecedor.getTelefone()));

        // Se passar por todas as verificações, define o resultado como válido e retorna
        resultado.setValido(true);
        return resultado;
    }

    public boolean cadastrar(FornecedorDTO fornecedorDTO) {
        try {
            ResultadoValidacao resultado = validar(fornecedorDTO);
            if (resultado.isValido()) {
                Fornecedor fornecedor = new Fornecedor(
                        fornecedorDTO.getCnpjcpf(),
                        fornecedorDTO.getNome(),
                        fornecedorDTO.getCep(),
                        fornecedorDTO.getTelefone(),
                        fornecedorDTO.getUf(),
                        fornecedorDTO.getCidade(),
                        fornecedorDTO.getBairro(),
                        fornecedorDTO.getLogradouro()
                );
                fornecedorDAO.cadastrar(fornecedor);
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
                fornecedorDAO.remover(id);
            }
        } catch (SQLException e) {
            sucesso = false;
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sucesso;
    }

    public boolean alterar(FornecedorDTO fornecedorDTO) {
        try {
            ResultadoValidacao resultado = validar(fornecedorDTO);
            if (resultado.isValido()) {
                Fornecedor fornecedor = fornecedorDAO.selectById(
                        fornecedorDTO.getId());
                fornecedor.setNome(fornecedorDTO.getNome());
                fornecedor.setCnpjcpf(fornecedorDTO.getCnpjcpf());
                fornecedor.setTelefone(fornecedorDTO.getTelefone());
                fornecedor.setCep(fornecedorDTO.getCep());
                fornecedor.setUf(fornecedorDTO.getUf());
                fornecedor.setCidade(fornecedorDTO.getCidade());
                fornecedor.setBairro(fornecedorDTO.getBairro());
                fornecedor.setLogradouro(fornecedorDTO.getLogradouro());

                fornecedorDAO.alterar(fornecedor);
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

    public ArrayList<String> getIdsENomes() {
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.selectAll();
            ArrayList<String> idsENomes = new ArrayList<>();

            for (Fornecedor fornecedor : fornecedores) {
                String IdENome = fornecedor.getId() + " " + fornecedor.getNome();
                idsENomes.add(IdENome);
            }
            return idsENomes;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    private void carregarFornecedoresParaTabela(List<Fornecedor> fornecedores, JTable table) {
        try {
            //  selecionando todos items da table na db
            if (fornecedores != null) {
                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.setRowCount(0);

                for (Fornecedor fornecedor : fornecedores) {
                    tableModel.addRow(new Object[]{fornecedor.getId(),
                        fornecedor.getNome(),
                        fornecedor.getCnpjcpf(),
                        fornecedor.getTelefone(),
                        fornecedor.getCep(),
                        fornecedor.getUf(),
                        fornecedor.getCidade(),
                        fornecedor.getBairro(),
                        fornecedor.getLogradouro()});
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarTodosFornecedoresParaTabela(JTable table) {
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.selectAll();
            carregarFornecedoresParaTabela(fornecedores, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarFornecedoresPeloNomeParaTabela(String nome, JTable table) {
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.selectByNomeAll(nome);
            carregarFornecedoresParaTabela(fornecedores, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void carregarFornecedoresPeloCnpjCpfParaTabela(String cnpjcpf, JTable table) {
        try {
            List<Fornecedor> fornecedores = fornecedorDAO.selectByCnpjCpfAll(cnpjcpf);
            carregarFornecedoresParaTabela(fornecedores, table);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
