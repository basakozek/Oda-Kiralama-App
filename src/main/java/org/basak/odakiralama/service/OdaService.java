package org.basak.odakiralama.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.basak.odakiralama.dto.request.MusteriRequestDto;
import org.basak.odakiralama.dto.request.OdaRequestDto;
import org.basak.odakiralama.dto.response.MusteriResponseDto;
import org.basak.odakiralama.dto.response.OdaResponseDto;
import org.basak.odakiralama.entity.Musteri;
import org.basak.odakiralama.entity.Oda;
import org.basak.odakiralama.exception.ErrorType;
import org.basak.odakiralama.exception.OdaKiralamaException;
import org.basak.odakiralama.mapper.MusteriMapper;
import org.basak.odakiralama.mapper.OdaMapper;
import org.basak.odakiralama.repository.OdaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OdaService {
    private final OdaRepository odaRepository;
    @Transactional
    public OdaResponseDto save(@Valid OdaRequestDto odaRequestDto) {
        if (odaRepository.existsByOdaNo(odaRequestDto.odaNo())) {
            throw new OdaKiralamaException(ErrorType.ODA_ALREADY_EXISTS);
        }
        Oda entity = OdaMapper.INSTANCE.toEntity(odaRequestDto);
        return OdaMapper.INSTANCE.toResponse(odaRepository.save(entity));
    }
    // findAll
    public List<OdaResponseDto> findAll() {
        List<Oda> odaList = odaRepository.findAll();
        if (odaList.isEmpty()) {
            throw new OdaKiralamaException(ErrorType.ODA_LIST_EMPTY);
        }
        return odaList.stream()
                .map(OdaMapper.INSTANCE::toResponse)
                .toList();
    }

    public OdaResponseDto findById(Long id) {
        return odaRepository.findById(id)
                .map(OdaMapper.INSTANCE::toResponse)
                .orElseThrow(() -> new OdaKiralamaException(ErrorType.ODA_NOT_FOUND));
    }

    public Oda findById2(Long id) {
        return odaRepository.findOdaById(id);
    }

    public Oda save2(Oda oda) {
        return odaRepository.save(oda);
    }
}
