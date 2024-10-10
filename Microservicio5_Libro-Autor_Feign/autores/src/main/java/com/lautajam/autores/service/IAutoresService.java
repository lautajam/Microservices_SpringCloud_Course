
package com.lautajam.autores.service;

import com.lautajam.autores.model.Autor;
import java.util.List;


public interface IAutoresService {
    
    public List<Autor> getAllAutores();
    
    public Autor getAutorById(Long idAutor);
    
    public List<Autor> getAutorsByIdBook(Long idLibroEscrito);
    
    public void createAutor(Autor autorCreate);
    
    public void deleteAutorById(Long idAutor);
    
    public Autor updatedAutor(Autor autorUpdated, Long idAutor);
}
