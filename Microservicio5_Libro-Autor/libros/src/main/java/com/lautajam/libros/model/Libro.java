
package com.lautajam.libros.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Libro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLibro;
    
    private Long isbnCodigoLibro;
    private String tituloLibro;
    private Date fechaPublicacionLibro;
    private String descripcionLibro;
    
    @ElementCollection
    private List<String> nombresAutorLibro;
    
    
}
