/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto_mensal.src.view;

import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPException;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import projeto_mensal.src.controller.FornecedorController;
import projeto_mensal.src.model.DTO.FornecedorDTO;
import projeto_mensal.src.utils.Utils;

/**
 *
 * @author henri
 */
public class JFrameFornecedor extends javax.swing.JFrame {

    private Utils util;
    private FornecedorController fornecedorController;
    private JFrameHome home;

    public JFrameFornecedor() {
        initComponents();
        this.util = new Utils();
        this.fornecedorController = new FornecedorController();
    }
        public JFrameFornecedor(JFrameHome home) {
        initComponents();
        this.home = home;
        this.util = new Utils();
        this.fornecedorController = new FornecedorController();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fornecedorPanel = new javax.swing.JPanel();
        scrollTableFornecedor = new javax.swing.JScrollPane();
        tableFornecedor = new javax.swing.JTable();
        jButtonCarregarTodosProdutos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTextFieldUF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        JTextFieldLogradouro = new javax.swing.JTextField();
        JTextFieldCidade = new javax.swing.JTextField();
        JTextFieldCep = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        JTextFieldCnpjCpf = new javax.swing.JTextField();
        JTextFieldBairro = new javax.swing.JTextField();
        JTextFieldTelefone = new javax.swing.JTextField();
        JTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRemover = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonEnviar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonConsultarNome = new javax.swing.JButton();
        jButtonConsultarCnpjCpf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fornecedor");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CNPJ / CPF", "Telefone", "CEP", "UF", "Cidade", "Bairro", "Logradouro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableFornecedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableFornecedor.setShowGrid(false);
        tableFornecedor.getTableHeader().setReorderingAllowed(false);
        tableFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableFornecedorMouseClicked(evt);
            }
        });
        scrollTableFornecedor.setViewportView(tableFornecedor);
        if (tableFornecedor.getColumnModel().getColumnCount() > 0) {
            tableFornecedor.getColumnModel().getColumn(0).setPreferredWidth(5);
            tableFornecedor.getColumnModel().getColumn(1).setPreferredWidth(30);
            tableFornecedor.getColumnModel().getColumn(2).setPreferredWidth(30);
            tableFornecedor.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableFornecedor.getColumnModel().getColumn(4).setPreferredWidth(5);
            tableFornecedor.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        jButtonCarregarTodosProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCarregarTodosProdutos.setText("Listar todos");
        jButtonCarregarTodosProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCarregarTodosProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarTodosFornecedores(evt);
            }
        });

        javax.swing.GroupLayout fornecedorPanelLayout = new javax.swing.GroupLayout(fornecedorPanel);
        fornecedorPanel.setLayout(fornecedorPanelLayout);
        fornecedorPanelLayout.setHorizontalGroup(
            fornecedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fornecedorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fornecedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTableFornecedor)
                    .addGroup(fornecedorPanelLayout.createSequentialGroup()
                        .addComponent(jButtonCarregarTodosProdutos)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        fornecedorPanelLayout.setVerticalGroup(
            fornecedorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fornecedorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonCarregarTodosProdutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTableFornecedor, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Bairro");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Cidade");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Telefone");

        JTextFieldUF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Logradouro");

        JTextFieldLogradouro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JTextFieldCidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JTextFieldCep.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JTextFieldCep.setToolTipText("Somente os numeros");
        JTextFieldCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextFieldCepActionPerformed(evt);
            }
        });
        JTextFieldCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                autoCompletarCEP(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CNPJ / CPF");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("UF");

        JTextFieldCnpjCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JTextFieldCnpjCpf.setToolTipText("");

        JTextFieldBairro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        JTextFieldTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JTextFieldTelefone.setToolTipText("");

        JTextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("CEP");

        jButtonRemover.setBackground(new java.awt.Color(255, 204, 204));
        jButtonRemover.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonConsultarNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConsultarNome.setToolTipText("Consultar por nome");
        jButtonConsultarNome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarFornecedoresPorNome(evt);
            }
        });

        jButtonConsultarCnpjCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonConsultarCnpjCpf.setToolTipText("Consultar por Cnpj  / Cpf");
        jButtonConsultarCnpjCpf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsultarCnpjCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarFornecedoresPorCnpjCpf(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(JTextFieldUF, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(JTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(JTextFieldCnpjCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarCnpjCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(JTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConsultarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonConsultarCnpjCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTextFieldCnpjCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldUF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fornecedorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fornecedorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void carregarTodosFornecedoresParaTabela() {
        fornecedorController.carregarTodosFornecedoresParaTabela(tableFornecedor);
    }

    private void resetarCampos() {
        util.limparCampos(new Object[]{JTextFieldNome, JTextFieldCnpjCpf, JTextFieldCep, JTextFieldTelefone, JTextFieldUF, JTextFieldCidade, JTextFieldBairro, JTextFieldLogradouro});
        DefaultTableModel model = (DefaultTableModel) tableFornecedor.getModel();
        model.setRowCount(0);
    }


    private void enviar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviar
        String nome = JTextFieldNome.getText().trim();
        String cnpjcpf = JTextFieldCnpjCpf.getText().trim();
        String cep = JTextFieldCep.getText().trim();
        String telefone = JTextFieldTelefone.getText().trim();
        String uf = JTextFieldUF.getText().trim();
        String cidade = JTextFieldCidade.getText().trim();
        String bairro = JTextFieldBairro.getText().trim();
        String logradouro = JTextFieldLogradouro.getText().trim();
        FornecedorDTO fornecedorDTO = new FornecedorDTO(cnpjcpf, nome, cep, telefone, uf, cidade, bairro, logradouro);

        if (fornecedorController.cadastrar(fornecedorDTO)) {
            resetarCampos();
        }
    }//GEN-LAST:event_enviar

    private void limpar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpar
        // TODO add your handling code here:
        resetarCampos();
    }//GEN-LAST:event_limpar

    private void remover(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover
        // TODO add your handling code here:
        ArrayList<Integer> ids = util.pegarIdsSelecionadosDaTable(tableFornecedor);
        int resposta;
        if (ids.size() == 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover um Fornecedor. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else if (ids.size() > 1) {
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá remover mais de um Fornecedor. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para remover!");
            return;
        }
        switch (resposta) {
            case JOptionPane.YES_OPTION -> {
                // fazendo com 1 primeiro
                if (fornecedorController.remover(ids)) {
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
        ArrayList<Integer> ids = util.pegarIdsSelecionadosDaTable(tableFornecedor);
        if (ids.size() == 1) {
            int resposta;
            // confirmando se quer alterar
            resposta = JOptionPane.showConfirmDialog(null, "Voce irá alterar um Fornecedor. Deseja continuar?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                int id = ids.get(0);
                String nome = JTextFieldNome.getText().trim();
                String cnpjcpf = JTextFieldCnpjCpf.getText().trim();
                String cep = JTextFieldCep.getText().trim();
                String telefone = JTextFieldTelefone.getText().trim();
                String uf = JTextFieldUF.getText().trim();
                String cidade = JTextFieldCidade.getText().trim();
                String bairro = JTextFieldBairro.getText().trim();
                String logradouro = JTextFieldLogradouro.getText().trim();

                FornecedorDTO fornecedorDTO = new FornecedorDTO(id, cnpjcpf, nome, cep, telefone, uf, cidade, bairro, logradouro);

                if (fornecedorController.alterar(fornecedorDTO)) {
                    resetarCampos();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione apenas um produto para modificar!");
        }
    }//GEN-LAST:event_alterar

    private void tableFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableFornecedorMouseClicked
    util.tableParaCampos(new Object[]{null, JTextFieldNome, JTextFieldCnpjCpf, JTextFieldTelefone, JTextFieldCep, JTextFieldUF, JTextFieldCidade, JTextFieldBairro, JTextFieldLogradouro}, tableFornecedor);
    }//GEN-LAST:event_tableFornecedorMouseClicked

    private void autoCompletarCEP(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_autoCompletarCEP
        // TODO add your handling code here:
        if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
            ViaCEP viacep = new ViaCEP();
            try {
                viacep.buscar(JTextFieldCep.getText());
                JTextFieldUF.setText(viacep.getUf());
                JTextFieldBairro.setText(viacep.getBairro());
                JTextFieldCidade.setText(viacep.getLocalidade());
                JTextFieldLogradouro.setText(viacep.getLogradouro());
            } catch (ViaCEPException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado:\n" + ex.getMessage(), "ERRO!", ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_autoCompletarCEP

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void carregarTodosFornecedores(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarTodosFornecedores
        // TODO add your handling code here:
        carregarTodosFornecedoresParaTabela();
    }//GEN-LAST:event_carregarTodosFornecedores

    private void carregarFornecedoresPorNome(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarFornecedoresPorNome
        // TODO add your handling code here:
        String nome = JTextFieldNome.getText().trim();
        if (!nome.equals("")) {
            fornecedorController.carregarFornecedoresPeloNomeParaTabela(nome, tableFornecedor);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um nome para filtrar");
        }
    }//GEN-LAST:event_carregarFornecedoresPorNome

    private void carregarFornecedoresPorCnpjCpf(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarFornecedoresPorCnpjCpf
        // TODO add your handling code here:
        String cnpjcpf = JTextFieldCnpjCpf.getText().trim();
        if (!cnpjcpf.equals("")) {
            fornecedorController.carregarFornecedoresPeloCnpjCpfParaTabela(cnpjcpf, tableFornecedor);
        } else {
            JOptionPane.showMessageDialog(null, "Insira um cnpj/cpf para filtrar");
        }
        
    }//GEN-LAST:event_carregarFornecedoresPorCnpjCpf

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        IconFontSwing.register(FontAwesome.getIconFont());
        jButtonConsultarNome.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 16, Color.black));
        jButtonConsultarCnpjCpf.setIcon(IconFontSwing.buildIcon(FontAwesome.SEARCH, 16, Color.black));
        jButtonCarregarTodosProdutos.setIcon(IconFontSwing.buildIcon(FontAwesome.BARS, 16, Color.black));
    }//GEN-LAST:event_formWindowOpened

    private void JTextFieldCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextFieldCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextFieldCepActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameFornecedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameFornecedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextFieldBairro;
    private javax.swing.JTextField JTextFieldCep;
    private javax.swing.JTextField JTextFieldCidade;
    private javax.swing.JTextField JTextFieldCnpjCpf;
    private javax.swing.JTextField JTextFieldLogradouro;
    private javax.swing.JTextField JTextFieldNome;
    private javax.swing.JTextField JTextFieldTelefone;
    private javax.swing.JTextField JTextFieldUF;
    private javax.swing.JPanel fornecedorPanel;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCarregarTodosProdutos;
    private javax.swing.JButton jButtonConsultarCnpjCpf;
    private javax.swing.JButton jButtonConsultarNome;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollTableFornecedor;
    private javax.swing.JTable tableFornecedor;
    // End of variables declaration//GEN-END:variables
}
