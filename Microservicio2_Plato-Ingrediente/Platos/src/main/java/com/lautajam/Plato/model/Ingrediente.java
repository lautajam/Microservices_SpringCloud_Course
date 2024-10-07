
package com.lautajam.Plato.model;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingrediente {
    
    private long idIngrediente;
    private String nombreIngrediente;
    private List<String> listaPlatos;

}
