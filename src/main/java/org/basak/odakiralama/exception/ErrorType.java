package org.basak.odakiralama.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;



@AllArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_SERVER_ERROR(500,"SUNUCUDA BEKLENMEYEN HATA.",HttpStatus.INTERNAL_SERVER_ERROR),
    VALIDATION_ERROR(400,"Girilen parametreler hatalıdır. Kontrol ediniz.",HttpStatus.BAD_REQUEST),
    JSON_CONVERT_ERROR(300,"Girilen parametreler hatalıdır. Json Dönüşüm Hatası.",HttpStatus.BAD_REQUEST),
    MUSTERI_NOT_FOUND(5001,"Müşteri bulunamadı",HttpStatus.BAD_REQUEST),
    MUSTERI_ALREADY_EXISTS(5002,"Bu müşteri daha önce eklenmiş.",HttpStatus.BAD_REQUEST),
    MUSTERI_LIST_EMPTY(5005,"Müşteri bulunamadı" , HttpStatus.BAD_REQUEST ),
    ODA_ALREADY_EXISTS(5006,"Bu oda daha önce eklenmiş." ,HttpStatus.BAD_REQUEST ),
    ODA_LIST_EMPTY(5007,"Hiç oda bulunamadı" , HttpStatus.BAD_REQUEST ),
    ODA_NOT_FOUND(5008,"Oda bulunamadı" , HttpStatus.BAD_REQUEST ),
    ODA_DOLU(5009,"İstenen oda dolu" , HttpStatus.BAD_REQUEST ),
    GECERSIZ_TARIH_ARALIGI(5010,"Geçersiz tarih aralığı" ,HttpStatus.BAD_REQUEST ),
    ODA_MUSAIT_DEGIL(5011,"İstenen oda müsait değil" ,HttpStatus.BAD_REQUEST ),;

    int code;
    String message;
    HttpStatus httpStatus;
}

