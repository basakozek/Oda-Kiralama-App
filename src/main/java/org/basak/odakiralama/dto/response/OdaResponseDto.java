package org.basak.odakiralama.dto.response;

import org.basak.odakiralama.enums.OdaDurum;
import org.basak.odakiralama.enums.OdaTipi;

import java.math.BigDecimal;

public record OdaResponseDto(
        Long id,
        OdaTipi odaTipi,
        String odaNo,
        int kat,
        int kapasite,
        BigDecimal gunlukFiyat,
        Boolean denizManzarali,
        Boolean balkonVar,
        OdaDurum odaDurum,
        Boolean jakuziVar
) {
}
