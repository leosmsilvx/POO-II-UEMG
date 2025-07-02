package model;

import java.util.Date;

public class Venda {
    private Integer idvenda;
    private String cliente;
    private Date datavenda;
    private String pagamento;

    public Venda(Integer idvenda, String cliente, Date datavenda, String pagamento) {
        this.idvenda = idvenda;
        this.cliente = cliente;
        this.datavenda = datavenda;
        this.pagamento = pagamento;
    }

    public Venda(){

    }

    public Integer getIdvenda() {
        return idvenda;
    }
    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public Date getDatavenda() {
        return datavenda;
    }
    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }
    public String getPagamento() {
        return pagamento;
    }
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public java.sql.Date getSqlDataVenda() {
        return new java.sql.Date(datavenda.getTime());
    }

    @Override
    public String toString() {
        return cliente + "/" + datavenda.toString() + "/" + pagamento;
    }
}
