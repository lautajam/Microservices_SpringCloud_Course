
package com.lautajam.libros.repository;

import com.lautajam.libros.model.Autor;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "apiAutoresClient", url="http://localhost:9001/autores")
public interface ApiAutoresClient {
    
    @GetMapping("/getAutoresByIdBook/{idBook}")
    public List<Autor> getAutoresByIdBook(@PathVariable ("idBook") Long idBook);
}
