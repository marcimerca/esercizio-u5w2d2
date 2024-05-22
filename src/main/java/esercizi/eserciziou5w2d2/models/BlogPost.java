package esercizi.eserciziou5w2d2.models;

import lombok.Data;

import java.time.LocalTime;

@Data
public class BlogPost {
    private int id;
    private static int cont;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int minutiDiLettura;


    public BlogPost(String categoria, String titolo, String cover, String contenuto, int minutiDiLettura) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.minutiDiLettura = minutiDiLettura;
        cont++;
        this.id = cont;

    }
}
