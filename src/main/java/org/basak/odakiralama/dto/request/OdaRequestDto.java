package org.basak.odakiralama.dto.request;

import jakarta.validation.constraints.*;

import org.basak.odakiralama.enums.OdaDurum;
import org.basak.odakiralama.enums.OdaTipi;

import java.math.BigDecimal;

public record OdaRequestDto(
        @NotNull(message = "Oda tipi boş olamaz")
OdaTipi odaTipi,

@NotBlank(message = "Oda numarası boş olamaz")
String odaNo,

@Min(value = 0, message = "Kat numarası negatif olamaz")
int kat,

@Min(value = 1, message = "Kapasite en az 1 olmalıdır")
int kapasite,

@NotNull(message = "Günlük fiyat boş olamaz")
@DecimalMin(value = "0.0", inclusive = false, message = "Günlük fiyat 0'dan büyük olmalıdır")
        BigDecimal gunlukFiyat,


Boolean denizManzarali,


Boolean balkonVar,

@NotNull(message = "Oda durumu boş olamaz")
        OdaDurum odaDurum,

Boolean jakuziVar
) {
}
