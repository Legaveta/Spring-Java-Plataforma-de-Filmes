package br.com.erick_candido.Api_Estudo.Domain.Clientes;

import br.com.erick_candido.Api_Estudo.Domain.Filmes.Filmes;

public record dadosCadastroClientes(

        String nome,
        String cidade,
        String email,
        String documento,
        String dataNascimento,
        boolean ativo
            ) {

    public dadosCadastroClientes (Clientes clientes){
        this(clientes.getNome(), clientes.getCidade(), clientes.getEmail(), clientes.getDocumento(), clientes.getDataNascimento(), clientes.isAtivo());
    }
}
