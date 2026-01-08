package br.com.ScreenMusic.Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "Musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    private Artista artistaAutoral;
}
