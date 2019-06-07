package com.adjcv01.adjcv01;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;
@Entity
@Table(name="Atleta")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAtleta;
    @NotNull
    private String nombreAtleta;
    private String apellidoAtleta;
    private Integer edadAtleta;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "idClub")
    private Club club;
    public Club getClub() {
        return club;
    }


    public Atleta(@NotNull String nombreAtleta, String apellidoAtleta, Integer edadAtleta, Date cumpleanios, String categoria) {
        this.nombreAtleta = nombreAtleta;
        this.apellidoAtleta = apellidoAtleta;
        this.edadAtleta = edadAtleta;
        this.categoria = categoria;
    }

    public Integer getIdAtleta() {
        return idAtleta;
    }

    public void setIdAtleta(Integer idAtleta) {
        this.idAtleta = idAtleta;
    }

    public String getNombreAtleta() {
        return nombreAtleta;
    }

    public void setNombreAtleta(String nombreAtleta) {
        this.nombreAtleta = nombreAtleta;
    }

    public String getApellidoAtleta() {
        return apellidoAtleta;
    }

    public void setApellidoAtleta(String apellidoAtleta) {
        this.apellidoAtleta = apellidoAtleta;
    }

    public Integer getEdadAtleta() {
        return edadAtleta;
    }

    public void setEdadAtleta(Integer edadAtleta) {
        this.edadAtleta = edadAtleta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public void setClub(Club club) {
        this.club = club;
    }

    public Atleta() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Atleta)) return false;
        Atleta atleta = (Atleta) o;
        return Objects.equals(getIdAtleta(), atleta.getIdAtleta());
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "idAtleta=" + idAtleta +
                ", nombreAtleta='" + nombreAtleta + '\'' +
                ", apellidoAtleta='" + apellidoAtleta + '\'' +
                ", edadAtleta=" + edadAtleta +
                ", categoria='" + categoria + '\'' +
                ", club=" + club +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdAtleta());
    }
}
