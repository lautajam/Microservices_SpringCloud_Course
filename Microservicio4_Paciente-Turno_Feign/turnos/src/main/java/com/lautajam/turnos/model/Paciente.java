
package com.lautajam.turnos.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Paciente {
    
    private long idPaciente;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private String telefono;
    
}
