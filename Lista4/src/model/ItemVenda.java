package model;

public class ItemVenda {
    private Integer iditemvenda;
    private Venda venda;
    private Produto produto;
    private Integer quantidade;
    
    public ItemVenda(Integer iditemvenda, Venda venda, Produto produto, Integer quantidade) {
        this.iditemvenda = iditemvenda;
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public ItemVenda() {
    }

    public Integer getIditemvenda() {
        return iditemvenda;
    }
    public void setIditemvenda(Integer iditemvenda) {
        this.iditemvenda = iditemvenda;
    }
    public Venda getVenda() {
        return venda;
    }
    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
