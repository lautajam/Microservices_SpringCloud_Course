
package com.lautajam.Ingrediente.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ingrediente {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idIngrediente;
    private String nombreIngrediente;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> listaPlatos;

}
