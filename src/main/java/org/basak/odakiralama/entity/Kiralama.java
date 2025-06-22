package org.basak.odakiralama.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.basak.odakiralama.enums.OdaTipi;
import org.basak.odakiralama.enums.RezDurum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_kiralama")
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long odaId;
    Long musteriId;
    LocalDate girisTarihi;
    LocalDate cikisTarihi;
    LocalDate rezTarihi;
    RezDurum rezDurum;
    BigDecimal toplamUcret;

}
