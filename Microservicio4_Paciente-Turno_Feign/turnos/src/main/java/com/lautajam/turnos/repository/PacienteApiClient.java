
package com.lautajam.turnos.repository;

import com.lautajam.turnos.dto.PacienteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacienteApi", url = "http://localhost:9001/pacientes")
public interface PacienteApiClient {
    @GetMapping("/taerPacienteByDni/{dniPaciente}")
    public PacienteDTO traerPacienteInfo(@PathVariable ("dniPaciente") String dniPaciente);
}
