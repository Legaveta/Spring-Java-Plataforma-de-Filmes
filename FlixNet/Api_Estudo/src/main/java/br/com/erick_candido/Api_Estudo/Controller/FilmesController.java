package br.com.erick_candido.Api_Estudo.Controller;

import br.com.erick_candido.Api_Estudo.Domain.Filmes.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
    @Autowired
    private FilmesRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastroFilmes(@RequestBody @Valid DadosCadastroFilmes dados) {

        var filmes = new Filmes(dados);

        repository.save(filmes);

        return ResponseEntity.ok().body("Filme cadastrado com sucesso!");


    }

    @GetMapping
    public List<DadosListagemFilmes> listar() {
        return repository.findAll().stream().map(DadosListagemFilmes::new).toList();
    }
    // Método para verificar a disponibilidade de um filme pelo nome

    @GetMapping("/buscar")
    @Transactional
    public ResponseEntity<String> verificarDisponibilidade(@RequestBody DadosBuscarFIlmes dadosBuscarFIlmes) {


        String nome = dadosBuscarFIlmes.getNome();
        var filme = repository.findByNome(nome);
        System.out.println("Buscando filme com nome: " + nome);

        if (filme.isEmpty()) {
            return ResponseEntity.status(404).body("Filme não encontrado.");
        }

        var filmes = filme.get();

        if (filmes.getDisponivel()) {
            filmes.Alugado();
            repository.save(filmes);
            return ResponseEntity.ok("Filme alugado com sucesso.");
        } else {
            return ResponseEntity.ok("Filme já está alugado.");
        }
    }

    @GetMapping("/devolver")
    @Transactional
    public ResponseEntity<String> devolverFilmes(@RequestBody @Valid DadosDevolverFilmes devolverFilmes) {

        String nome = devolverFilmes.getNome();

        var filmedevolvido = repository.findByNome(nome);

        System.out.println("Devolvendo o filme com nome: " + nome);

        if (filmedevolvido.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme nao encontrado!");
        }

        var devolve = filmedevolvido.get();

        if (!devolve.getDisponivel()) {
            devolve.devolvido();
            repository.save(devolve);
            return ResponseEntity.ok("Filme retornado com sucesso.");
        } else {
            return ResponseEntity.ok("Filme ainda esta Disponivel.");
        }



    }


}




