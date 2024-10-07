package com.lautajam.Plato.service;

import com.lautajam.Plato.model.Ingrediente;
import com.lautajam.Plato.model.Plato;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.Plato.repository.IPlatoRepository;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    private IPlatoRepository platoRepository;

    @Autowired
    private RestTemplate apiIngredientes;

    @Override
    public List<Plato> traerPlatos() {
        return platoRepository.findAll();
    }

    @Override
    public void crearPlato(Plato plato) {

        List<Ingrediente> listaIngredientes = new ArrayList<>();

        try {
            String urlApiIngredientes = "http://localhost:9002/ingredientes/traerIngredientesPorPlato/"
                    + plato.getNombrePlato();

            //System.out.println("urlApiIngredientes: " + urlApiIngredientes);

            listaIngredientes = apiIngredientes.getForObject(urlApiIngredientes, List.class);

            System.out.println("listaIngredientes: " + listaIngredientes);

        } catch (Exception e) {
            listaIngredientes = null;
        }

        Plato platoNuevo = new Plato(plato.getNombrePlato(),
                                     plato.getPrecioPlato(),
                                     plato.getDescripcionPlato());

        if (listaIngredientes.isEmpty()) {
            platoNuevo.setListaIngredientes(null);
            platoRepository.save(plato);
            return;
        }

        List<String> nombresIngredientes = new ArrayList<>();
        System.out.println("listaIngredientes: " + listaIngredientes);
        
        for (Object ingrediente : listaIngredientes) {
            Map<String, Object> ingMap = (Map<String, Object>) ingrediente; // Hacemos un casting a Map
            nombresIngredientes.add((String) ingMap.get("nombreIngrediente")); // Accedemos al valor
        }
        
        System.out.println("nombresIngredientes: " + nombresIngredientes);
        
        platoNuevo.setListaIngredientes(nombresIngredientes);
        
        System.out.println("platoNuevo: " + platoNuevo.toString());

        platoRepository.save(plato);
    }

    @Override
    public void eliminarPlato(long idPlato) {
        platoRepository.deleteById(idPlato);
    }

    @Override
    public Plato traerPlatoPorNumero(long idPlato) {
        return platoRepository.findById(idPlato).orElse(null);
    }

    @Override
    public Plato actualizarPlato(long idPlato, Plato plato) {
        Plato platoExistente = this.traerPlatoPorNumero(idPlato);

        if (platoExistente != null) {
            platoExistente.setNombrePlato(plato.getNombrePlato());
            platoExistente.setPrecioPlato(plato.getPrecioPlato());
            platoExistente.setDescripcionPlato(plato.getDescripcionPlato());

            platoRepository.save(platoExistente);
        }

        return platoExistente;
    }

}
