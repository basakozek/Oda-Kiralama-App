package org.basak.odakiralama.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.basak.odakiralama.dto.request.MusteriRequestDto;
import org.basak.odakiralama.dto.response.BaseResponse;
import org.basak.odakiralama.dto.response.MusteriResponseDto;
import org.basak.odakiralama.service.MusteriService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.basak.odakiralama.constant.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(MUSTERI)
public class MusteriController {
    private final MusteriService musteriService;
    @PostMapping(SAVE)
    public ResponseEntity<BaseResponse<MusteriResponseDto>> save(@RequestBody @Valid MusteriRequestDto musteriRequestDto) {
        MusteriResponseDto savedMusteri=musteriService.save(musteriRequestDto);
        BaseResponse<MusteriResponseDto> response = BaseResponse.<MusteriResponseDto>builder()
                .success(true)
                .message("Musteri eklendi.")
                .code(HttpStatus.CREATED.value())
                .data(savedMusteri)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping(DELETE)
    public ResponseEntity<BaseResponse<Void>> delete(Long id) {
        musteriService.delete(id);
        return ResponseEntity.status(HttpStatus.OK) //NO_CONTENT ile içerik geri dönüşü engellenebilir.
                .body(BaseResponse.<Void>builder()
                        .success(true)
                        .code(200)
                        .message("Müşteri başarıyla silindi.")
                        .build());
    }
    // soft delete
    @DeleteMapping("/soft-delete")
    public ResponseEntity<BaseResponse<Void>> softDelete( Long id) {
        musteriService.softDelete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.<Void>builder()
                        .success(true)
                        .code(200)
                        .message("Müşteri başarıyla pasif hale getirildi (soft delete).")
                        .build());
    }

    @GetMapping(FINDALL)
    public ResponseEntity<BaseResponse<List<MusteriResponseDto>>> findAll() {
        List<MusteriResponseDto> musteriler = musteriService.findAll();
        BaseResponse<List<MusteriResponseDto>> response = BaseResponse.<List<MusteriResponseDto>>builder()
                .success(true)
                .message("Müşteri listesi getirildi.")
                .code(HttpStatus.OK.value())
                .data(musteriler)
                .build();
        return ResponseEntity.ok(response);
    }
    @PatchMapping(UPDATE)
    public ResponseEntity<BaseResponse<MusteriResponseDto>> updateMusteri(Long id,
        @RequestBody @Valid MusteriRequestDto musteriRequestDto) {
        MusteriResponseDto updatedMusteri = musteriService.update(id, musteriRequestDto);
        return ResponseEntity.ok(BaseResponse.<MusteriResponseDto>builder()
                .success(true)
                .code(200)
                .message("Müşteri başarıyla güncellendi.")
                .data(updatedMusteri)
                .build());

    }
    @GetMapping(FINDBYID)
    public ResponseEntity<BaseResponse<MusteriResponseDto>> getById(Long id) {
        MusteriResponseDto musteri = musteriService.findById(id);
        return ResponseEntity.ok(BaseResponse.<MusteriResponseDto>builder()
                .success(true)
                .code(200)
                .message("Müşteri başarıyla bulundu.")
                .data(musteri)
                .build());
    }
}
