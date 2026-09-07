package br.com.pedidoagil.model;

import br.com.pedidoagil.enums.FormaPagamento;
import br.com.pedidoagil.enums.StatusPedido;
import br.com.pedidoagil.enums.TipoAtendimento;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private StatusPedido status;
    private TipoAtendimento tipoAtendimento;
    private FormaPagamento formaPagamento;
    private LocalDateTime dataHoraCriacao;

    public Pedido(Long id, Cliente cliente, TipoAtendimento tipoAtendimento, FormaPagamento formaPagamento) {
        this.id = id;
        this.cliente = cliente;
        this.tipoAtendimento = tipoAtendimento;
        this.formaPagamento = formaPagamento;

        this.itens = new ArrayList<>();
        this.status = StatusPedido.ABERTO;
        this.dataHoraCriacao = LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        verficarSePodeAlterar();

        if (!produto.isDisponivel()) {
            throw new IllegalArgumentException("O produto está disponível");
        }
ItemPedido item = new ItemPedido(produto, quantidade);
        itens.add(item);
    }

    public void removerProduto(Long produtoId) {
        verficarSePodeAlterar();
        ItemPedido item = buscarItemPorProduto(produtoId);
        itens.remove(item);
    }

    public void alterarQuantidade(Long produtoId, int novaQuantidade) {
        verficarSePodeAlterar();

        ItemPedido item = buscarItemPorProduto(produtoId);
        item.alterarQuantidade(novaQuantidade);
    }

    public void adicionarObservcao(Long  produtoId, String observacao) {
        verficarSePodeAlterar();
        ItemPedido item = buscarItemPorProduto(produtoId);
        item.adicionarObservacao(observacao);
    }


    private ItemPedido buscarItemPorProduto(Long produtoId) {
        for (ItemPedido item : itens) {

            if (item.getProduto().getId().equals(produtoId)) {
                return item;
            }
        }

        throw new IllegalArgumentException(
                "Produto não encontrado no pedido"
        );
    }

    public BigDecimal calcularTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemPedido item : itens) {
            total = total.add(item.calcularSubtotal());
        }
        return total;

    }

    public void confirmar(){
        if (status != StatusPedido.ABERTO) {
            throw new IllegalStateException("Somente pedidos abertos podem ser confirmados");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Não é possível confirmar um pedido vazio ");

        }
        this.status = StatusPedido.CONFIRMADO;
    }

    public void iniciarPreparo(){
        if (status != StatusPedido.CONFIRMADO) {
            throw new IllegalStateException("Somente pedidos confirmados podem iniciar o preparo");
        }
        this.status = StatusPedido.EM_PREPARO;
    }

    public void marcarComoPronto(){
        if (status != StatusPedido.EM_PREPARO) {
            throw new IllegalStateException("Somente pedidos em preparo podem ficar prontos");
        }
        this.status = StatusPedido.PRONTO;
    }

    public void finalizado(){
        if (status != StatusPedido.PRONTO) {
            throw new IllegalStateException("Somente pedidos prontos podem ser finalizados");
        }
        this.status = StatusPedido.FINALIZADO;
    }



    private void verficarSePodeAlterar() {
        if (status != StatusPedido.ABERTO
                && status != StatusPedido.CONFIRMADO) {

            throw new IllegalStateException(
                    "O pedido não pode mais ser alterado"
            );
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", itens=" + itens +
                ", status=" + status +
                ", tipoAtendimento=" + tipoAtendimento +
                ", formaPagamento=" + formaPagamento +
                ", dataHoraCriacao=" + dataHoraCriacao +
                ", total=" + calcularTotal() +
                '}';
    }
}