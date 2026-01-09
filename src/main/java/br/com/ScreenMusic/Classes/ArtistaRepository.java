package br.com.ScreenMusic.Classes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    public Optional<Artista> findByNomeContainingIgnoreCase(String nome);
}
