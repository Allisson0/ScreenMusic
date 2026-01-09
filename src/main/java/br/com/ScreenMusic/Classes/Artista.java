package br.com.ScreenMusic.Classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "Artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    //Mapeamento da chave estrangeira, tipo de acesso e busca ansiosa
    @OneToMany(mappedBy = "artistaAutoral", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicasAutorais;

    public Artista(){}

    public Artista(String nome, Tipo tipo){
        this.nome = nome;
        this.tipo = tipo;
    }

    public List<Musica> getMusicasAutorais() {
        return musicasAutorais;
    }

    public void addMusicasAutorais(Musica musicaAutoral) {
        this.musicasAutorais.add(musicaAutoral);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() +
                " Tipo: " + this.getTipo();
    }
}
