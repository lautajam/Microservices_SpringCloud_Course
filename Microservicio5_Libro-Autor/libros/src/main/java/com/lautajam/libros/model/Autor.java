
package com.lautajam.libros.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    
    private long idAutor;
    private String nombreCompletoAutor;
    private Date fechaNacimientoAutor;
    private List<Long> listaIdsLibrosEscritos;
}
