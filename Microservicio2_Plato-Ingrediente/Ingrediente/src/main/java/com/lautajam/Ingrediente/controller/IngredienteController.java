
package com.lautajam.Ingrediente.controller;

import com.lautajam.Ingrediente.service.IIngredientesService;
import com.lautajam.Ingrediente.model.Ingrediente;
import java.util.ArrayList;
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
@RequestMapping("/ingredientes")
public class IngredienteController {
    
    @Autowired
    private IIngredientesService ingredientesService;
    
    @GetMapping("/traerIngredientes")
    public ResponseEntity<List<Ingrediente>> traerIngredientes(){
        List<Ingrediente> listaIngredientes = new ArrayList<>();
        
        try {
            listaIngredientes = ingredientesService.traerIngredientes();
        } catch (Exception e) {
            return new ResponseEntity<>(listaIngredientes, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(!listaIngredientes.isEmpty())
            return new ResponseEntity<>(listaIngredientes, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/crearIngrediente")
    public ResponseEntity<Ingrediente> crearIngrediente(@RequestBody Ingrediente ingrediente){
        if(ingrediente.getNombreIngrediente() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        
        try {
            ingredientesService.crearIngredientes(ingrediente);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity<>(ingrediente, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/eliminarIngrediente/{idIngrediente}")
    public ResponseEntity<String> eliminarIngrediente(@PathVariable long idIngrediente){
        
        try {
            ingredientesService.eliminarIngrediente(idIngrediente);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Se eliminó el ingrediente #" + idIngrediente, HttpStatus.NO_CONTENT);   
    }
    
    @PutMapping("/actualizarIngrediente/{idIngrediente}")
    public ResponseEntity<Ingrediente> actualizarIngrediente(@PathVariable long idIngrediente,
                                                             @RequestBody Ingrediente ingrediente){
    
        if(ingrediente.getNombreIngrediente() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {
            ingredientesService.actualizarIngrediente(idIngrediente, ingrediente);
            ingrediente.setIdIngrediente(idIngrediente);
            return new ResponseEntity<>(ingrediente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("traerIngrediente/{idIngrediente}")
    public ResponseEntity<Ingrediente> traerIngrediente(@PathVariable long idIngrediente){
        Ingrediente ingrediente = new Ingrediente();
        
        try {
            ingrediente = ingredientesService.traerIngredientePorId(idIngrediente);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(ingrediente != null)
            return new ResponseEntity<>(ingrediente, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("traerIngredientesPorPlato/{nombrePlato}")
    public ResponseEntity<List<Ingrediente>> traerIngrediente(@PathVariable String nombrePlato){
        List<Ingrediente> ingredientesLista = new ArrayList<>();
        
        try {
            ingredientesLista = ingredientesService.traerIngredientePorNombrePlato(nombrePlato);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(!ingredientesLista.isEmpty())
            return new ResponseEntity<>(ingredientesLista, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
