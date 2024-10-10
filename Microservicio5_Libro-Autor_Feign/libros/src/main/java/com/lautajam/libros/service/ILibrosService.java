
package com.lautajam.libros.service;

import com.lautajam.libros.model.Libro;
import java.util.List;


public interface ILibrosService {
    
    public List<Libro> getAllLibros();
    
    public Libro getLibroById(Long idLibro);
    
    public void createLibro(Libro libroCreate);
    
    public void deleteLibroById(Long idLibro);
    
    public Libro updatedLibro(Libro libroUpdated, Long idLibro);
    
}
