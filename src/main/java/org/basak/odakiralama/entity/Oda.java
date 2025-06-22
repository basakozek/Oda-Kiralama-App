package org.basak.odakiralama.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.basak.odakiralama.enums.OdaDurum;
import org.basak.odakiralama.enums.OdaTipi;

import java.math.BigDecimal;

@Data //@ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_oda")
public class Oda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    OdaTipi odaTipi;
    String odaNo;
    int kat;
    int kapasite;
    BigDecimal gunlukFiyat;
    Boolean denizManzarali;
    Boolean balkonVar;
    OdaDurum odaDurum;
    Boolean jakuziVar;
}
