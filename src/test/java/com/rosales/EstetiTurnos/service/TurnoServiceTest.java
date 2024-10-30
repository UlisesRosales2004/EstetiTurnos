package com.rosales.EstetiTurnos.service;

import com.rosales.EstetiTurnos.model.Turno;
import com.rosales.EstetiTurnos.repository.ITurnoRepository;
import com.rosales.EstetiTurnos.service.TurnoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @MockBean
    private ITurnoRepository turnoRepo;

    @Test
    public void testAgendarTurno_exito() {
        Turno turno = new Turno(null, LocalDate.now(), LocalTime.of(9, 0), "Cliente", "123456789", List.of());

        when(turnoRepo.save(any(Turno.class))).thenReturn(turno);

        Turno resultado = turnoService.AgendarTurno(turno);

        assertNotNull(resultado);
        assertEquals("Cliente", resultado.getCliente_nombre());
    }

    @Test
    public void testVerificarDisponibilidad_conflicto() {
        Turno turnoExistente = new Turno(1L, LocalDate.now(), LocalTime.of(9, 0), "Cliente1", "123456789", List.of());
        turnoExistente.setHora_fin(LocalTime.of(10, 0));

        when(turnoRepo.findByFecha(any(LocalDate.class))).thenReturn(List.of(turnoExistente));

        Turno nuevoTurno = new Turno(null, LocalDate.now(), LocalTime.of(9, 30), "Cliente2", "987654321", List.of());
        nuevoTurno.setHora_fin(LocalTime.of(10, 30));

        boolean disponible = turnoService.VerificarDisponibilidad(nuevoTurno);

        assertFalse(disponible);
    }
}
