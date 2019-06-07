package com.adjcv01.adjcv01;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer idClub;
    @NotNull
    private String nombreClub;


    @ManyToOne
    @JoinColumn(name = "idMunicipio")
    private Municipio municipio;


    @OneToMany(mappedBy = "club")
    private List<Atleta> atletas;

    public List<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }


    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }


        public Club(@NotNull String nombreClub) {

            this.nombreClub = nombreClub;
        }

        public Club() {
        }


}
