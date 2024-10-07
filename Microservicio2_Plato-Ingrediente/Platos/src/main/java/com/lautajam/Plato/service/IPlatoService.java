
package com.lautajam.Plato.service;

import com.lautajam.Plato.model.Plato;
import java.util.List;

public interface IPlatoService {

    public List<Plato> traerPlatos();
    
    public void crearPlato(Plato plato);
    
    public void eliminarPlato(long idPlato);
    
    public Plato actualizarPlato(long idPlato, Plato plato);
    
    public Plato traerPlatoPorNumero(long idPlato);
}
