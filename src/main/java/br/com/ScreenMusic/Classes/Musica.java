package br.com.ScreenMusic.Classes;

import jakarta.persistence.*;

@Entity
@Table(name = "Musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Artista artistaAutoral;

    public Musica(){}

    public Musica(String nome, Artista artista){
        this.nome = nome;
        this.artistaAutoral = artista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtistaAutoral() {
        return artistaAutoral;
    }

    public void setArtistaAutoral(Artista artistaAutoral) {
        this.artistaAutoral = artistaAutoral;
    }

    @Override
    public String toString(){
        return "Música: " + this.getNome() + " | autor: " + this.getArtistaAutoral().getNome();
    }
}
