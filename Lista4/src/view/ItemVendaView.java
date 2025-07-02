package view;

import controller.ProdutoController;
import controller.VendaController;
import controller.ItemVendaController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Fornecedor;
import model.Produto;
import model.Venda;
import util.DataConverter;
import model.ItemVenda;

public class ItemVendaView extends javax.swing.JInternalFrame {

    private Integer linha = -1;
        
    public ItemVendaView() {
        initComponents();
        preencherComboProdutos();
        preencherTabela();
        inicializar();
    }

    @SuppressWarnings("unchecked")    
    private void preencherTabela(){
        ItemVendaController controller = new ItemVendaController();
        ArrayList<ItemVenda> lista = controller.selectAll();
        if (lista.isEmpty()) {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtItemVenda.getModel();
            modeloTabela.setRowCount(0);
            JOptionPane.showMessageDialog(this, "Nenhuma Venda Cadastrada", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            DefaultTableModel modeloTabela = (DefaultTableModel) jtItemVenda.getModel();
            modeloTabela.setRowCount(0);
            
            for (ItemVenda iv: lista) {
                modeloTabela.addRow(new Object[]{ 
                        iv.getIditemvenda(),
                        iv.getVenda(),
                        iv.getProduto(),
                        iv.getQuantidade()
                });
            }
        }
    }
    
    private void preencherComboProdutos(){
        ProdutoController controller = new ProdutoController();
        ArrayList<Produto> listaProdutos = controller.selectAll();
        listaProdutos.forEach(p -> {
            jcbProduto.addItem(p);
        });
    }
    
    private void inicializar(){
        jtxCliente.setEditable(false);
        jtxDtVenda.setEditable(false);
        jtxQuantidade.setEditable(false);
        jtxPagamento.setEditable(false);
        jbSalvar.setEnabled(false);
        jbEditar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbNovo.setEnabled(true);        
        jbPesquisar.setEnabled(true);
        jtxId.setEditable(true);
        jcbProduto.setEnabled(false);
    }
    
    private void limparCampos(){
        jtxId.setText("");
        jtxCliente.setText("");
        jtxDtVenda.setText("");
        jtxQuantidade.setText("");
        jtxPagamento.setText("");
        jcbProduto.setSelectedItem(null);
    }
    
    private void preencherCampos(ItemVenda iv){
        jtxId.setText(iv.getIditemvenda().toString());
        jtxCliente.setText(iv.getVenda().getCliente());
        jtxPagamento.setText(iv.getVenda().getPagamento());
        String strDtVenda = DataConverter.converterParaString(iv.getVenda().getDatavenda());
        jtxDtVenda.setText(strDtVenda);
        jtxQuantidade.setText(iv.getQuantidade().toString());
        jcbProduto.setSelectedItem(iv.getProduto());
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlId = new javax.swing.JLabel();
        jlCliente = new javax.swing.JLabel();
        jlDtVenda = new javax.swing.JLabel();
        jlQuantidade = new javax.swing.JLabel();
        jtxCliente = new javax.swing.JTextField();
        jbPesquisar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtItemVenda = new javax.swing.JTable();
        jcbProduto = new javax.swing.JComboBox<Produto>();
        jtxDtVenda = new javax.swing.JFormattedTextField();
        jtxQuantidade = new javax.swing.JFormattedTextField();
        jtxId = new javax.swing.JFormattedTextField();
        jtxPagamento = new javax.swing.JTextField();
        jlPagamento = new javax.swing.JLabel();
        jlProduto = new javax.swing.JLabel();

        jlId.setText("Código:");

        jlCliente.setText("Cliente:");

        jlDtVenda.setText("Data venda:");

        jlQuantidade.setText("Quantidade:");

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

        jtItemVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Venda", "Produto", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtItemVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtItemVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtItemVenda);

        jcbProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProdutoActionPerformed(evt);
            }
        });

        jtxDtVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        jtxQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jtxId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jlPagamento.setText("Pagamento:");

        jlProduto.setText("Produto:");

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
                            .addComponent(jlDtVenda)
                            .addComponent(jlCliente)
                            .addComponent(jlQuantidade))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxCliente)
                            .addComponent(jtxDtVenda)
                            .addComponent(jtxQuantidade)
                            .addComponent(jtxId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbPesquisar)
                                .addGap(202, 202, 202))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlPagamento)
                                    .addComponent(jlProduto))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jtxPagamento))
                                .addContainerGap())))
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
                    .addComponent(jbPesquisar)
                    .addComponent(jtxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCliente)
                    .addComponent(jtxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlPagamento)
                        .addComponent(jtxPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlDtVenda)
                        .addComponent(jtxDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlQuantidade)
                    .addComponent(jtxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jbPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPesquisarActionPerformed
        ItemVenda itemvenda =  new ItemVenda();
        if(jtxId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o código do produto.", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            itemvenda.setIditemvenda(Integer.parseInt(jtxId.getText()));
            
            ItemVendaController controller = new ItemVendaController();
            itemvenda = controller.selectByIdItemVenda(itemvenda.getIditemvenda());
            
            if (itemvenda == null) {
                JOptionPane.showMessageDialog(this, "Venda não encontrada.", "Retorno BD", JOptionPane.ERROR_MESSAGE);
            }
            else {
                preencherCampos(itemvenda);
                jbNovo.setEnabled(false);
                jbSalvar.setEnabled(false);
                jbEditar.setEnabled(true);
                jbExcluir.setEnabled(true);
                jtxId.setEditable(false);
                jtxCliente.setEditable(true);
                jtxDtVenda.setEditable(true);
                jtxQuantidade.setEditable(true);
                jcbProduto.setEnabled(true);
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
        jtxCliente.setEditable(true);
        jtxDtVenda.setEditable(true);
        jtxQuantidade.setEditable(true);
        jcbProduto.setEnabled(true);
        jtxPagamento.setEditable(true);
        jtxId.setValue("");
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        String cliente = jtxCliente.getText();
        String strDtVenda = jtxDtVenda.getText();
        String quantidade = jtxQuantidade.getText();
        String pagamento = jtxPagamento.getText();
        Produto produto = (Produto) jcbProduto.getSelectedItem();
        if ((cliente.isEmpty()) || (strDtVenda.isEmpty()) || (quantidade.isEmpty()) || (pagamento.isEmpty()) || produto == null) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Venda venda = new Venda();
            venda.setCliente(cliente);
            venda.setDatavenda(DataConverter.converterParaSqlDate(strDtVenda));
            venda.setPagamento(pagamento);            

            VendaController controllerVenda = new VendaController();
            Integer idVenda = controllerVenda.insert(venda);
            if (idVenda != null) {
                ItemVendaController controller = new ItemVendaController();
                ItemVenda itemVenda = new ItemVenda();
                venda.setIdvenda(idVenda);
                itemVenda.setVenda(venda);
                itemVenda.setProduto(produto);
                itemVenda.setQuantidade(Integer.parseInt(quantidade));
                if (controller.insert(itemVenda)) {
                    JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
                    limparCampos();
                    inicializar();
                    preencherTabela();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir item de venda!", "Retorno Tabela", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir venda!", "Retorno Tabela", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int id = Integer.parseInt(jtxId.getText());
        String cliente = jtxCliente.getText();
        String strDtVenda = jtxDtVenda.getText();
        String quantidade = jtxQuantidade.getText();
        String pagamento = jtxPagamento.getText();
        Produto produto = (Produto) jcbProduto.getSelectedItem();
        if ((cliente.isEmpty()) || (strDtVenda.isEmpty()) || (quantidade.isEmpty()) || (pagamento.isEmpty()) || produto == null) {
            JOptionPane.showMessageDialog(this, "Digite todos os campos", "Retorno Tela", JOptionPane.ERROR_MESSAGE);
        }
        else {
            Venda venda = new Venda();
            venda.setCliente(cliente);
            venda.setDatavenda(DataConverter.converterParaSqlDate(strDtVenda));
            venda.setPagamento(pagamento);
            VendaController controllerVenda = new VendaController();
            if (controllerVenda.edit(venda)) {
                ItemVendaController controller = new ItemVendaController();
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setIditemvenda(id);
                itemVenda.setVenda(venda);
                itemVenda.setProduto(produto);
                itemVenda.setQuantidade(Integer.parseInt(quantidade));
                if (controller.edit(itemVenda)) {
                    JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
                    limparCampos();
                    inicializar();
                    preencherTabela();
                }
                else {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir item de venda!", "Retorno Tabela", JOptionPane.ERROR_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Erro ao inserir venda!", "Retorno Tabela", JOptionPane.ERROR_MESSAGE);
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

    private void jtItemVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtItemVendaMouseClicked
        linha  = jtItemVenda.getSelectedRow();
        if (linha != -1) {
            jtxId.setText(jtItemVenda.getValueAt(linha, 0).toString());
            jtxCliente.setText(jtItemVenda.getValueAt(linha, 1).toString());
            jtxDtVenda.setText(jtItemVenda.getValueAt(linha, 2).toString());
            jtxQuantidade.setText(jtItemVenda.getValueAt(linha, 3).toString());
            Fornecedor f = (Fornecedor) jtItemVenda.getValueAt(linha, 4);
            jcbProduto.setSelectedItem(f);
            jbNovo.setEnabled(false);
            jbSalvar.setEnabled(false);
            jbEditar.setEnabled(true);
            jbExcluir.setEnabled(true);
            jtxId.setEditable(false);
            jtxCliente.setEditable(true);
            jtxDtVenda.setEditable(true);
            jtxQuantidade.setEditable(true);
            jcbProduto.setEnabled(true);
            linha = -1;
        }
    }//GEN-LAST:event_jtItemVendaMouseClicked

    private void jcbProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbPesquisar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox<Produto> jcbProduto;
    private javax.swing.JLabel jlCliente;
    private javax.swing.JLabel jlDtVenda;
    private javax.swing.JLabel jlId;
    private javax.swing.JLabel jlPagamento;
    private javax.swing.JLabel jlProduto;
    private javax.swing.JLabel jlQuantidade;
    private javax.swing.JTable jtItemVenda;
    private javax.swing.JTextField jtxCliente;
    private javax.swing.JFormattedTextField jtxDtVenda;
    private javax.swing.JFormattedTextField jtxId;
    private javax.swing.JTextField jtxPagamento;
    private javax.swing.JFormattedTextField jtxQuantidade;
    // End of variables declaration//GEN-END:variables
}
