
package com.lautajam.pokeapi.controller;

import com.lautajam.pokeapi.dto.PokemonDTO;
import com.lautajam.pokeapi.repository.PokeApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {
    
    @Autowired
    private PokeApiClient pokeApiClient;
    
    @GetMapping("/pokemon/{pokemonId}")
    public ResponseEntity<PokemonDTO> getPokemonInfo(@PathVariable ("pokemonId") int pokmeonId){
        try {
            return new ResponseEntity<>(pokeApiClient.getPokemonInfo(pokmeonId),
                                        HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
