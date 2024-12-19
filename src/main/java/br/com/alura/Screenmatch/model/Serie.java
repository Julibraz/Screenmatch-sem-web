package br.com.alura.Screenmatch.model;

import br.com.alura.Screenmatch.service.ConsultaChatGPT;
import br.com.alura.Screenmatch.service.TraducaoMyMemory.ConsultaMyMemory;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Entity
@Table(name = "series")
public class Serie {
    @Id //define o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor da chave primária automaticamente
    private Long id;
    @Column(unique = true) //define o campo como unico
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    @Enumerated(EnumType.STRING)
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;
    @Transient //define o campo como transiente, que o Hibernate não vai persistir no BD
    private List<Episodio> episodios = new ArrayList<>();



    public Serie() {}


    //CONSTRUTOR PARA QUANDO FOR UTILIZAR A API DO MYMEMORY PARA TRADUZIR
    public Serie(DadosSerie dadosSerie){
        this.titulo = dadosSerie.titulo();
        this.totalTemporadas = dadosSerie.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
        this.atores = dadosSerie.atores();
        this.poster = dadosSerie.poster();
        this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();
                     //consultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim(); //para utilizar a API do ChatGPT para traduções
    }





    //CONSTRUTOR PARA QUANDO FOR UTILIZAR A API DO CHATGPT PARA A TRADUÇÃO
//    public Serie(DadosSerie dadosSerie) {
//        this.titulo = dadosSerie.titulo();
//        this.totalTemporadas = dadosSerie.totalTemporadas();
//        this.avaliacao = OptionalDouble.of(Double.valueOf(dadosSerie.avaliacao())).orElse(0);
//        this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
//        this.atores = dadosSerie.atores();
//        this.poster = dadosSerie.poster();
//        this.sinopse = ConsultaChatGPT.obterTraducao(dadosSerie.sinopse()).trim();
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public List<Episodio> getEpisodios() {
        return episodios;
    }

    public void setEpisodios(List<Episodio> episodios) {
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +

                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'';
    }
}
