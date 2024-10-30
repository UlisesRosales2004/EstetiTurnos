
package com.rosales.EstetiTurnos.repository;

import com.rosales.EstetiTurnos.model.Turno;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno,Long> {
    List<Turno> findByFecha(LocalDate fecha);
}
