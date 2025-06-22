package org.basak.odakiralama.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.basak.odakiralama.dto.request.MusteriRequestDto;
import org.basak.odakiralama.dto.request.OdaRequestDto;
import org.basak.odakiralama.dto.response.BaseResponse;
import org.basak.odakiralama.dto.response.MusteriResponseDto;
import org.basak.odakiralama.dto.response.OdaResponseDto;
import org.basak.odakiralama.service.OdaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.basak.odakiralama.constant.EndPoints.*;
@RestController
@RequiredArgsConstructor
@RequestMapping(ODA)
public class OdaController {
    private final OdaService odaService;

    @PostMapping(SAVE)
    public ResponseEntity<BaseResponse<OdaResponseDto>> save(@RequestBody @Valid OdaRequestDto odaRequestDto) {
        OdaResponseDto savedOda=odaService.save(odaRequestDto);
        BaseResponse<OdaResponseDto> response = BaseResponse.<OdaResponseDto>builder()
                .success(true)
                .message("Oda eklendi.")
                .code(HttpStatus.CREATED.value())
                .data(savedOda)
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(FINDALL)
    public ResponseEntity<BaseResponse<List<OdaResponseDto>>> findAll() {
        List<OdaResponseDto> odalar = odaService.findAll();
        BaseResponse<List<OdaResponseDto>> response = BaseResponse.<List<OdaResponseDto>>builder()
                .success(true)
                .message("Oda listesi getirildi.")
                .code(HttpStatus.OK.value())
                .data(odalar)
                .build();
        return ResponseEntity.ok(response);
    }
}
