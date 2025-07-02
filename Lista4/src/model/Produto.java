package model;

public class Produto {

    private Integer idProduto;
    private Integer estoque;
    private Fornecedor fornecedor;
    private Float valor;
    private String descricao;

    public Produto(Integer idProduto, Integer estoque, Fornecedor fornecedor, Float valor, String descricao) {
        this.idProduto = idProduto;
        this.estoque = estoque;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Produto() {
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao + "/" + estoque + "x/R$" + valor;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Produto other = (Produto) obj;
        return this.idProduto.equals(other.getIdProduto());
    }

}
