package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Fornecedor;
import model.ItemVenda;
import model.Produto;
import model.Venda;
import util.Conexao;

public class ItemVendaController {
    
    public boolean insert(ItemVenda itemvenda) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO itemvenda (idvenda, idproduto, quantidade) " +
            "VALUES (?, ?, ?)";
        
        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, itemvenda.getVenda().getIdvenda());
            ps.setInt(2, itemvenda.getProduto().getIdProduto());
            ps.setInt(3, itemvenda.getQuantidade());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public boolean edit(ItemVenda itemvenda) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE produto SET idvenda = ?, idproduto = ?, quantidade = ? " +
            "WHERE iditemvenda = ?";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, itemvenda.getVenda().getIdvenda());
            ps.setInt(2, itemvenda.getProduto().getIdProduto());
            ps.setInt(3, itemvenda.getQuantidade());
            ps.setInt(4, itemvenda.getIditemvenda());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public boolean delete(Integer iditemvenda) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM itemvenda " +
            "WHERE (iditemvenda = ?)";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, iditemvenda);

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public ItemVenda selectByIdItemVenda(Integer idvenda) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM itemvenda i INNER JOIN venda v INNER JOIN produto p INNER JOIN fornecedor f " +
            "WHERE i.idvenda = v.idvenda AND i.idproduto = p.idproduto AND p.idfornecedor = f.idfornecedor " +
            "AND (iditemvenda = ?)";

        ItemVenda retorno = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idvenda);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                Produto p = new Produto();
                p.setIdProduto(result.getInt("idproduto"));
                p.setDescricao(result.getString("descricao"));
                p.setEstoque(result.getInt("estoque"));
                p.setValor(result.getFloat("valor"));
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(result.getInt("idfornecedor"));
                f.setCnpj(result.getString("cnpj"));
                f.setEndereco(result.getString("endereco"));
                f.setRazaoSocial(result.getString("razaosocial"));
                p.setFornecedor(f);

                Venda v = new Venda();
                v.setIdvenda(result.getInt("idvenda"));
                v.setCliente(result.getString("cliente"));
                v.setDatavenda(result.getDate("datavenda"));
                v.setPagamento(result.getString("pagamento"));

                retorno = new ItemVenda();
                retorno.setIditemvenda(result.getInt("iditemvenda"));
                retorno.setVenda(v);
                retorno.setProduto(p);
                retorno.setQuantidade(result.getInt("quantidade"));
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public ArrayList<ItemVenda> selectAll(){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM itemvenda i INNER JOIN venda v INNER JOIN produto p INNER JOIN fornecedor f " +
            "WHERE i.idvenda = v.idvenda AND i.idproduto = p.idproduto AND p.idfornecedor = f.idfornecedor";

        ArrayList<ItemVenda> retorno = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Produto p = new Produto();
                p.setIdProduto(result.getInt("idproduto"));
                p.setDescricao(result.getString("descricao"));
                p.setEstoque(result.getInt("estoque"));
                p.setValor(result.getFloat("valor"));
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(result.getInt("idfornecedor"));
                f.setCnpj(result.getString("cnpj"));
                f.setEndereco(result.getString("endereco"));
                f.setRazaoSocial(result.getString("razaosocial"));
                p.setFornecedor(f);

                Venda v = new Venda();
                v.setIdvenda(result.getInt("idvenda"));
                v.setCliente(result.getString("cliente"));
                v.setDatavenda(result.getDate("datavenda"));
                v.setPagamento(result.getString("pagamento"));

                ItemVenda iv = new ItemVenda();
                iv.setVenda(v);
                iv.setProduto(p);
                iv.setIditemvenda(result.getInt("iditemvenda"));
                iv.setQuantidade(result.getInt("quantidade"));
                retorno.add(iv);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
