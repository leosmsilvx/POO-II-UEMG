package controller;

import model.Produto;
import java.util.ArrayList;
import util.Conexao;
import java.sql.*;
import model.Fornecedor;

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
            ps.setInt(4, produto.getFornecedor().getIdFornecedor());

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
            ps.setInt(4, produto.getFornecedor().getIdFornecedor());
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
        
        String sql = "SELECT * FROM produto p INNER JOIN fornecedor f WHERE p.idfornecedor = f.idfornecedor " +
            "AND p.idproduto = ?";
            
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
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(result.getInt("idfornecedor"));
                f.setCnpj(result.getString("cnpj"));
                f.setEndereco(result.getString("endereco"));
                f.setRazaoSocial(result.getString("razaosocial"));
                retorno.setFornecedor(f);
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
        
        String sql = "SELECT * FROM produto p INNER JOIN fornecedor f WHERE p.idfornecedor = f.idfornecedor";

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
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(result.getInt("idfornecedor"));
                f.setCnpj(result.getString("cnpj"));
                f.setEndereco(result.getString("endereco"));
                f.setRazaoSocial(result.getString("razaosocial"));
                p.setFornecedor(f);
                retorno.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao seleciontar:" + e.getMessage());
        }
        c.desconectar();

        return retorno;
    }
}
