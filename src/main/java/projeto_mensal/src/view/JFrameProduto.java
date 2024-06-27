/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto_mensal.src.view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import projeto_mensal.src.controller.ProdutoController;
import projeto_mensal.src.model.DTO.ProdutoDTO;
import projeto_mensal.src.utils.Utils;

/**
 *
 * @author henri
 */
public class JFrameProduto extends javax.swing.JFrame {

    private JFrameHome home;
    private JFrameEntrada jFrameEntrada = null;
    private JFrameSaida jFrameSaida = null;
    private ProdutoController produtoController;
    private Utils util;

    public JFrameProduto() {
        initComponents();
        this.produtoController = new ProdutoController();
        this.util = new Utils();

    }
    // quando criado pela home

    public JFrameProduto(JFrameHome home) {
        initComponents();
        this.home = home;
        this.produtoController = new ProdutoController();
        this.util = new Utils();
    }
    // quando criado como consulta

    public JFrameProduto(JFrameEntrada jFrameEntrada, JTextField jTextFieldProduto) {
        initComponents();
        this.jFrameEntrada = jFrameEntrada;
        this.produtoController = new ProdutoController();
        this.util = new Utils();
    }
        public JFrameProduto(JFrameSaida jFrameSaida, JTextField jTextFieldProduto) {
        initComponents();
        this.jFrameSaida = jFrameSaida;
        this.produtoController = new ProdutoController();
        this.util = new Utils();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        produtosPanel = new javax.swing.JPanel();
        scrollTableProdutos = new javax.swing.JScrollPane();
        tableProduto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonEnviar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JTextFieldPreco = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonConsultarId = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButtonConsultarNome = new javax.swing.JButton();
        JComboBoxTipo = new javax.swing.JComboBox<>();
        jButtonListarTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Preço", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableProduto.getTableHeader().setReorderingAllowed(false);
        tableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProdutoMouseClicked(evt);
            }
        });
        scrollTableProdutos.setViewportView(tableProduto);
        if (tableProduto.getColumnModel().getColumnCount() > 0) {
            tableProduto.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableProduto.getColumnModel().getColumn(2).setPreferredWidth(5);
            tableProduto.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jButtonAlterar.setBackground(new java.awt.Color(255, 255, 204));
        jButtonAlterar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterar(evt);
            }
        });

        jButtonEnviar.setBackground(new java.awt.Color(204, 255, 204));
        jButtonEnviar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEnviar.setText("Enviar");
        jButtonEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviar(evt);
            }
        });

        jButtonLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpar(evt);
            }
        });

        jButtonRemover.setBackground(new java.awt.Color(255, 204, 204));
        jButtonRemover.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Preço");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tipo");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Nome");

        JTextFieldPreco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JTextFieldPreco.setToolTipText("Somente os numeros");

        jTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonConsultarId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConsultarId.setToolTipText("Consultar por ID.");
        jButtonConsultarId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarProdutosPorId(evt);
            }
        });

        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldId.setToolTipText("Somente os numeros");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("ID");

        jButtonConsultarNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConsultarNome.setToolTipText("Consultar por nome.");
        jButtonConsultarNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarProdutosPorNome(evt);
            }
        });

        JComboBoxTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o tipo ", "Unidade", "Kilos", "Litros" }));
        JComboBoxTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(JComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12))))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConsultarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultarId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(JTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        jButtonListarTodos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonListarTodos.setText("Listar todos");
        jButtonListarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarTodosProdutos(evt);
            }
        });

        javax.swing.GroupLayout produtosPanelLayout = new javax.swing.GroupLayout(produtosPanel);
        produtosPanel.setLayout(produtosPanelLayout);
        produtosPanelLayout.setHorizontalGroup(
            produtosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(produtosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(produtosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(produtosPanelLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonListarTodos)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollTableProdutos)
        );
        produtosPanelLayout.setVerticalGroup(
            produtosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, produtosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButtonListarTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTableProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(produtosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(produtosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carregarTodosProdutosParaTabela() {
        produtoController.carregarTodosProdutosParaTabela(tableProduto);
    }

    private void resetarCampos() {
        util.limparCampos(new Object[]{jTextFieldNome, JTextFieldPreco, JComboBoxTipo});
        tableProduto.clearSelection();
        DefaultTableModel model = (DefaultTableModel) tableProduto.getModel();
        model.setRowCount(0);
    }


    private void tableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProdutoMouseClicked
        // caso esse frame produto seja criado por consulta, ele pega o id e fecha 
        if (jFrameEntrada != null || jFrameSaida != null) {
            ArrayList<Integer> ids = util.pegarIdsSelecionadosDaTable(tableProduto);
            ArrayList<String> preco = util.pegarStringsSelecionadasDaTable(tableProduto, 2);
            ArrayList<String> tipo = util.pegarStringsSelecionadasDaTable(tableProduto, 3);
            // se tiver apenas um selecionado
            if (ids.size() == 1) {
                if(this.jFrameEntrada != null){
                    this.jFrameEntrada.pegarIdProdutoDaConsulta(ids.get(0), preco.get(0), tipo.get(0) );
                }else{
                    this.jFrameSaida.pegarIdProdutoDaConsulta(ids.get(0), preco.get(0), tipo.get(0) );
                }
                this.dispose();
            }
        } else {
            util.tableParaCampos(new Object[]{jTextFieldId, jTextFieldNome, JTextFieldPreco, JComboBoxTipo}, tableProduto);
        }

    }//GEN-LAST:event_tableProdutoMouseClicked

    private void remover(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover
//        // TODO add your handling code here:
        ArrayList<Integer> ids = util.pegarIdsSelecionadosDaTable(tableProduto);
        int resposta;
        if (ids.size() == 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover um Produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else if (ids.size() > 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover mais de um Produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover!");
            return;
        }
        switch (resposta) {
            case JOptionPane.YES_OPTION -> {
                // fazendo com 1 primeiro
                if (produtoController.remover(ids)) {
                    if (ids.size() == 1) {
                        JOptionPane.showMessageDialog(null, "Item Removido com sucesso ");
                    } else {
                        JOptionPane.showMessageDialog(null, "Itens Removidos com sucesso ");
                    }
                    resetarCampos();
                }
            }
        }
    }//GEN-LAST:event_remover

    private void alterar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterar
        ArrayList<Integer> ids = util.pegarIdsSelecionadosDaTable(tableProduto);
        if (ids.size() == 1) {
            int resposta;
            // confirmando se quer alterar
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá alterar um produto. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int id = ids.get(0);
                String nome = jTextFieldNome.getText().trim();
                String preco = JTextFieldPreco.getText().trim();
                String tipo = JComboBoxTipo.getSelectedItem().toString();
                ProdutoDTO produtoDTO = new ProdutoDTO(id, nome, preco, tipo);
                if (produtoController.alterar(produtoDTO)) {
                    JOptionPane.showMessageDialog(null, "Produto alterado!");
                    resetarCampos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas um produto para modificar!");
        }
    }//GEN-LAST:event_alterar

    private void enviar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviar
        String nome = jTextFieldNome.getText().trim();
        String preco = JTextFieldPreco.getText().trim();
        String tipo = JComboBoxTipo.getSelectedItem().toString();
        ProdutoDTO produtoDTO = new ProdutoDTO(nome, preco, tipo);

        if (produtoController.cadastrar(produtoDTO)) {
            JOptionPane.showMessageDialog(null, "Produto cadastrado!");
            resetarCampos();
        }
    }//GEN-LAST:event_enviar

    private void limpar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar
        // TODO add your handling code here:
        resetarCampos();
    }//GEN-LAST:event_limpar

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        if (jFrameEntrada == null && jFrameSaida == null) {
            this.dispose();
            home.setVisible(true);
        } else {

        }
    }//GEN-LAST:event_formWindowClosed

    private void carregarTodosProdutos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarTodosProdutos
        // TODO add your handling code here:
        carregarTodosProdutosParaTabela();
    }//GEN-LAST:event_carregarTodosProdutos

    private void carregarProdutosPorNome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarProdutosPorNome
        // TODO add your handling code here:
        String nome = jTextFieldNome.getText().trim();
        if (!nome.equals("")) {
            produtoController.carregarProdutosPeloNomeParaTabela(nome, tableProduto);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um nome para filtrar");
        }
    }//GEN-LAST:event_carregarProdutosPorNome

    private void carregarProdutosPorId(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarProdutosPorId
        // TODO add your handling code here:

        String id = jTextFieldId.getText().trim();
        if (!id.equals("")) {
            produtoController.carregarProdutosPeloIdParaTabela(id, tableProduto);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um id para filtrar");
        }
    }//GEN-LAST:event_carregarProdutosPorId

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        IconFontSwing.register(FontAwesome.getIconFont());
        jButtonConsultarId.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 16, Color.black));
        jButtonConsultarNome.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 16, Color.black));
        jButtonListarTodos.setIcon(IconFontSwing.buildIcon(FontAwesome.BARS, 16, Color.black));
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBoxTipo;
    private javax.swing.JTextField JTextFieldPreco;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultarId;
    private javax.swing.JButton jButtonConsultarNome;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonListarTodos;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JPanel produtosPanel;
    private javax.swing.JScrollPane scrollTableProdutos;
    private javax.swing.JTable tableProduto;
    // End of variables declaration//GEN-END:variables
}
