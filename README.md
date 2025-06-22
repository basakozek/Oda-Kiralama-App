OdaKiralamaApp, Spring Boot tabanlı, oda kiralama süreçlerini yöneten RESTful API uygulamasıdır. Müşteri ve oda yönetimi, rezervasyon işlemleri ve durum takibi gibi temel işlevleri sağlamaktadır. Proje, doğrulama, hata yönetimi, veri dönüşümü ve API dokümantasyonu gibi modern yazılım geliştirme yaklaşımlarını entegre etmektedir.

Temel Özellikler
- Müşteri Yönetimi: Müşteri kayıt, güncelleme, silme (soft delete dahil) ve listeleme işlemleri.
- Oda Yönetimi: Oda ekleme, listeleme ve durum takibi (müsait/dolu).
- Rezervasyon Yönetimi: Müşteri ve oda bazlı rezervasyon oluşturma, tarih doğrulama ve toplam ücret hesaplama.
- Durum Kontrolü: Oda müsaitlik kontrolü, doluluk durumu güncelleme.
- Hata Yönetimi: Global exception handling ile detaylı hata mesajları ve validasyon kontrolleri.
- DTO & Entity Mapping: MapStruct kullanılarak entity ve DTO nesneleri arası dönüşüm.
- API Dokümantasyonu: SpringDoc OpenAPI entegrasyonu ile Swagger UI üzerinden API keşfi ve test.
- Veri Tabanı: PostgreSQL ile veri kalıcılığı.
- Validasyon: Jakarta Validation API ile istek doğrulamaları.

Kullanılan Teknolojiler:
- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- PostgreSQL
- MapStruct
- SpringDoc OpenAPI (Swagger UI)
- Jakarta Validation
- Lombok
