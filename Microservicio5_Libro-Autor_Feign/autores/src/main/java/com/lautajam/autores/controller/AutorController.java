
package com.lautajam.autores.controller;

import com.lautajam.autores.service.IAutoresService;
import com.lautajam.autores.model.Autor;
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
@RequestMapping("/autores")
public class AutorController {
    
    @Autowired
    private IAutoresService autoresService;
    
    @GetMapping("/getAllAutores")
    public ResponseEntity<List<Autor>> getAllAutores(){
        try {
            List<Autor> allAutores = autoresService.getAllAutores();
            return new ResponseEntity<>(allAutores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @GetMapping("/getAutorById/{idAutor}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long idAutor){
        try {
            Autor autorById = autoresService.getAutorById(idAutor);
            return new ResponseEntity<>(autorById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @GetMapping("/getAutoresByIdBook/{idLibroEscrito}")
    public ResponseEntity<List<Autor>> getAutoresByIdBook(@PathVariable Long idLibroEscrito){
        try {
            List<Autor> allAutoresByIdBook = autoresService.getAutorsByIdBook(idLibroEscrito);
            return new ResponseEntity<>(allAutoresByIdBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @PostMapping("/createAutor")
    public ResponseEntity createAutor(@RequestBody Autor autorCreate){
        try {
            autoresService.createAutor(autorCreate);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @DeleteMapping("/deleteAutorById/{idAutor}")
    public ResponseEntity deleteAutorById(@PathVariable Long idAutor){
        try {
            autoresService.deleteAutorById(idAutor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }
    
    @PutMapping("updatedAutor/{idAutor}")
    public ResponseEntity<Autor> updatedAutor(@RequestBody Autor autor, 
                              @PathVariable Long idAutor){
        try {
            Autor autorUpdated = autoresService.updatedAutor(autor, idAutor);
            return new ResponseEntity<>(autorUpdated,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);            
        }
    }

}
