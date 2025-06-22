package org.basak.odakiralama.dto.response;

public record MusteriResponseDto(
        Long id,
        String ad,
        String soyad,
        String telefon,
        String email,
        Long tcKimlikNo,
        String adres
) {
}
