package br.com.erick_candido.Api_Estudo.Domain.Filmes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmesRepository extends JpaRepository <Filmes, Long> {

    Optional<Filmes> findByNome(String nome);

    List findByDisponivel(Boolean disponivel);
}
