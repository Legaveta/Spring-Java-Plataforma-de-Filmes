package br.com.erick_candido.Api_Estudo.Domain.Filmes;

public record DadosListagemFilmes(String nome, String ano_lancamento, String autor, String genero) {


    public DadosListagemFilmes (Filmes filme){
        this(filme.getNome(), filme.getAno_lancamento(), filme.getAutor(), filme.getGenero());
    }


}
