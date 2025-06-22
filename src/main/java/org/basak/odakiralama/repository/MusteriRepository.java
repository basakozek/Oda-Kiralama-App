package org.basak.odakiralama.repository;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import org.basak.odakiralama.entity.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri, Long> {
    boolean existsByTcKimlikNo(Long tcKimlikNo);

    Musteri findMusteriById(Long id);
}
