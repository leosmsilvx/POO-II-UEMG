package model;

public class Produto {

    private Integer idProduto;
    private Integer estoque;
    private Integer idFornecedor;
    private Float valor;
    private String descricao;

    public Produto(Integer idProduto, Integer estoque, Integer idFornecedor, Float valor, String descricao) {
        this.idProduto = idProduto;
        this.estoque = estoque;
        this.idFornecedor = idFornecedor;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Produto() {
        this.idProduto = 0;
        this.estoque = 0;
        this.idFornecedor = 0;
        this.valor = 0.0f;
        this.descricao = "";
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

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
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

}
