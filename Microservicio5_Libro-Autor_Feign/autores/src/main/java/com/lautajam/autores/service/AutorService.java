
package com.lautajam.autores.service;

import com.lautajam.autores.model.Autor;
import com.lautajam.autores.repository.IAutoresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService implements IAutoresService{
    
    @Autowired
    private IAutoresRepository autorRepository;

    @Override
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor getAutorById(Long idAutor) {
        return autorRepository.findById(idAutor).orElse(null);
    }

    @Override
    public void createAutor(Autor autorCreate) {
        autorRepository.save(autorCreate);
    }

    @Override
    public void deleteAutorById(Long idAutor) {
        autorRepository.deleteById(idAutor);
    }

    @Override
    public Autor updatedAutor(Autor autorUpdated, Long idAutor) {
        Autor autorExist = this.getAutorById(idAutor);

        if (autorExist != null) {
            autorExist.setNombreCompletoAutor(autorUpdated.getNombreCompletoAutor());
            autorExist.setFechaNacimientoAutor(autorUpdated.getFechaNacimientoAutor());
            
            List<Long> listaIdsLibrosEscritos = autorExist.getListaIdsLibrosEscritos();
            if(!autorUpdated.getListaIdsLibrosEscritos().isEmpty()){
                for (Long idsLibroEscrito : autorUpdated.getListaIdsLibrosEscritos()) {
                    listaIdsLibrosEscritos.add(idsLibroEscrito);
                }
                autorExist.setListaIdsLibrosEscritos(listaIdsLibrosEscritos);
            }

            this.createAutor(autorExist);
        }
            return autorExist;
    }

    @Override
    public List<Autor> getAutorsByIdBook(Long idLibroEscrito) {
        List<Autor> autoresByIdBook = autorRepository.findAutoresByLibroEscritoId(idLibroEscrito);
        
        return autoresByIdBook;
    }
    
    
    
    
}