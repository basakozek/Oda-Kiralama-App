package org.basak.odakiralama.dto.request;
import jakarta.validation.constraints.*;

public record MusteriRequestDto(

        @NotBlank(message = "Ad boş olamaz")
        String ad,

        @NotBlank(message = "Soyad boş olamaz")
        String soyad,

        @NotBlank(message = "Telefon numarası boş olamaz")
        @Pattern(regexp = "^\\+?\\d{10,15}$", message = "Geçerli bir telefon numarası giriniz")
        String telefon,

        @NotBlank(message = "Email boş olamaz")
        @Email(message = "Geçerli bir e-posta adresi giriniz")
        String email,

        @Digits(integer = 11, fraction = 0, message = "TC Kimlik No 11 haneli sayısal olmalıdır")
        Long tcKimlikNo,

        @NotBlank(message = "Adres boş olamaz")
        String adres

) {}
