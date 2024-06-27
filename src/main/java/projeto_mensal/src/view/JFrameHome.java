/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto_mensal.src.view;

import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

/**
 *
 * @author henri
 */
public class JFrameHome extends javax.swing.JFrame {

 
    public JFrameHome() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonEntradas = new javax.swing.JButton();
        jButtonFornecedores = new javax.swing.JButton();
        jButtonSaidas = new javax.swing.JButton();
        jButtonProdutos = new javax.swing.JButton();
        jButtonEstoque = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("=D");

        jButtonEntradas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEntradas.setText("Entradas");
        jButtonEntradas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButtonEntradas.setContentAreaFilled(false);
        jButtonEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntradasActionPerformed(evt);
            }
        });

        jButtonFornecedores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonFornecedores.setText("Fornecedores");
        jButtonFornecedores.setToolTipText("Cadastro e consulta de fornecedores.");
        jButtonFornecedores.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButtonFornecedores.setContentAreaFilled(false);
        jButtonFornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFornecedoresActionPerformed(evt);
            }
        });

        jButtonSaidas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSaidas.setText("Saidas");
        jButtonSaidas.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButtonSaidas.setContentAreaFilled(false);
        jButtonSaidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaidasActionPerformed(evt);
            }
        });

        jButtonProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonProdutos.setText("Produtos");
        jButtonProdutos.setToolTipText("Cadastro e consulta de produtos.");
        jButtonProdutos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButtonProdutos.setContentAreaFilled(false);
        jButtonProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProdutosActionPerformed(evt);
            }
        });

        jButtonEstoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEstoque.setText("Estoque");
        jButtonEstoque.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButtonEstoque.setContentAreaFilled(false);
        jButtonEstoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstoqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(433, 433, 433))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(260, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProdutosActionPerformed
        // TODO add your handling code here:
        JFrameProduto jFrameProduto = new JFrameProduto(this);
        jFrameProduto.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonProdutosActionPerformed

    private void jButtonFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFornecedoresActionPerformed
        // TODO add your handling code here:
        JFrameFornecedor jFrameFornecedor = new JFrameFornecedor(this);
        jFrameFornecedor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonFornecedoresActionPerformed

    private void jButtonSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaidasActionPerformed
        // TODO add your handling code here:
        JFrameSaida jFrameSaida = new JFrameSaida(this);
        jFrameSaida.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButtonSaidasActionPerformed

    private void jButtonEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntradasActionPerformed
        // TODO add your handling code here:
        JFrameEntrada jFrameEntrada = new JFrameEntrada(this);
        jFrameEntrada.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEntradasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        IconFontSwing.register(FontAwesome.getIconFont());
        jButtonProdutos.setIcon(IconFontSwing.buildIcon(FontAwesome.CUBES, 24, Color.black));
        jButtonFornecedores.setIcon(IconFontSwing.buildIcon(FontAwesome.USERS, 24, Color.black));
        jButtonEntradas.setIcon(IconFontSwing.buildIcon(FontAwesome.SIGN_IN, 24, Color.black));
        jButtonSaidas.setIcon(IconFontSwing.buildIcon(FontAwesome.SIGN_OUT, 24, Color.black));
        jButtonEstoque.setIcon(IconFontSwing.buildIcon(FontAwesome.ARCHIVE, 24, Color.black));

    }//GEN-LAST:event_formWindowOpened

    private void jButtonEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstoqueActionPerformed
       
        JFrameEstoque jFrameEstoque = new JFrameEstoque(this);
        jFrameEstoque.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonEstoqueActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new JFrameHome().setVisible(true);
                }
            });
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JFrameHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEntradas;
    private javax.swing.JButton jButtonEstoque;
    private javax.swing.JButton jButtonFornecedores;
    private javax.swing.JButton jButtonProdutos;
    private javax.swing.JButton jButtonSaidas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
