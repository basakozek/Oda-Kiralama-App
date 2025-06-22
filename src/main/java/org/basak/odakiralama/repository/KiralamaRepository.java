package org.basak.odakiralama.repository;

import org.basak.odakiralama.entity.Kiralama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KiralamaRepository extends JpaRepository<Kiralama, Long> {
}
