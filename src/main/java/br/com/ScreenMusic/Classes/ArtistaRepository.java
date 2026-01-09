package br.com.ScreenMusic.Classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    //Encontra o primeiro artista por meio de um nome
    Optional<Artista> findFirstByNomeContainingIgnoreCase(String nome);

    //Seleciona uma série de músicas do banco de dados
    @Query("SELECT m FROM Artista a JOIN a.musicasAutorais m ORDER BY a.id")
    List<Musica> listarMusicas();
}
