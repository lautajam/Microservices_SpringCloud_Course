
package com.lautajam.libros.repository;

import com.lautajam.libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibrosRepository extends JpaRepository<Libro, Long>{ 
    @Query(value = "SELECT id_libro FROM Libro ORDER BY id_libro DESC LIMIT 1", nativeQuery = true)
    Long findLastLibrorId();
}
