package br.com.erick_candido.Api_Estudo.Domain.Filmes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "Filmes")
@Entity(name = "Filmes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Filmes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", unique = true)
    private String nome;

    private String ano_lancamento;

    private String autor;

    private String genero;

    @Column(nullable = false)
    private Boolean disponivel = true;


    public Filmes(DadosCadastroFilmes dados){
        this.nome = dados.nome();
        this.ano_lancamento = dados.ano_lancamento();
        this.autor = dados.autor();
        this.genero = dados.genero();
        this.disponivel = dados.disponivel();
    }

    public void Alugado(){
        this.disponivel = false;
    }

    public void devolvido(){
        this.disponivel = true;
    }

}
