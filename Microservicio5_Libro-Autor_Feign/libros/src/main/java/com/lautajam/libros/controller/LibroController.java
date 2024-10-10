
package com.lautajam.libros.controller;

import com.lautajam.libros.model.Libro;
import com.lautajam.libros.service.ILibrosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private ILibrosService libroService;
    
    @GetMapping("/getAllLibros")
    public ResponseEntity<List<Libro>> getAllLibros(){
        try {
            List<Libro> allLibros = libroService.getAllLibros();
            return new ResponseEntity<>(allLibros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @GetMapping("/getLibroById/{idLibro}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long idLibro){
        try {
            Libro autorById = libroService.getLibroById(idLibro);
            return new ResponseEntity<>(autorById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @PostMapping("/createLibro")
    public ResponseEntity createLibro(@RequestBody Libro autorCreate){
        try {
            libroService.createLibro(autorCreate);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @DeleteMapping("/deleteLibroById/{idLibro}")
    public ResponseEntity deleteLibroById(@PathVariable Long idLibro){
        try {
            libroService.deleteLibroById(idLibro);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @PutMapping("updatedLibro/{idLibro}")
    public ResponseEntity<Libro> updatedLibro(@RequestBody Libro autor, 
                                               @PathVariable Long idLibro){
        try {
            Libro autorUpdated = libroService.updatedLibro(autor, idLibro);
            return new ResponseEntity<>(autorUpdated,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }

}
