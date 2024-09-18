package br.com.erick_candido.Api_Estudo.Controller;

import br.com.erick_candido.Api_Estudo.Domain.Clientes.*;
import br.com.erick_candido.Api_Estudo.Domain.Filmes.DadosListagemFilmes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ClientesController {

    @Autowired
    private clientesRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrarCliente(@RequestBody dadosCadastroClientes dados){

        var cliente = new Clientes(dados);

        repository.save(cliente);

        return ResponseEntity.ok().body("Usuário Cadastrado com SUcesso");

    }

    @GetMapping
    public List<dadosListagemClientes> listar() {
        return repository.findAll().stream().map(dadosListagemClientes::new).toList();
    }

    @PostMapping("/Excluir")
    public ResponseEntity<String> excluir(@RequestBody dadosDevolverFilme dados){

        String nome = dados.getNome();

        var clienteexcluido = repository.findByNome(nome);

        if (clienteexcluido.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário Não encontrado");
        }

        var exclui = clienteexcluido.get();

        if (!exclui.isAtivo()) {
            exclui.excluir();
            repository.save(exclui);
            return ResponseEntity.ok("Usuario Desativado com sucesso.");
        } else {
            return ResponseEntity.ok("Usuario já esta desativado");
        }
    }

}




