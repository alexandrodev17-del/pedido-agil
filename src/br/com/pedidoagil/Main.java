package br.com.pedidoagil;

import br.com.pedidoagil.model.Categoria;
import br.com.pedidoagil.model.Cliente;
import br.com.pedidoagil.model.ItemPedido;
import br.com.pedidoagil.model.Produto;

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
    }

    }



