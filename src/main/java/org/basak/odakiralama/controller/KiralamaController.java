package org.basak.odakiralama.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.basak.odakiralama.dto.request.KiralamaRequestDto;
import org.basak.odakiralama.dto.response.BaseResponse;
import org.basak.odakiralama.dto.response.KiralamaResponseDto;
import org.basak.odakiralama.service.KiralamaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.basak.odakiralama.constant.EndPoints.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(KIRALAMA)
public class KiralamaController {
    private final KiralamaService kiralamaService;

    @PostMapping("/kiralama")
    public ResponseEntity<BaseResponse<KiralamaResponseDto>> createReservation(
            @RequestBody @Valid KiralamaRequestDto request) {

        KiralamaResponseDto responseDto = kiralamaService.createReservation(request);

        BaseResponse<KiralamaResponseDto> response = BaseResponse.<KiralamaResponseDto>builder()
                .success(true)
                .message("Rezervasyon başarıyla oluşturuldu.")
                .code(HttpStatus.CREATED.value())
                .data(responseDto)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
