/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lautajam.Ingrediente.repository;

import com.lautajam.Ingrediente.model.Ingrediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngredientesRepository extends JpaRepository<Ingrediente, Long> {    

    @Query("SELECT i FROM Ingrediente i WHERE :nombrePlato MEMBER OF i.listaPlatos")
    List<Ingrediente> findByNombre(@Param("nombrePlato") String nombrePlato);

}
