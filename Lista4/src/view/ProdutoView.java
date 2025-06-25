package view;

import controller.FornecedorController;
import controller.ProdutoController;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;
import model.Produto;

public class ProdutoView extends javax.swing.JInternalFrame {

    private Integer linha = -1;
    
    private ArrayList<Fornecedor> listaFornecedores;
    
    public ProdutoView() {
        initComponents();
        preencherComboFornecedores();
        preencherTabela();
        inicializar();
    }

    @SuppressWarnings("unchecked")    
    private void preencherTabela(){
        ProdutoController controller = new ProdutoController();
        ArrayList<Produto> lista = controller.selectAll();
        if (lista.isEmpty()) {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtProdutos.getModel();
            modeloTabela.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Nenhum produto Cadastrado", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtProdutos.getModel();
            modeloTabela.setRowCount(0);
            
            for (Produto p: lista) {
                Fornecedor resultado = listaFornecedores.stream()
                    .filter(obj -> obj.getIdFornecedor() == p.getIdFornecedor())
                    .findFirst().orElse(null);
                if(resultado == null){
                    continue;
                }
                modeloTabela.addRow(new String[]{ 
                    String.valueOf(p.getIdProduto()),
                        p.getDescricao(),
                        p.getValor().toString(),
                        p.getEstoque().toString(),
                        resultado.toString()
                });
            }
        }
    }
    
    private void preencherComboFornecedores(){
        FornecedorController controller = new FornecedorController();
        listaFornecedores = controller.selectAll();
        listaFornecedores.forEach(f -> {
            jcbFornecedor.addItem(f);
        });
    }
    
    private void inicializar(){
        jtxDescricao.setEditable(false);
        jtxValor.setEditable(false);
        jtxEstoque.setEditable(false);
        jbSalvar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbNovo.setEnabled(true);        
        jbPesquisar.setEnabled(true);
        jtxId.setEditable(true);
        jcbFornecedor.setEnabled(false);
    }
    
    private void limparCampos(){
        jtxId.setText("");
        jtxDescricao.setText("");
        jtxValor.setText("");
        jtxEstoque.setText("");
        jcbFornecedor.setSelectedItem(null);
    }
    
    private void preencherCampos(Produto p){
        jtxId.setText(p.getIdProduto().toString());
        jtxDescricao.setText(p.getDescricao());
        jtxValor.setText(p.getValor().toString());
        jtxEstoque.setText(p.getEstoque().toString());
        jcbFornecedor.setSelectedItem(buscaFornecedorListaPorId(p.getIdFornecedor()));
    }
    
    private Fornecedor buscaFornecedorListaPorId(Integer idFornecedor){
        for(Fornecedor f : listaFornecedores){
            if(f.getIdFornecedor() == idFornecedor){
                return f;
            }
        }
        return null;
    }
    
    private Fornecedor buscaFornecedorListaPorCnpj(String cnpj){
        for(Fornecedor f : listaFornecedores){
            if(f.getCnpj().equals(cnpj)){
                return f;
            }
        }
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlId = new javax.swing.JLabel();
        jlDescricao = new javax.swing.JLabel();
        jlValor = new javax.swing.JLabel();
        jlEstoque = new javax.swing.JLabel();
        jtxId = new javax.swing.JTextField();
        jtxDescricao = new javax.swing.JTextField();
        jtxValor = new javax.swing.JTextField();
        jtxEstoque = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProdutos = new javax.swing.JTable();
        jcbFornecedor = new javax.swing.JComboBox<Fornecedor>();

        jlId.setText("Código:");

        jlDescricao.setText("Descrição:");

        jlValor.setText("Valor:");

        jlEstoque.setText("Estoque:");

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

        jtProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Valor", "Estoque", "Fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProdutos);

        jcbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFornecedorActionPerformed(evt);
            }
        });

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
                            .addComponent(jlValor)
                            .addComponent(jlDescricao)
                            .addComponent(jlEstoque))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxId)
                            .addComponent(jtxDescricao)
                            .addComponent(jtxValor)
                            .addComponent(jtxEstoque))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbPesquisar)
                            .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))
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
                    .addComponent(jlDescricao)
                    .addComponent(jtxDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlValor)
                    .addComponent(jtxValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEstoque)
                    .addComponent(jtxEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        Produto prod =  new Produto();
        if(jtxId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o código do produto.", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            prod.setIdProduto(Integer.parseInt(jtxId.getText()));
            
            ProdutoController controller = new ProdutoController();
            prod = controller.selectByIdProduto(prod.getIdProduto());
            
            if (prod == null) {
                JOptionPane.showMessageDialog(this, "Produto não enconrado.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
            else {
                preencherCampos(prod);
                jbNovo.setEnabled(false);
                jbSalvar.setEnabled(false);
                jbEditar.setEnabled(true);
                jbExcluir.setEnabled(true);
                jtxId.setEditable(false);
                jtxDescricao.setEditable(true);
                jtxValor.setEditable(true);
                jtxEstoque.setEditable(true);
                jcbFornecedor.setEditable(true);
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
        jtxDescricao.setEditable(true);
        jtxValor.setEditable(true);
        jtxEstoque.setEditable(true);
        jcbFornecedor.setEnabled(true);
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        String descricao = jtxDescricao.getText();
        String valor = jtxValor.getText();
        String estoque = jtxEstoque.getText();
        Fornecedor fornecedor = (Fornecedor) jcbFornecedor.getSelectedItem();
        if ((descricao.isEmpty()) || (valor.isEmpty()) || (estoque.isEmpty()) || fornecedor == null) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
;           Produto prod = new Produto();
            prod.setDescricao(descricao);
            prod.setValor(Float.parseFloat(valor));
            prod.setEstoque(Integer.parseInt(estoque));
            prod.setIdFornecedor(fornecedor.getIdFornecedor());
            ProdutoController controller = new ProdutoController();
            if (controller.insert(prod)) {
                JOptionPane.showMessageDialog(this, "Produto Inserido com Sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir produto!", "Retorno Tabela", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int id = Integer.parseInt(jtxId.getText());
        String descricao = jtxDescricao.getText();
        String valor = jtxValor.getText();
        String estoque = jtxEstoque.getText();
        Fornecedor fornecedor = (Fornecedor) jcbFornecedor.getSelectedItem();
        if ((descricao.isEmpty()) || (valor.isEmpty()) || (estoque.isEmpty()) || fornecedor == null) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Produto prod = new Produto();
            prod.setIdProduto(id);
            prod.setDescricao(descricao);
            prod.setValor(Float.parseFloat(valor));
            prod.setEstoque(Integer.parseInt(estoque));
            prod.setIdFornecedor(fornecedor.getIdFornecedor());
            ProdutoController controller = new ProdutoController();
            if(controller.edit(prod)) {
                JOptionPane.showMessageDialog(this, "Atualizado com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao editar produto.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        Produto prod = new Produto();
        if(jtxId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o código do produto.", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            ProdutoController controller = new ProdutoController();
            if (controller.delete(Integer.parseInt(jtxId.getText()))) {
                JOptionPane.showMessageDialog(this, "Excluido com sucesso!");
                limparCampos();
                inicializar();
                preencherTabela();
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao excluir produto.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jbFecharActionPerformed

    private void jtProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProdutosMouseClicked
        linha  = jtProdutos.getSelectedRow();
        if (linha != -1) {
            jtxId.setText(jtProdutos.getValueAt(linha, 0).toString());
            jtxDescricao.setText(jtProdutos.getValueAt(linha, 1).toString());
            jtxValor.setText(jtProdutos.getValueAt(linha, 2).toString());
            jtxEstoque.setText(jtProdutos.getValueAt(linha, 3).toString());
            String cnpj = jtProdutos.getValueAt(linha, 4).toString().split("/")[0];
            jcbFornecedor.setSelectedItem(buscaFornecedorListaPorCnpj(cnpj));
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);
            jtxId.setEditable(false);
            jtxDescricao.setEditable(true);
            jtxValor.setEditable(true);
            jtxEstoque.setEditable(true);
            jcbFornecedor.setEnabled(true);
            linha = -1;
        }
    }//GEN-LAST:event_jtProdutosMouseClicked

    private void jcbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbFornecedorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<Fornecedor> jcbFornecedor;
    private javax.swing.JLabel jlDescricao;
    private javax.swing.JLabel jlEstoque;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlValor;
    private javax.swing.JTable jtProdutos;
    private javax.swing.JTextField jtxDescricao;
    private javax.swing.JTextField jtxEstoque;
    private javax.swing.JTextField jtxId;
    private javax.swing.JTextField jtxValor;
    // End of variables declaration//GEN-END:variables
}
