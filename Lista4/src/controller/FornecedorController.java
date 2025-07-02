package controller;

import model.Fornecedor;
import java.util.ArrayList;
import util.Conexao;
import java.sql.*;

public class FornecedorController {

    public boolean insert(Fornecedor fornecedor){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "INSERT INTO fornecedor (cnpj, razaosocial, endereco) " +
            "VALUES (?, ?, ?)";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, fornecedor.getCnpj());
            ps.setString(2, fornecedor.getRazaoSocial());
            ps.setString(3, fornecedor.getEndereco());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public boolean edit(Fornecedor fornecedor){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE fornecedor SET cnpj = ?, razaosocial = ?, endereco = ? " +
            "WHERE idfornecedor = ?";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, fornecedor.getCnpj());
            ps.setString(2, fornecedor.getRazaoSocial());
            ps.setString(3, fornecedor.getEndereco());
            ps.setInt(4, fornecedor.getIdFornecedor());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public boolean delete(Integer idFornecedor) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM fornecedor " +
            "WHERE (idfornecedor = ?)";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idFornecedor);

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public Fornecedor selectByIdFornecedor(Integer idFornecedor) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM fornecedor " +
            "WHERE (idfornecedor = ?)";

        Fornecedor retorno = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idFornecedor);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                retorno = new Fornecedor();
                retorno.setIdFornecedor(result.getInt("idfornecedor"));
                retorno.setCnpj(result.getString("cnpj"));
                retorno.setRazaoSocial(result.getString("razaosocial"));
                retorno.setEndereco(result.getString("endereco"));
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
    
    public ArrayList<Fornecedor> selectAll(){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM fornecedor ";

        ArrayList<Fornecedor> retorno = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(result.getInt("idfornecedor"));
                f.setCnpj(result.getString("cnpj"));
                f.setRazaoSocial(result.getString("razaosocial"));
                f.setEndereco(result.getString("endereco"));
                retorno.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
