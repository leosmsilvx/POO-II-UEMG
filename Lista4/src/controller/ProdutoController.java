package controller;

import model.Produto;
import java.util.ArrayList;
import util.Conexao;
import java.sql.*;

public class ProdutoController {

    public boolean insert(Produto produto) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO produto (descricao, estoque, valor, idfornecedor) " +
            "VALUES (?, ?, ?, ?)";
        
        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getEstoque());
            ps.setFloat(3, produto.getValor());
            ps.setInt(4, produto.getIdFornecedor());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    
    public boolean edit(Produto produto) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE produto SET descricao = ?, estoque = ?, valor = ?, idfornecedor = ? " +
            "WHERE idproduto = ?";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getEstoque());
            ps.setFloat(3, produto.getValor());
            ps.setInt(4, produto.getIdFornecedor());
            ps.setInt(5, produto.getIdProduto());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public boolean delete(Integer idProduto) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM produto " +
            "WHERE (idproduto = ?)";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idProduto);

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public Produto selectByIdProduto(Integer idProduto) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM produto " +
            "WHERE (idproduto = ?)";
            
        Produto retorno = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idProduto);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                retorno = new Produto();
                retorno.setIdProduto(result.getInt("idproduto"));
                retorno.setDescricao(result.getString("descricao"));
                retorno.setEstoque(result.getInt("estoque"));
                retorno.setValor(result.getFloat("valor"));
                retorno.setIdFornecedor(result.getInt("idfornecedor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao selecionar:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public ArrayList<Produto> selectAll() {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM produto ";

        ArrayList<Produto> retorno = new ArrayList<>();
        try {
            PreparedStatement sentenca = c.conector.prepareStatement(sql);

            ResultSet result = sentenca.executeQuery();

            while (result.next()) {
                Produto p = new Produto();
                p.setIdProduto(result.getInt("idproduto"));
                p.setDescricao(result.getString("descricao"));
                p.setEstoque(result.getInt("estoque"));
                p.setValor(result.getFloat("valor"));
                p.setIdFornecedor(result.getInt("idfornecedor"));
                retorno.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao seleciontar:" + e.getMessage());
        }
        c.desconectar();

        return retorno;
    }
}
