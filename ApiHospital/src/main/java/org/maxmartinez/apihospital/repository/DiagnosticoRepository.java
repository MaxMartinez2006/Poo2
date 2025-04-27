package org.maxmartinez.apihospital.repository;

import org.maxmartinez.apihospital.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico, Long> {
}
