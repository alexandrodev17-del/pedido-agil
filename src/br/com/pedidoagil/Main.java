package br.com.pedidoagil;

import br.com.pedidoagil.model.Categoria;
import br.com.pedidoagil.model.Cliente;
import br.com.pedidoagil.model.ItemPedido;
import br.com.pedidoagil.model.Produto;
import br.com.pedidoagil.enums.FormaPagamento;
import br.com.pedidoagil.enums.TipoAtendimento;
import br.com.pedidoagil.model.Pedido;

import java.math.BigDecimal;


public  class Main {
    public static void main(String[] args) {

        Categoria categoria = new Categoria(1L, "Hamburguer");

        System.out.println(categoria);

        categoria.indisponibilizar();
        System.out.println(categoria);

        categoria.disponibilizar();
        System.out.println(categoria);

        categoria.setNome("Hambúrgueres artesanais");
        System.out.println(categoria);

        Categoria categoriaHamburguer = new Categoria(1L, "Hamburguer");

        Produto produto = new Produto(1L, "x-burger", "Hamburguer com carne e queijo", new BigDecimal("20.00"), categoriaHamburguer);
        System.out.println(produto);

        produto.indisponibilizar();
        System.out.println(produto);

        produto.disponibilizar();
        System.out.println(produto);

        produto.setNome("x-burguer");
        System.out.println(produto);

        Categoria categoriaCombos = new Categoria(2L, "Combos");

        produto.setCategoria(categoriaCombos);
        System.out.println(produto);

        produto.setDescricao("Hamburguer com carne e queijo");
        System.out.println(produto);

        produto.setPreco(new BigDecimal("24.90"));
        System.out.println(produto);

        Cliente cliente = new Cliente(1L, "alexandro", "2199999999");{
            System.out.println(cliente);

            cliente.setNome("alexandro");
            System.out.println(cliente);

            cliente.setTelefone("2199999999");
            System.out.println(cliente);
        }

        ItemPedido item = new ItemPedido(
                produto,
                2
        );

        System.out.println(item);

        System.out.println(
                "Subtotal: R$ " + item.calcularSubtotal()
        );

        item.alterarQuantidade(3);
        System.out.println(item);

        item.adicionarObservacao("Sem cebola");
        System.out.println(item);

        System.out.println(
                "Novo subtotal: R$ " + item.calcularSubtotal()
        );


        Pedido pedido = new Pedido(
                1L,
                cliente,
                TipoAtendimento.BALCAO,
                FormaPagamento.PIX
        );

        System.out.println("Pedido criado:");
        System.out.println(pedido);

        pedido.adicionarProduto(produto, 2);

        System.out.println("Produto adicionado:");
        System.out.println(pedido);

        pedido.adicionarObservcao(
                produto.getId(),
                "Sem cebola"
        );

        pedido.alterarQuantidade(
                produto.getId(),
                3
        );

        System.out.println("Pedido alterado:");
        System.out.println(pedido);

        System.out.println(
                "Total: R$ " + pedido.calcularTotal()
        );

        pedido.confirmar();
        System.out.println("Pedido confirmado:");
        System.out.println(pedido);

        pedido.iniciarPreparo();
        System.out.println("Pedido em preparo:");
        System.out.println(pedido);

        pedido.marcarComoPronto();
        System.out.println("Pedido pronto:");
        System.out.println(pedido);

        pedido.finalizado();
        System.out.println("Pedido finalizado:");
        System.out.println(pedido);


    }

    }



