package br.com.pedidoagil.model;

public class Categoria {

    private Long id;
    private String nome;
    private boolean ativa;

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.ativa = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void ativa(){
        this.ativa = true;
    }

    public void desativa(){
        this.ativa = false;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ativa=" + ativa +
                '}';
    }
}
