package org.basak.odakiralama.dto.response;

import org.basak.odakiralama.enums.RezDurum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record KiralamaResponseDto(
        Long id,
        Long odaId,
        Long musteriId,
        LocalDate girisTarihi,
        LocalDate cikisTarihi,
        LocalDate rezTarihi,
        RezDurum rezDurum,
        BigDecimal toplamUcret
) {
}
