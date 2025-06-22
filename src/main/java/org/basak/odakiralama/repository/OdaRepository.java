package org.basak.odakiralama.repository;

import jakarta.validation.constraints.NotBlank;
import org.basak.odakiralama.entity.Oda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdaRepository extends JpaRepository<Oda, Long> {
    boolean existsByOdaNo(String odaNo);

    Oda findOdaById(Long id);
}
