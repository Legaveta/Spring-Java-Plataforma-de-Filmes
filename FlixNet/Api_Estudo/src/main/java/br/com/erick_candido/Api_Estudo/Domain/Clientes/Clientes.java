package br.com.erick_candido.Api_Estudo.Domain.Clientes;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Clientes {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome", unique = true)
    private String nome;

    private String cidade;

    private String email;

    private String documento;

    
    private String dataNascimento;

    private boolean ativo = true;


    public Clientes(dadosCadastroClientes dados){
        this.nome = dados.nome();
        this.cidade = dados.cidade();
        this.email = dados.email();
        this.documento = dados.documento();
        this.dataNascimento = dados.dataNascimento();
        this.ativo = dados.ativo();
    }

    public void excluir(){
        this.ativo = false;
    }

}
