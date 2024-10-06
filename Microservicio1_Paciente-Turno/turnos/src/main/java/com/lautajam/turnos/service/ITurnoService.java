
package com.lautajam.turnos.service;

import com.lautajam.turnos.model.Turno;
import java.time.LocalDate;
import java.util.List;

public interface ITurnoService {
    
    public List<Turno>getTurnos();
    
    public void saveTurno(LocalDate fecha, String tratamiento, String dniPaciente);
    
    public void deleteTurno(Long idTurno);
    
    public Turno findTurno(Long idTurno);
    
    public void updatedTurno(Long idTurno, Turno turno);
}
