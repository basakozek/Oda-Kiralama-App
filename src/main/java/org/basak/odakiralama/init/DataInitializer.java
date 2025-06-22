package org.basak.odakiralama.init;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import org.basak.odakiralama.entity.Kiralama;
import org.basak.odakiralama.entity.Musteri;
import org.basak.odakiralama.entity.Oda;
import org.basak.odakiralama.enums.OdaDurum;
import org.basak.odakiralama.enums.OdaTipi;
import org.basak.odakiralama.enums.RezDurum;
import org.basak.odakiralama.repository.KiralamaRepository;
import org.basak.odakiralama.repository.MusteriRepository;
import org.basak.odakiralama.repository.OdaRepository;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final MusteriRepository musteriRepository;
    private final OdaRepository odaRepository;
    private final KiralamaRepository kiralamaRepository;

    @PostConstruct
    public void init() {
        if (musteriRepository.count() > 0 || odaRepository.count() > 0 || kiralamaRepository.count() > 0) {
            System.out.println("Veritabanında veri bulundu. Başlangıç verileri yüklenmedi.");
            return;
        }

        System.out.println("Başlangıç verileri yükleniyor...");

        createMusteriler();
        createOdalar();
        createKiralamalar();

        System.out.println("Başlangıç verileri başarıyla yüklendi.");
    }

    private void createMusteriler() {
        Musteri m1 = new Musteri(null, "Ahmet", "Yılmaz", "5551112233", "ahmet@gmail.com", 12345678901L, "Ankara",true, LocalDateTime.now());
        Musteri m2 = new Musteri(null, "Ayşe", "Demir", "5552223344", "ayse@gmail.com", 12345678902L, "İstanbul",true, LocalDateTime.now());
        Musteri m3 = new Musteri(null, "Zeynep", "Kara", "5553334455", "zeynep@gmail.com", 12345678903L, "İzmir",true, LocalDateTime.now());

        List<Musteri> musteriler = musteriRepository.saveAll(Arrays.asList(m1, m2, m3));
        System.out.println("Müşteriler eklendi. Toplam: " + musteriler.size());
    }

    private void createOdalar() {
        Oda o1 = new Oda(null, OdaTipi.STANDART, "101", 1, 2, new BigDecimal("750.00"), true, true, OdaDurum.BAKIMDA, false);
        Oda o2 = new Oda(null, OdaTipi.SUIT, "102", 1, 3, new BigDecimal("1250.00"), false, true, OdaDurum.DOLU, true);
        Oda o3 = new Oda(null, OdaTipi.DELUXE, "201", 2, 2, new BigDecimal("1000.00"), true, false, OdaDurum.MUSAIT, false);

        List<Oda> odalar = odaRepository.saveAll(Arrays.asList(o1, o2, o3));
        System.out.println("Odalar eklendi. Toplam: " + odalar.size());
    }

    private void createKiralamalar() {
        List<Musteri> musteriler = musteriRepository.findAll();
        List<Oda> odalar = odaRepository.findAll();

        if (musteriler.size() < 2 || odalar.size() < 2) {
            System.out.println("Kiralamalar için yeterli müşteri veya oda yok.");
            return;
        }

        Kiralama k1 = new Kiralama(null,
                odalar.get(0).getId(),
                musteriler.get(0).getId(),
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                LocalDate.now().minusDays(1),
                RezDurum.AKTIF,
                new BigDecimal("2250.00")
        );

        Kiralama k2 = new Kiralama(null,
                odalar.get(1).getId(),
                musteriler.get(1).getId(),
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(4),
                LocalDate.now(),
                RezDurum.IPTAL,
                new BigDecimal("3750.00")
        );

        List<Kiralama> kiralamalar = kiralamaRepository.saveAll(Arrays.asList(k1, k2));
        System.out.println("Kiralamalar eklendi. Toplam: " + kiralamalar.size());
    }
}
