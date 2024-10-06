/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lautajam.pacientes.service;

import com.lautajam.pacientes.model.Paciente;
import com.lautajam.pacientes.repository.IPacienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    private IPacienteRepository pacienteRepository;
    
    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public void savePaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(Long idPaciente) {
        pacienteRepository.deleteById(idPaciente);
    }

    @Override
    public Paciente findPaciente(Long idPaciente) {
        return pacienteRepository.findById(idPaciente).orElse(null);
    }

    @Override
    public void updatedPaciente(Long idPaciente, Paciente paciente) {
        Paciente pacienteExistente = this.findPaciente(idPaciente);
    
        if (pacienteExistente != null) {
            pacienteExistente.setNombre(paciente.getNombre());
            pacienteExistente.setApellido(paciente.getApellido());            
            pacienteExistente.setDni(paciente.getDni());
            pacienteExistente.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteExistente.setTelefono(paciente.getTelefono());

            this.savePaciente(pacienteExistente);
        }

    }

    @Override
    public Paciente finPacienteByDni(String dniPaciente) {
        return pacienteRepository.findByDni(dniPaciente);
    }
    
    
}

