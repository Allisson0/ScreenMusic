package br.com.ScreenMusic.Classes;

public enum Tipo {
    //Tipos do enum
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipoInserido;

    Tipo(String tipoInserido){
        this.tipoInserido = tipoInserido;
    }

    //Realiza a verificação para declaração do enum
    public static Tipo fromString(String text){
        for (Tipo tipo : Tipo.values()){
            if (tipo.tipoInserido.equalsIgnoreCase(text)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhum tipo encontrado para o artista.");
    }
}
