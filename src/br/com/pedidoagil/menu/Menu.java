package br.com.pedidoagil.menu;

import br.com.pedidoagil.model.Categoria;
import br.com.pedidoagil.model.Pedido;
import br.com.pedidoagil.model.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private long proximoProdutoId;
    private long proximoCategoriaId;
    private Scanner scanner;
    private List<Produto> produtos;
    private List<Pedido> pedidos;

    public Menu(){
        this.scanner = new Scanner(System.in);
        this.produtos = new ArrayList<>();
        this.pedidos = new ArrayList<>();

        this.proximoProdutoId = 1L;
        this.proximoCategoriaId = 1L;
    }

    public void iniciar(){
        int opcao;
        do {
            exibirOpcoes();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
               case 1:
                   cadastrarProduto();
                   break;

                case 2:
                    exibirCardapio();
                    break;
                case 3:
                    abrirPedido();
                    break;

                case 4:
                    adicionarProdutoAoPedido();
                    break;

                case 5:
                    confirmarPedido();
                    break;

                case 6:
                    mostrarPedidosDaCozinha();
                    break;

                case 7:
                    alterarStatus();
                    break;

                case 8:
                  finalizarPedido();
                    break;

                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            }while(opcao!=9);
        scanner.close();

    }

    private void finalizarPedido() {
        System.out.println("Função de fazer pedido ainda não implementada.");
    }

    private void alterarStatus() {
        System.out.println("Função de fazer pedido ainda não implementada.");
    }

    private void mostrarPedidosDaCozinha() {
        System.out.println("Função de fazer pedido ainda não implementada.");

    }

    private void adicionarProdutoAoPedido() {
        System.out.println("Função de fazer pedido ainda não implementada.");
    }

    private void abrirPedido() {
        System.out.println("Função de fazer pedido ainda não implementada.");
    }

    private void cadastrarProduto() {
        System.out.println("\n=== CADASTRO DE PRODUTO ===");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Preço: R$ ");
        String precoDigitado = scanner.nextLine();
        precoDigitado = precoDigitado.replace(",", ".");

        BigDecimal preco = new BigDecimal(precoDigitado);

        System.out.print("Nome da categoria: ");
        String nomeCategoria = scanner.nextLine();


        Categoria categoria = new Categoria(
               proximoCategoriaId,
                nomeCategoria
        );

        Produto produto = new Produto(
                proximoProdutoId,
                nome,
                descricao,
                preco,
                categoria
        );

        produtos.add(produto);

        proximoProdutoId++;
        proximoCategoriaId++;

        System.out.println("Produto cadastrado com sucesso!");
        System.out.println(produto);
    }

    private void exibirOpcoes() {
        System.out.println("\n=== PEDIDO ÁGIL ===");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Mostrar cardápio");
        System.out.println("3 - abrir pedido");
        System.out.println("4 - Adicionar produto ao pedido");
        System.out.println("5 - Confirmar pedido");
        System.out.println("6 - Mostrar pedidos da cozinha");
        System.out.println("7 - Alterar status");
        System.out.println("8 - Finalizar pedido");
        System.out.println("9 - Sair");

        System.out.print("Escolha uma opção: ");
    }

    private void exibirCardapio() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto produto : produtos) {
            System.out.println(
                    produto.getNome()
                            + " - R$ "
                            + produto.getPreco()
            );
        }
    }

    private void confirmarPedido() {
        System.out.println("Função de fazer pedido ainda não implementada.");
    }
}