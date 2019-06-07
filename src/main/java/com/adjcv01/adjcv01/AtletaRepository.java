package com.adjcv01.adjcv01;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface AtletaRepository extends CrudRepository<Atleta, Integer> {

    @Query(value = "select * from Atleta where categoria='Infantil'",nativeQuery =true)
    public Iterable<Atleta> findByCategoryInfantil();

    @Query(value = "select * from Atleta where categoria='Adulto'",nativeQuery =true)
    public Iterable<Atleta> findByCategoryAdulto();

    @Query(value = "select * from Atleta where categoria='Profecional'",nativeQuery =true)
    public Iterable<Atleta> findByCategoryProfecional();

    @Query(value = "select * from Atleta a join Club c on a.idClub = c.idClub " +
            "join Municipio m on m.idMunicipio = c.idMunicipio " +
            "where m.idMunicipio=:idMunicipioBuscado and" +
            " a.categoria=:categoriaBuscada ",nativeQuery =true)
    public Iterable<Atleta> findByCategoriaAndMunicipio(@Param("categoriaBuscada") String categoriaBuscada,
                                                        @Param("idMunicipioBuscado") Integer idMunicipioBuscado);
}
