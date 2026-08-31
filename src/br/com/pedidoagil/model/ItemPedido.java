package br.com.pedidoagil.model;

import java.math.BigDecimal;

public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private String observacao;
    private BigDecimal preco;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.preco = produto.getPreco();
        this.observacao ="";

        alterarQuantidade(quantidade);


    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void alterarQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero");

        }
        this.quantidade = quantidade;
    }

    public void adicionarObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal calcularSubtotal() {
        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", observacao='" + observacao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
