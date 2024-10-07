package com.lautajam.turnos.controller;

import com.lautajam.turnos.dto.PacienteDTO;
import com.lautajam.turnos.dto.TurnoDto;
import com.lautajam.turnos.service.ITurnoService;
import java.util.List;
import com.lautajam.turnos.model.Turno;
import com.lautajam.turnos.repository.PacienteApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoService turnoService;

    @GetMapping("/traerTurnos")
    public List<Turno> traerTurnos() {
        return turnoService.getTurnos();
    }

    @PostMapping("/crearTurno")
    public void crearTurno(@RequestBody TurnoDto turnodto) {

        turnoService.saveTurno(turnodto.getFecha(),
                turnodto.getTratamiento(),
                turnodto.getDniPaciente());
    }

    @DeleteMapping("/eliminarTurno/{idTurno}")
    public void eliminarTurno(@PathVariable Long idTurno) {
        turnoService.deleteTurno(idTurno);
    }

    @GetMapping("/traerTurno/{idTurno}")
    public Turno traerTurno(@PathVariable Long idTurno) {
        return turnoService.findTurno(idTurno);
    }

    @PutMapping("/actualizarTurno/{idTurno}")
    public Turno actualizarTurno(@PathVariable Long idTurno,
            @RequestBody Turno turno) {

        turnoService.updatedTurno(idTurno, turno);
        Turno turnoEditado = turnoService.findTurno(idTurno);

        return turnoEditado;
    }

    @Autowired
    private PacienteApiClient pacienteApiClient;

    @GetMapping("/taerPacienteByDni/{dniPaciente}")
    public PacienteDTO traerPacienteInfo(@PathVariable("dniPaciente") String dniPaciente) {
        return pacienteApiClient.traerPacienteInfo(dniPaciente);
    }
}
