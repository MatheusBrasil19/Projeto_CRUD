package br.ulbra.entity;

public class Serie {

    private int idSerie;
    private String serie;
    private double nota;
    private String categoria;
    private String temporadas;
    private int anoLancamento;

    public Serie() {

    }

    public Serie(int idSerie, String serie, double nota, String categoria, String temporadas, int anoLancamento) {
        this.idSerie = idSerie;
        this.serie = serie;
        this.nota = nota;
        this.categoria = categoria;
        this.temporadas = temporadas;
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "Serie{" + "idSerie=" + idSerie + ", serie=" + serie + ", nota=" + nota + ", categoria=" + categoria + ", temporadas=" + temporadas + ", anoLancamento=" + anoLancamento + '}';
    }

    public int getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(String temporadas) {
        this.temporadas = temporadas;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

}
