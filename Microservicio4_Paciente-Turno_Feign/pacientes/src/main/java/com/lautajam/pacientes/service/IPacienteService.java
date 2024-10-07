/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lautajam.pacientes.service;

import com.lautajam.pacientes.model.Paciente;
import java.util.List;

public interface IPacienteService {

    public List<Paciente>getPacientes();
    
    public void savePaciente(Paciente paciente);
    
    public void deletePaciente(Long idPaciente);
    
    public Paciente findPaciente(Long dPaciente);
    
    public void updatedPaciente(Long idPaciente, Paciente paciente);
    
    public Paciente finPacienteByDni(String dniPaciente);
    
}
