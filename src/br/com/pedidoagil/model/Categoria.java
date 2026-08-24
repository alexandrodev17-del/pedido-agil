package br.com.pedidoagil.model;

public class Categoria {

    private Long id;
    private String nome;
    private boolean disponivel;

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.disponivel = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtiva() {
        return disponivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void disponibilizar() {
        this.disponivel = true;
    }

    public void indisponibilizar() {
        this.disponivel = false;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ativa=" + disponivel +
                '}';
    }
}
