package br.com.erick_candido.Api_Estudo.Domain.Clientes;

import br.com.erick_candido.Api_Estudo.Domain.Filmes.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface clientesRepository extends JpaRepository<Clientes, Long> {

    Optional<Clientes> findByNome(String nome);

}
