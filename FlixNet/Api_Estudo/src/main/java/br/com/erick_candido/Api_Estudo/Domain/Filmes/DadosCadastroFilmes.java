package br.com.erick_candido.Api_Estudo.Domain.Filmes;


public record DadosCadastroFilmes(String nome, String ano_lancamento, String autor, String genero, boolean disponivel) {

    public DadosCadastroFilmes (Filmes filme){
        this(filme.getNome(), filme.getAno_lancamento(), filme.getAutor(), filme.getGenero(), filme.getDisponivel());
    }
}
