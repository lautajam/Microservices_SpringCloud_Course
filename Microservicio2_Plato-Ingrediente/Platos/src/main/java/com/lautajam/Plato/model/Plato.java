
package com.lautajam.Plato.model;

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
public class Plato {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idPlato;
    private String nombrePlato;
    private double precioPlato;
    private String descripcionPlato;
    
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> listaIngredientes;
    
    public Plato(String nombrePlato, double precioPlato, String descripcionPlato) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.descripcionPlato = descripcionPlato;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "idPlato=" + idPlato +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", precioPlato=" + precioPlato +
                ", descripcionPlato='" + descripcionPlato + '\'' +
                ", listaIngredientes=" + listaIngredientes +
                '}';
    }
  
}
