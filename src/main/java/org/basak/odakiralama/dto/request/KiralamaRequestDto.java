package org.basak.odakiralama.dto.request;

import jakarta.validation.constraints.*;
import org.basak.odakiralama.enums.RezDurum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record KiralamaRequestDto(

        @NotNull(message = "Oda ID boş olamaz")
        Long odaId,

        @NotNull(message = "Müşteri ID boş olamaz")
        Long musteriId,

        @NotNull(message = "Giriş tarihi boş olamaz")
        LocalDate girisTarihi,

        @NotNull(message = "Çıkış tarihi boş olamaz")
        LocalDate cikisTarihi,

        @NotNull(message = "Rezervasyon tarihi boş olamaz")
        LocalDate rezTarihi,

        @NotNull(message = "Rezervasyon durumu boş olamaz")
        RezDurum rezDurum,

        @DecimalMin(value = "0.0", inclusive = false, message = "Toplam ücret 0'dan büyük olmalıdır")
        BigDecimal toplamUcret

) {}

