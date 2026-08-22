package br.com.pedidoagil;

import br.com.pedidoagil.model.Categoria;

public  class Main {
    public static void main(String[] args) {

        Categoria categoria = new Categoria(1L, "Hamburguer");

        System.out.println(categoria);

        categoria.desativa();
        System.out.println(categoria);

        categoria.ativa();
        System.out.println(categoria);

        categoria.setNome("Hambúrgueres artesanais");
        System.out.println(categoria);

    }

}

