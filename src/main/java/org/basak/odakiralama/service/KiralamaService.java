package org.basak.odakiralama.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.basak.odakiralama.dto.request.KiralamaRequestDto;
import org.basak.odakiralama.dto.request.OdaRequestDto;
import org.basak.odakiralama.dto.response.KiralamaResponseDto;
import org.basak.odakiralama.dto.response.MusteriResponseDto;
import org.basak.odakiralama.dto.response.OdaResponseDto;
import org.basak.odakiralama.entity.Kiralama;
import org.basak.odakiralama.entity.Musteri;
import org.basak.odakiralama.entity.Oda;
import org.basak.odakiralama.enums.OdaDurum;
import org.basak.odakiralama.enums.RezDurum;
import org.basak.odakiralama.exception.ErrorType;
import org.basak.odakiralama.exception.OdaKiralamaException;
import org.basak.odakiralama.mapper.KiralamaMapper;
import org.basak.odakiralama.repository.KiralamaRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class KiralamaService {
    private final KiralamaRepository kiralamaRepository;
    private final MusteriService musteriService;
    private final OdaService odaService;

    @Transactional
    public KiralamaResponseDto createReservation(KiralamaRequestDto request) {
        Musteri musteri = musteriService.findById2(request.musteriId());
        Oda oda = odaService.findById2(request.odaId());

        if (!oda.getOdaDurum().equals(OdaDurum.MUSAIT)) {
            throw new OdaKiralamaException(ErrorType.ODA_MUSAIT_DEGIL);
        }
        long gunSayisi = ChronoUnit.DAYS.between(request.girisTarihi(), request.cikisTarihi());
        if (gunSayisi <= 0) {
            throw new OdaKiralamaException(ErrorType.GECERSIZ_TARIH_ARALIGI);
        }
        BigDecimal toplamUcret = oda.getGunlukFiyat().multiply(BigDecimal.valueOf(gunSayisi));
        Kiralama kiralama = KiralamaMapper.INSTANCE.toEntity(request);
        kiralama.setMusteriId(musteri.getId());
        kiralama.setOdaId(oda.getId());
        kiralama.setRezTarihi(LocalDate.now());
        kiralama.setRezDurum(RezDurum.AKTIF);
        kiralama.setToplamUcret(toplamUcret);
        oda.setOdaDurum(OdaDurum.DOLU);
        odaService.save2(oda);
        return KiralamaMapper.INSTANCE.toResponse(kiralamaRepository.save(kiralama));
    }


}
