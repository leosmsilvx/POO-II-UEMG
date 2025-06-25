package view;

import controller.FornecedorController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;

public class FornecedorView extends javax.swing.JInternalFrame {

    private Integer linha = -1;
    
    public FornecedorView() {
        initComponents();
        preencherTabela();
        inicializar();
    }

    @SuppressWarnings("unchecked")    
    private void preencherTabela(){
        FornecedorController controller = new FornecedorController();
        ArrayList<Fornecedor> lista = controller.selectAll();
        if (lista.isEmpty()) {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtFornecedores.getModel();
            modeloTabela.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Nenhum Fornecedor Cadastrado", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtFornecedores.getModel();
            modeloTabela.setRowCount(0);
            for (Fornecedor f: lista) {
                modeloTabela.addRow(new String[]{ 
                    String.valueOf(f.getIdFornecedor()),
                    f.getCnpj(),
                    f.getRazaoSocial(),
                    f.getEndereco()});
            }
        }
    }
    
    private void inicializar(){
        jtxCnpj.setEditable(false);
        jtxRazaoSocial.setEditable(false);
        jtxEndereco.setEditable(false);
        jbSalvar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbPesquisar.setEnabled(true);
        jbNovo.setEnabled(true);
        jtxId.setEditable(true);
    }
    
    private void limparCampos(){
        jtxId.setText("");
        jtxCnpj.setText("");
        jtxRazaoSocial.setText("");
        jtxEndereco.setText("");
    }
    
    private void preencheCampos(Fornecedor f){
        jtxId.setText(f.getIdFornecedor().toString());
        jtxCnpj.setText(f.getCnpj());
        jtxRazaoSocial.setText(f.getRazaoSocial());
        jtxEndereco.setText(f.getEndereco());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlId = new javax.swing.JLabel();
        jlCnpj = new javax.swing.JLabel();
        jlRazaoSocial = new javax.swing.JLabel();
        jlEndereco = new javax.swing.JLabel();
        jtxId = new javax.swing.JTextField();
        jtxCnpj = new javax.swing.JTextField();
        jtxRazaoSocial = new javax.swing.JTextField();
        jtxEndereco = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtFornecedores = new javax.swing.JTable();

        jlId.setText("Código:");

        jlCnpj.setText("CNPJ:");

        jlRazaoSocial.setText("Razão Social:");

        jlEndereco.setText("Endereço:");

        jtxId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxIdActionPerformed(evt);
            }
        });

        jbPesquisar.setText("Pesquisar");
        jbPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPesquisarActionPerformed(evt);
            }
        });

        jbNovo.setText("Novo");
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbFechar.setText("Fechar");
        jbFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFecharActionPerformed(evt);
            }
        });

        jtFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "CNPJ", "Razão Social", "Endereço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtFornecedores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlId)
                            .addComponent(jlRazaoSocial)
                            .addComponent(jlCnpj)
                            .addComponent(jlEndereco))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxId)
                            .addComponent(jtxCnpj)
                            .addComponent(jtxRazaoSocial)
                            .addComponent(jtxEndereco))
                        .addGap(18, 18, 18)
                        .addComponent(jbPesquisar)
                        .addGap(202, 202, 202))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jbNovo)
                        .addGap(18, 18, 18)
                        .addComponent(jbSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEditar)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jbFechar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlId)
                    .addComponent(jtxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCnpj)
                    .addComponent(jtxCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRazaoSocial)
                    .addComponent(jtxRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEndereco)
                    .addComponent(jtxEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNovo)
                    .addComponent(jbSalvar)
                    .addComponent(jbEditar)
                    .addComponent(jbExcluir)
                    .addComponent(jbFechar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxIdActionPerformed

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        Fornecedor fornecedor =  new Fornecedor();
        if(jtxId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o código do fornecedor.", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            fornecedor.setIdFornecedor(Integer.parseInt(jtxId.getText()));
            FornecedorController controller = new FornecedorController();
            fornecedor = controller.selectByIdFornecedor(fornecedor.getIdFornecedor());
            if (fornecedor == null) {
                JOptionPane.showMessageDialog(this, "Fornecedor não enconrado.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
            else {
                preencheCampos(fornecedor);
                jbNovo.setEnabled(false);
                jbSalvar.setEnabled(false);
                jbEditar.setEnabled(true);
                jbExcluir.setEnabled(true);
                jtxId.setEditable(false);
                jtxCnpj.setEditable(true);
                jtxRazaoSocial.setEditable(true);
                jtxEndereco.setEditable(true);
            }
        }
    }//GEN-LAST:event_jbPesquisarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        jbNovo.setEnabled(false);
        jbPesquisar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbSalvar.setEnabled(true);
        jtxId.setEditable(false);
        jtxCnpj.setEditable(true);
        jtxRazaoSocial.setEditable(true);
        jtxEndereco.setEditable(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        String cnpj = jtxCnpj.getText();
        String razaoSocial = jtxRazaoSocial.getText();
        String endereco = jtxEndereco.getText();
        if ((cnpj.isEmpty()) || (razaoSocial.isEmpty()) || (endereco.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
;           Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCnpj(cnpj);
            fornecedor.setEndereco(endereco);
            fornecedor.setRazaoSocial(razaoSocial);
            FornecedorController controller = new FornecedorController();
            if (controller.insert(fornecedor)) {
                JOptionPane.showMessageDialog(this, "Fornecedor Inserido com Sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir fornecedor!", "Retorno Tabela", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int id = Integer.parseInt(jtxId.getText());
        String cnpj = jtxCnpj.getText();
        String razaoSocial = jtxRazaoSocial.getText();
        String endereco = jtxEndereco.getText();
        if ((cnpj.isEmpty()) || (razaoSocial.isEmpty()) || (endereco.isEmpty())) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setIdFornecedor(id);
            fornecedor.setCnpj(cnpj);
            fornecedor.setEndereco(endereco);
            fornecedor.setRazaoSocial(razaoSocial);
            FornecedorController controller = new FornecedorController();
            if(controller.edit(fornecedor)) {
                JOptionPane.showMessageDialog(this, "Atualizado com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao editar fornecedor.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Fornecedor fornecedor = new Fornecedor();
        if(jtxId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o código do fornecedor.", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            fornecedor.setIdFornecedor(Integer.parseInt(jtxId.getText()));
            FornecedorController controller = new FornecedorController();
            if (controller.delete(fornecedor.getIdFornecedor())) {
                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir fornecedor.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtFornecedoresMouseClicked
        linha  = jtFornecedores.getSelectedRow();
        if (linha != -1) {
            jtxId.setText(jtFornecedores.getValueAt(linha, 0).toString());
            jtxCnpj.setText(jtFornecedores.getValueAt(linha, 1).toString());
            jtxRazaoSocial.setText(jtFornecedores.getValueAt(linha, 2).toString());
            jtxEndereco.setText(jtFornecedores.getValueAt(linha, 3).toString());
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);
            jtxId.setEditable(false);
            jtxCnpj.setEditable(true);
            jtxRazaoSocial.setEditable(true);
            jtxEndereco.setEditable(true);
            linha = -1;
        }
    }//GEN-LAST:event_jtFornecedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JLabel jlCnpj;
    private javax.swing.JLabel jlEndereco;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlRazaoSocial;
    private javax.swing.JTable jtFornecedores;
    private javax.swing.JTextField jtxCnpj;
    private javax.swing.JTextField jtxEndereco;
    private javax.swing.JTextField jtxId;
    private javax.swing.JTextField jtxRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
