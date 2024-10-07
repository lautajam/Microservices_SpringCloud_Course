/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.turnos.service;

import com.lautajam.turnos.model.Paciente;
import com.lautajam.turnos.model.Turno;
import com.lautajam.turnos.repository.ITurnoRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TurnoService implements ITurnoService{
    
    //@Autowired
    //private RestTemplate apiConsumir;
    
    @Autowired
    private ITurnoRepository turnoRepository;
    
    @Override
    public List<Turno> getTurnos() {
        return turnoRepository.findAll();
    }

    @Override
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente) {
        
    /*    Paciente paciente = apiConsumir.getForObject("http://localhost:9001/pacientes/taerPacienteByDni/"+dniPaciente, 
                                                     Paciente.class);
        
        String nombreCompletoPaciente = paciente.getNombre() + " " + paciente.getApellido();
        
        Turno turno = new Turno();
        
        turno.setFecha(fecha);
        turno.setTratamiento(tratamiento);
        turno.setNombreCompletoPaciente(nombreCompletoPaciente);
        
        turnoRepository.save(turno);*/
    }

    @Override
    public void deleteTurno(Long idTurno) {
        turnoRepository.deleteById(idTurno);
    }

    @Override
    public Turno findTurno(Long idTurno) {
        return turnoRepository.findById(idTurno).orElse(null);
    }

    @Override
    public void updatedTurno(Long idTurno, Turno turno) {
        Turno turnoExistente = this.findTurno(idTurno);
    
        if (turnoExistente != null) {
            turnoExistente.setFecha(turno.getFecha());
            turnoExistente.setNombreCompletoPaciente(turno.getNombreCompletoPaciente());            
            turnoExistente.setTratamiento(turno.getTratamiento());

            turnoRepository.save(turnoExistente);
        }
    }
}
