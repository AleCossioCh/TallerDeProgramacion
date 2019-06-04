package com.adjcv01.adjcv01;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="Club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClub;
    @NotNull
    private String nombreClub;

    @OneToMany(mappedBy = "club")
    private Set<Atleta> atletas;


    public Set<Atleta> getAtletas() {
        return atletas;
    }

    public void setAtletas(Set<Atleta> atletas) {
        this.atletas = atletas;
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
