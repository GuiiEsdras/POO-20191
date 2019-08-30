package br.edu.ifpb.livro;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Livro {

    private Locale local = new Locale("pt", "BR");

    private String título;
    private String autor;
    private Categoria gênero;
    private double preço;
    private Date aquisição;
    private int código;

    private static int INCREMENTADOR = 0;

    public Livro(String título, String autor, Categoria gênero, double preço, Date aquisição) {
        setTítulo(título);
        setAutor(autor);
        setGênero(gênero);
        setPreço(preço);
        setAquisição(aquisição);
        setCódigo();
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        if (título != null && título.length() > 0) {
            this.título = título;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Categoria getGênero() {
        return gênero;
    }

    public void setGênero(Categoria gênero) {
        this.gênero = gênero;
    }

    public Date getAquisição() {
        return aquisição;
    }

    public void setAquisição(Date aquisição) {
        this.aquisição = aquisição;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        if (preço >= 0) {
            this.preço = preço;
        }
    }

    public int getCódigo() {
        return código;
    }

    public void setCódigo() {
        this.código = ++INCREMENTADOR;
    }

    @Override
    public String toString() {

        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);

        String str =
                String.format("|Livro Cód. %s|", this.getCódigo()) + "\n" +
                "Título: " + this.getTítulo() + "\n" +
                "Autor: " + this.getAutor() + "\n" +
                "Gênero: " + this.getGênero() + "\n" +
                "Preço: " + formatoMoeda.format(this.getPreço()) + "\n" +
                String.format("%1$s %2$td de %2$tB de %2$tY às %2$tr", "Data de Aquisição:", this.getAquisição()) + "\n" +
                "---";

        return str;
    }
}