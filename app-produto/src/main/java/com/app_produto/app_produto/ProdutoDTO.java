package com.app_produto.app_produto;

public class ProdutoDTO {
    private String cod;
    private String descricao;
    private Integer quantidade;
    private Double preco;

    // Getters e Setters são fundamentais para o Spring preencher o objeto
    public String getCod() { return cod; }
    public void setCod(String cod) { this.cod = cod; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Produto [cod=" + cod + ", descricao=" + descricao + 
               ", quantidade=" + quantidade + ", preco=" + preco + "]";
    }
}
