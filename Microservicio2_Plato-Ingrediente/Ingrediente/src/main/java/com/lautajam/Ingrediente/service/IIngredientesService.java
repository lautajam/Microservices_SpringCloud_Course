
package com.lautajam.Ingrediente.service;

import com.lautajam.Ingrediente.model.Ingrediente;
import java.util.List;

public interface IIngredientesService {
    
    public List<Ingrediente> traerIngredientes();
    
    public void crearIngredientes(Ingrediente ingrediente);
    
    public void eliminarIngrediente(long idIngrediente);
    
    public Ingrediente actualizarIngrediente(long idIngrediente, Ingrediente ingrediente);
    
    public Ingrediente traerIngredientePorId(long idIngrediente);
    
    public List<Ingrediente> traerIngredientePorNombrePlato(String nombrePlato);
    
}
