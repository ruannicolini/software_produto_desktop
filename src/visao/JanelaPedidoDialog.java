/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controlador.Controlador;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import negocio.Cliente;
import negocio.PedidoItem;
import negocio.Produto;

/**
 *
 * @author Ruan
 */
public class JanelaPedidoDialog extends javax.swing.JDialog {

    Controlador control;
    Produto prodSelecionado;
    Cliente cli = null;
    //List<Produto> listaProdSelecionados;
//    List<PedidoItem> listaPedidoItem;
    Map<Integer, String> mapProdutos;

    /**
     * Creates new form JanelaPedidoDialog
     */
    public JanelaPedidoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mapProdutos = new HashMap<Integer, String>();
        try {
            control = new Controlador();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO de conexão com o BANCO. Procure o suporte. " + 
                        e.getMessage() );

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO não esperado. " + 
                        e.getMessage() );
        }
        
        // Permite apenas uma linha selecionada por vez na tabela tblProdutos
        tblProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        mnuPedido = new javax.swing.JPopupMenu();
        mnuExcluir = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jtfNomeCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaObservacoes = new javax.swing.JTextArea();
        PanelItensVenda = new javax.swing.JPanel();
        cmbTipo = new javax.swing.JComboBox();
        txtPesq = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProdSelecionado = new javax.swing.JTable();
        btnEncerrarPedido = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        mnuExcluir.setText("Excluir");
        mnuExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExcluirActionPerformed(evt);
            }
        });
        mnuPedido.add(mnuExcluir);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(240, 240, 241));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(240, 240, 241));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("CLIENTE"));

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(240, 240, 241));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("OBSERVAÇÕES"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jtaObservacoes.setColumns(20);
        jtaObservacoes.setLineWrap(true);
        jtaObservacoes.setRows(5);
        jtaObservacoes.setEnabled(false);
        jScrollPane1.setViewportView(jtaObservacoes);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        PanelItensVenda.setBackground(new java.awt.Color(241, 240, 240));
        PanelItensVenda.setBorder(javax.swing.BorderFactory.createTitledBorder("ITENS-VENDA"));
        PanelItensVenda.setPreferredSize(new java.awt.Dimension(417, 363));

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nome", "Linha", "Tipo" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        txtPesq.setEnabled(false);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(240, 240, 241));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Linha", "Tipo", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdutos.setSelectionBackground(new java.awt.Color(0, 153, 0));
        jScrollPane2.setViewportView(tblProdutos);

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelItensVendaLayout = new javax.swing.GroupLayout(PanelItensVenda);
        PanelItensVenda.setLayout(PanelItensVendaLayout);
        PanelItensVendaLayout.setHorizontalGroup(
            PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItensVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PanelItensVendaLayout.createSequentialGroup()
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelItensVendaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)))
                .addContainerGap())
        );
        PanelItensVendaLayout.setVerticalGroup(
            PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelItensVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelItensVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(btnSelecionar)
                .addGap(2, 2, 2))
        );

        jPanel1.setBackground(new java.awt.Color(240, 240, 241));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("PRODUTOS SELECIONADOS"));

        jScrollPane4.setBackground(new java.awt.Color(240, 240, 241));

        tblProdSelecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Linha", "Tipo", "Preço", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProdSelecionado.setComponentPopupMenu(mnuPedido);
        jScrollPane4.setViewportView(tblProdSelecionado);

        btnEncerrarPedido.setText("Encerrar Pedido");
        btnEncerrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEncerrarPedido)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEncerrarPedido))
        );

        jPanel3.setBackground(new java.awt.Color(240, 240, 241));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Comissão Prevista"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(240, 240, 241));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Valor Total Pedido"));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelItensVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelItensVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        

    }//GEN-LAST:event_formComponentShown

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            // TODO add your handling code here:
            control.pesquisarProdutos(tblProdutos, cmbTipo.getSelectedIndex(), txtPesq.getText());
            Produto p;
            String qtd;
            if (mapProdutos.size() > 0) {
                for (int i = 0; i < tblProdutos.getRowCount(); i++) {
                    p = (Produto) tblProdutos.getValueAt(i, 0);
                    qtd = mapProdutos.get(p.getIdProduto());
                    tblProdutos.setValueAt(qtd, i, 4);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao PESQUISAR no BANCO. " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao PESQUISAR. " + ex.getMessage());
        }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        // TODO add your handling code here:
        String descricaoProdSelec;
        int eIgual = 0;
        int linh = tblProdutos.getSelectedRow();
        descricaoProdSelec = (String) ((Produto)tblProdutos.getValueAt(linh, 0)).getDescricao();
        int qtn; 
        qtn = Integer.parseInt(tblProdutos.getValueAt(linh, 4).toString());
        
        if (linh >= 0) {
            // O For pecorre toda Jtable tblProdSelecionado procurando se o produto a ser inserido já esta na tabela. 
            for (int i = 0; i < tblProdSelecionado.getRowCount(); i++) {
                if( descricaoProdSelec.equals((String) ((Produto)tblProdSelecionado.getValueAt(i, 0)).getDescricao())){
                    eIgual = 1;
                }   
            }
            if(eIgual == 0){ // SE eIgual == 0, o produto não estava na tabela, então vai ser inserido.
                if(qtn != 0){
                    Produto p = (Produto) tblProdutos.getValueAt(linh, 0);
                    mapProdutos.put(p.getIdProduto(), tblProdutos.getValueAt(linh, 4).toString());
                    ((DefaultTableModel) tblProdSelecionado.getModel()).addRow(p.toArray());
                    int lastLine = tblProdSelecionado.getRowCount() - 1;
                    tblProdSelecionado.setValueAt(mapProdutos.get(p.getIdProduto()), lastLine, 4);
                }else{
                    JOptionPane.showMessageDialog(this, "Po mano, quantidade zero. Ta de Brincation with me?");
                    tblProdutos.setValueAt(null, linh, 4);
                }
            } else { // se eIgual == 1
                JOptionPane.showMessageDialog(this, "Opa! Este produto já esta Inserido No Pedido.");
            }
            
        }else { 
                JOptionPane.showMessageDialog(this, "Selecione um Produto.");
            }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JanelaClientePesqDialog cliPesq;
        try {
            cliPesq = new JanelaClientePesqDialog(null, true);
            cliPesq.setVisible(true);

            cli = cliPesq.getCliente();

            if (cli != null) {
                jtfNomeCliente.setText(cli.getNome());
                jtaObservacoes.setEnabled(true);
                txtPesq.setEnabled(true);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao PESQUISAR. " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao PESQUISAR. " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEncerrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarPedidoActionPerformed
        // TODO add your handling code here:
        try {
            control.criarPedido(cli, jtaObservacoes.getText(), tblProdSelecionado);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao inserir novo Pedido no  banco. " + ex.getMessage());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERRO ao criar Pedido. " + ex.getMessage());
        }
       
        
    }//GEN-LAST:event_btnEncerrarPedidoActionPerformed

    private void mnuExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExcluirActionPerformed
        // TODO add your handling code here:
        int linh = tblProdSelecionado.getSelectedRow();
        ((DefaultTableModel) tblProdSelecionado.getModel()).removeRow(linh);
    }//GEN-LAST:event_mnuExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPedidoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPedidoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPedidoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPedidoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaPedidoDialog dialog = new JanelaPedidoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelItensVenda;
    private javax.swing.JButton btnEncerrarPedido;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jtaObservacoes;
    private javax.swing.JTextField jtfNomeCliente;
    private javax.swing.JMenuItem mnuExcluir;
    private javax.swing.JPopupMenu mnuPedido;
    private javax.swing.JTable tblProdSelecionado;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPesq;
    // End of variables declaration//GEN-END:variables
}
