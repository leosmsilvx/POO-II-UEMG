package model;

public class Fornecedor {
    private Integer idFornecedor;
    private String cnpj;
    private String razaoSocial;
    private String endereco;

    public Fornecedor(Integer idFornecedor, String cnpj, String razaoSocial, String endereco) {
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public Fornecedor() {
        this.idFornecedor = 0;
        this.cnpj = "";
        this.razaoSocial = "";
        this.endereco = "";
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return cnpj + "/" + razaoSocial;
    }
}
