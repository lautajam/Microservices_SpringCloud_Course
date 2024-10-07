/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.Ingrediente.service;

import com.lautajam.Ingrediente.model.Ingrediente;
import com.lautajam.Ingrediente.repository.IIngredientesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService implements IIngredientesService{

    @Autowired
    private IIngredientesRepository ingredienteRepository;
    
    @Override
    public List<Ingrediente> traerIngredientes() {
        return ingredienteRepository.findAll();
    }

    @Override
    public void crearIngredientes(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
    }

    @Override
    public void eliminarIngrediente(long idIngrediente) {
        ingredienteRepository.deleteById(idIngrediente);
    }

    @Override
    public Ingrediente actualizarIngrediente(long idIngrediente, Ingrediente ingrediente) {
        Ingrediente ingredienteExistente = this.traerIngredientePorId(idIngrediente);
        
        if(ingredienteExistente.getNombreIngrediente() != null){
            ingredienteExistente.setNombreIngrediente(ingrediente.getNombreIngrediente());
            ingredienteExistente.setListaPlatos(ingrediente.getListaPlatos());
            ingredienteRepository.save(ingredienteExistente);
        }
        
        return ingredienteExistente;
    }

    @Override
    public Ingrediente traerIngredientePorId(long idIngrediente) {
        return ingredienteRepository.findById(idIngrediente).orElse(null);
    }

    @Override
    public List<Ingrediente> traerIngredientePorNombrePlato(String nombrePlato) {
        return ingredienteRepository.findByNombre(nombrePlato);
    }
    
    
    
}
