package br.com.ScreenMusic.Principal;

import br.com.ScreenMusic.Classes.Artista;
import br.com.ScreenMusic.Classes.ArtistaRepository;
import br.com.ScreenMusic.Classes.Musica;
import br.com.ScreenMusic.Classes.Tipo;

import java.lang.classfile.Opcode;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);

    private final ArtistaRepository repositorio;

    private String menu = """
            ======= Screen Music Application =======
            
            1 - Cadastrar artistas
            2 - Cadastrar músicas
            3 - Listar músicas
            4 - Buscar músicas por artista
            5 - Pesquisar dados sobre um artista
            
            9 - Sair
            """;

    public Main(ArtistaRepository repository){
        this.repositorio = repository;
    }

    //==== MENU PRINCIPAL ====
    public void menu(){
        int choose = 0;
        while(choose!=9) {
            System.out.println(menu);
            System.out.println("Escolha uma das opções acima: ");

            try{
                choose = input.nextInt();
                input.nextLine();
            } catch (NumberFormatException e){
                System.out.println("Por favor, insira um número válido.");
            }

            switch (choose){
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Por favor, insira uma opção válida.");
            }
        }
    }

    //==== CADASTRAR NOVO ARTISTA ====
    private void cadastrarArtista(){
        System.out.println("Digite o nome do artista a ser cadastrado: ");
        var nome = input.nextLine();
        System.out.println("Qual o tipo do artista (solo, dupla, banda)?");
        var tipoEscolha = input.nextLine();

        //Cria um tipo com base nas categorias (se de acordo
        Tipo tipo = Tipo.fromString(tipoEscolha.toLowerCase());
        Artista artista = new Artista(nome, tipo);

        //Salva o artista no banco de dados
        repositorio.save(artista);
        System.out.println("Artista salvo com sucesso.\n" + artista);
    }

    //==== CADASTRAR NOVA MÚSICA ====
    private void cadastrarMusica(){
        System.out.println("Qual o nome da música? ");
        var nomeMusica = input.nextLine();
        mostrarArtistas();
        System.out.println("A qual autor pertence essa música? ");
        var autor = input.nextLine();

        //Procura o autor no banco de dados
        Optional<Artista> artistaSelecionado = repositorio.findFirstByNomeContainingIgnoreCase(autor);

        //Se encontrar o autor, cria uma musíca e relaciona o autor nela
        if (artistaSelecionado.isPresent()) {
            var artista = artistaSelecionado.get();

            Musica musica = new Musica(nomeMusica, artista);
            //Para o autor, adiciona uma nova música nas suas músicas
            artistaSelecionado.get().addMusicasAutorais(musica);

            //Salva o artista com a nova música
            repositorio.save(artista);
            System.out.printf("Música %s adicionada com sucesso!\n", musica.getNome());
        } else {
            //Caso não encontrado, retorna essa mensagem
            System.out.println("Artista não encontrado.");
        }
    }

    //==== MOSTRA LISTA DE ARTISTAS ====
    private void mostrarArtistas(){
        //Retorna a lista de autores do banco de dados
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    //==== LISTA AS MÚSICAS DISPONÍVEIS ====
    private void listarMusicas(){
        //lista as músicas disponíveis
        List<Musica> musicas = repositorio.listarMusicas();
        musicas.forEach(System.out::println);
    }
}
