package br.com.erick_candido.Api_Estudo.Domain.Clientes;



public record dadosListagemClientes(String nome, String cidade, String email, String documento, boolean ativo) {

    public dadosListagemClientes (Clientes cliente){
        this(cliente.getNome(), cliente.getCidade(), cliente.getEmail(), cliente.getDocumento(), cliente.isAtivo());
    }
}
