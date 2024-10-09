
package com.lautajam.autores.repository;

import com.lautajam.autores.model.Autor;
import feign.Param;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutoresRepository extends JpaRepository<Autor, Long>{   

    @Query("SELECT a FROM Autor a WHERE :idLibroEscrito MEMBER OF a.listaIdsLibrosEscritos")
    List<Autor> findAutoresByLibroEscritoId(@Param("idLibroEscrito") Long idLibroEscrito);

}
