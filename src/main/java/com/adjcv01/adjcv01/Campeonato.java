package com.adjcv01.adjcv01;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="Campeonato")
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCampeonato;
    /*
    private Integer idPrimerAtletaJuvenil;
    private Integer idPrimerAtletaInfantil;
    private Integer idPrimerAtletaProfesional;
     */
    @NotNull
    private Date fechaCampeonato;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "campeonato_atletas",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "atleta_id"))
    private List<Atleta> atletas;


    public Campeonato(){

    }

    public Integer getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }


    public Date getFechaCampeonato() {
        return fechaCampeonato;
    }

    public void setFechaCampeonato(Date fechaCampeonato) {
        this.fechaCampeonato = fechaCampeonato;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }

}