
package com.lautajam.Plato.controller;

import com.lautajam.Plato.service.IPlatoService;
import java.util.List;
import com.lautajam.Plato.model.Plato;
import java.util.ArrayList;
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
@RequestMapping("/platos")
public class PlatoController {
    
    @Autowired
    private IPlatoService platoService;
    
    @GetMapping("/traerPlatos")
    public ResponseEntity<List<Plato>> traerPlatos(){
        List<Plato> listaPlatos = new ArrayList<>();
        
        try{
            listaPlatos = platoService.traerPlatos();
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(!listaPlatos.isEmpty())
            return new ResponseEntity<>(listaPlatos, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/crearPlato")
    public ResponseEntity<Plato> crearPlato(@RequestBody Plato plato){
        
        try {
            if(plato.getNombrePlato().isEmpty())
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
            Plato platoNuevo = platoService.crearPlato(plato);      
            return new ResponseEntity<>(platoNuevo,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/eliminarPlato/{idPlato}")
    public ResponseEntity<String> eliminarPlato(@PathVariable long idPlato){
       
        try {
            platoService.eliminarPlato(idPlato);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        
        return new ResponseEntity<>("Se eliminó el plato #" + idPlato,HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/actualizarPlato/{idPlato}")
    public ResponseEntity<Plato> actualizarPlato(@PathVariable long idPlato,
                                                 @RequestBody Plato plato){
        try{
            if(plato.getNombrePlato() == null)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            platoService.actualizarPlato(idPlato, plato);
            plato.setIdPlato(idPlato);
            return new ResponseEntity<>(plato, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/traerPlato/{idPlato}")
    public ResponseEntity<Plato> traerPlato(@PathVariable long idPlato){
        Plato platoTraido = new Plato();
        try{
            platoTraido = platoService.traerPlatoPorNumero(idPlato);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        if(!platoTraido.getNombrePlato().isEmpty())
            return new ResponseEntity<>(platoTraido, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
