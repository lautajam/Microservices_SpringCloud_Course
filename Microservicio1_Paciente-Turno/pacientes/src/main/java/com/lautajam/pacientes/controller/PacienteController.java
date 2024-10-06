
package com.lautajam.pacientes.controller;

import com.lautajam.pacientes.service.IPacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lautajam.pacientes.model.Paciente;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    @Autowired
    private IPacienteService pacienteService;
    
    @GetMapping("/traerPacientes")
    public List<Paciente> traerPacientes(){
        return pacienteService.getPacientes();
    }
    
    @PostMapping("/crearPaciente")
    public void crearPaciente(@RequestBody Paciente paciente){
        pacienteService.savePaciente(paciente);
    }
    
    @DeleteMapping("/eliminarPaciente/{idPaciente}")
    public void eliminarPaciente(@PathVariable Long idPaciente){
        pacienteService.deletePaciente(idPaciente);
    }
    
    @PutMapping("/actualizarPaciente/{idPaciente}")
    public Paciente actualizarPaciente(@PathVariable Long idPaciente,
                                   @RequestBody Paciente paciente){
        
        pacienteService.updatedPaciente(idPaciente, paciente);
        Paciente pacienteEditado = pacienteService.findPaciente(idPaciente);
        
        return pacienteEditado;
    }
    
    @GetMapping("/taerPacienteByDni/{dniPaciente}")
    public Paciente traerPacienteByDni(@PathVariable String dniPaciente){
        return pacienteService.finPacienteByDni(dniPaciente);
    }
}
