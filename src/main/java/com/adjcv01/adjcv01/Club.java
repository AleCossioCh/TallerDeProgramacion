package com.adjcv01.adjcv01;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="Club")
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idClub;
    @NotNull
    private String nombreClub;
    @OneToMany(mappedBy = "club")
    private List<Atleta> atletas;


    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(@NotNull String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public Club(String nombreClub) {

        this.nombreClub = nombreClub;
    }

    public Club(){

    }

}
