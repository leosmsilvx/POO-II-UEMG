package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Venda;
import util.Conexao;

public class VendaController {
    
    public Integer insert(Venda venda) {
        Conexao c = new Conexao();
        c.conectar();
    
        String sql = "INSERT INTO venda (cliente, datavenda, pagamento) VALUES (?, ?, ?)";
    
        Integer idGerado = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    
            ps.setString(1, venda.getCliente());
            ps.setDate(2, venda.getSqlDataVenda());
            ps.setString(3, venda.getPagamento());
    
            int affectedRows = ps.executeUpdate();
    
            if (affectedRows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idGerado = rs.getInt(1);
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        } finally {
            c.desconectar();
        }
    
        return idGerado;
    }
    

    public boolean edit(Venda venda){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "UPDATE venda SET cliente = ?, datavenda = ?, pagamento = ? " +
            "WHERE idvenda = ?";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setString(1, venda.getCliente());
            ps.setDate(2, venda.getSqlDataVenda());
            ps.setString(3, venda.getPagamento());
            ps.setInt(4, venda.getIdvenda());

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao editar:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public boolean delete(Integer idvenda) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "DELETE FROM venda " +
            "WHERE (idvenda = ?)";

        boolean retorno = false;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idvenda);

            if (!ps.execute())
                retorno = true;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public Venda selectByIdFornecedor(Integer idvenda) {
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM venda " +
            "WHERE (idvenda = ?)";

        Venda retorno = null;
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ps.setInt(1, idvenda);

            ResultSet result = ps.executeQuery();
            if (result.next()) {
                retorno = new Venda();
                retorno.setIdvenda(result.getInt("idvenda"));
                retorno.setCliente(result.getString("cliente"));
                retorno.setDatavenda(result.getDate("datavenda"));
                retorno.setPagamento(result.getString("pagamento"));
                
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }

    public ArrayList<Venda> selectAll(){
        Conexao c = new Conexao();
        c.conectar();
        
        String sql = "SELECT * FROM venda ";

        ArrayList<Venda> retorno = new ArrayList<>();
        try {
            PreparedStatement ps = c.conector.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                Venda f = new Venda();
                f.setIdvenda(result.getInt("idvenda"));
                f.setCliente(result.getString("cliente"));
                f.setDatavenda(result.getDate("datavenda"));
                f.setPagamento(result.getString("pagamento"));
                retorno.add(f);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir:" + e.getMessage());
        }
        c.desconectar();
        return retorno;
    }
}
