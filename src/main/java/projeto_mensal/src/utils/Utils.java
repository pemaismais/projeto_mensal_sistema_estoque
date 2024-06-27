/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto_mensal.src.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author henri
 */
public class Utils {

    public Utils() {
    }

    public String pegarIdDaString(String string) {
        int posicaoDoEspaco = string.indexOf(" "); // pega a posicao do primeiro espaco q achar
        String idString = string.substring(0, posicaoDoEspaco); // Extrair a parte do ID (como string)
        return idString;
    }

    public static String formatarDataParaString(Date data){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            // Formata a data usando o SimpleDateFormat
            String dataStr = formatter.format(data);
            return dataStr;
    }

    public static Date formatarStringParaData(String dataStr) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        try {
            // Parse da string para obter um objeto Date
            Date dataDesformatada = formatter.parse(dataStr);
            return dataDesformatada;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ParseException("Erro na conversão da data:" + e.getMessage(), e.getErrorOffset());
        }
    }

    public String formatarString(String string) {
        if (string.contains(",")) {
            string = string.replace(",", ".");
        }
        return string;
    }

    public String desformatarNumero(String numero) {
        return numero.replaceAll("[^0-9]", "");
    }

    public String formatarTelefone(String telefone) {
        desformatarNumero(telefone);

        if (telefone.length() == 11) {
            // Formato com DDI, DDD e número
            return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-" + telefone.substring(7);
        } else if (telefone.length() == 10) {
            return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 6) + "-" + telefone.substring(6);
        } else {
            // Retornar o número original se não for possível formatar
            return telefone;
        }
    }

    public String formatarCEP(String cep) {
        desformatarNumero(cep);

        // Verifica se o CEP possui o tamanho correto
        if (cep.length() == 8) {
            // Formatação do CEP para o formato padrão XXXXX-XXX
            return cep.substring(0, 5) + "-" + cep.substring(5);
        } else {
            // Retorna o CEP original se não for possível formatar
            return cep;
        }
    }

    public String formatarCPF(String cpf) {
        // Verifica se o CPF já está no formato correto
        if (cpf.length() == 11) {
            return cpf.substring(0, 3) + "."
                    + cpf.substring(3, 6) + "."
                    + cpf.substring(6, 9) + "-"
                    + cpf.substring(9);
        } else {
            // Retorna o cnpj original se não for possível formatar
            return cpf;
        }
    }

    public String formatarCNPJ(String cnpj) {
        // Verifica se o CNPJ já está no formato correto
        if (cnpj.length() == 14) {
            return cnpj.substring(0, 2) + "."
                    + cnpj.substring(2, 5) + "."
                    + cnpj.substring(5, 8) + "/"
                    + cnpj.substring(8, 12) + "-"
                    + cnpj.substring(12);
        } else {
            // Retorna o cnpj original se não for possível formatar
            return cnpj;
        }
    }

    public void limparCampos(Object[] components) {
        for (Object component : components) {
            if (component instanceof JComboBox) {
                ((JComboBox<?>) component).setSelectedIndex(0); // Limpa a seleção do JComboBox
            } else if (component instanceof JTextField jTextField) {
                jTextField.setText(""); // Limpa o texto do JTextField
            }
        }
    }

    public void tableParaCampos(Object[] components, JTable table) {
        Object value;
        for (int i = 0; i < components.length; i++) {
            value = table.getValueAt(table.getSelectedRow(), i);
            if (components[i] instanceof JComboBox) {
                JComboBox<?> comboBox = (JComboBox<?>) components[i];
                comboBox.setSelectedItem(value.toString());
            } else if (components[i] instanceof JTextField) {
                JTextField textField = (JTextField) components[i];
                textField.setText(value.toString());
            }
        }
    }

    public ArrayList<String> pegarStringsDaTable(JTable table, int column) {
        int rows = table.getRowCount();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String value = table.getValueAt(i, column).toString();
            values.add(value);
        }
        return values;
    }

    public ArrayList<Integer> pegarIdsSelecionadosDaTable(JTable table) {
        if (table.getSelectedRows() == null) {
            return null;
        }
        int[] rowsIndexes = table.getSelectedRows();
        ArrayList<Integer> ids = new ArrayList<>();

        for (int i = 0; i < rowsIndexes.length; i++) {
            int id = Integer.parseInt(table.getValueAt(rowsIndexes[i], 0).toString());
            ids.add(id);
        }
        return ids;
    }

    public ArrayList<String> pegarStringsSelecionadasDaTable(JTable table, int column) {
        if (table.getSelectedRows() == null) {
            return null;
        }
        int[] rowsIndexes = table.getSelectedRows();
        ArrayList<String> values = new ArrayList<>();

        for (int i = 0; i < rowsIndexes.length; i++) {
            String value = table.getValueAt(rowsIndexes[i], column).toString();
            values.add(value);
        }
        return values;
    }

}
