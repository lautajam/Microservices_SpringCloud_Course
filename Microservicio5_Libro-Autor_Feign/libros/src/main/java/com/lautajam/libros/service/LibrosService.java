
package com.lautajam.libros.service;

import com.lautajam.libros.model.Autor;
import com.lautajam.libros.model.Libro;
import com.lautajam.libros.repository.ApiAutoresClient;
import com.lautajam.libros.repository.ILibrosRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrosService implements ILibrosService{
    
    @Autowired
    private ILibrosRepository librosRepository;
    
    @Autowired
    private ApiAutoresClient apiAutoresClient;
            
    @Override
    public List<Libro> getAllLibros() {
        return librosRepository.findAll();
    }

    @Override
    public Libro getLibroById(Long idLibro) {
        return librosRepository.findById(idLibro).orElse(null);
    }

    @Override
    public void createLibro(Libro libroCreate) {
        
        librosRepository.save(libroCreate);

        Long idLibroCreate = librosRepository.findLastLibrorId();

        Libro libroCreateUpdatedAutor = getLibroById(idLibroCreate);

        List<Autor> autoresIdLibro = apiAutoresClient.getAutoresByIdBook(idLibroCreate);

        List<String> nombresAutoresLibro = new ArrayList<>();

        for (Autor autor : autoresIdLibro) {
            nombresAutoresLibro.add(autor.getNombreCompletoAutor());
        }

        libroCreateUpdatedAutor.setNombresAutorLibro(nombresAutoresLibro);

        librosRepository.save(libroCreate);
    }

    @Override
    public void deleteLibroById(Long idLibro) {
        librosRepository.deleteById(idLibro);
    }

    @Override
    public Libro updatedLibro(Libro libroUpdated, Long idLibro) {
        Libro libroExist = this.getLibroById(idLibro);

        if (libroExist != null) {
            libroExist.setIsbnCodigoLibro(libroUpdated.getIsbnCodigoLibro());
            libroExist.setDescripcionLibro(libroUpdated.getDescripcionLibro());
            libroExist.setTituloLibro(libroUpdated.getTituloLibro());
            libroExist.setFechaPublicacionLibro(libroUpdated.getFechaPublicacionLibro());
            
            List<Autor> autoresIdLibro = apiAutoresClient.getAutoresByIdBook(idLibro);
        
            List<String> nombresAutoresLibro = new ArrayList<>();

            for (Autor autor : autoresIdLibro) {
                nombresAutoresLibro.add(autor.getNombreCompletoAutor());
            }

            libroExist.setNombresAutorLibro(nombresAutoresLibro);

            this.createLibro(libroExist);
        }
            return libroExist;
    }
    
}
