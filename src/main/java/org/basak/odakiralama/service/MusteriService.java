package org.basak.odakiralama.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.basak.odakiralama.dto.request.MusteriRequestDto;
import org.basak.odakiralama.dto.response.MusteriResponseDto;
import org.basak.odakiralama.entity.Musteri;
import org.basak.odakiralama.exception.ErrorType;
import org.basak.odakiralama.exception.OdaKiralamaException;
import org.basak.odakiralama.mapper.MusteriMapper;
import org.basak.odakiralama.repository.MusteriRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MusteriService {
    private final MusteriRepository musteriRepository;

    @Transactional
    public MusteriResponseDto save(@Valid MusteriRequestDto musteriRequestDto) {
        if (musteriRepository.existsByTcKimlikNo(musteriRequestDto.tcKimlikNo())) {
            throw new OdaKiralamaException(ErrorType.MUSTERI_ALREADY_EXISTS);
        }
        Musteri entity = MusteriMapper.INSTANCE.toEntity(musteriRequestDto);
        return MusteriMapper.INSTANCE.toResponse(musteriRepository.save(entity));
    }
    //delete
    public boolean delete(Long id) {
        validateMusteri(id);
        musteriRepository.deleteById(id);
        return true;
    }
    private void validateMusteri(Long id) {
        if (!musteriRepository.existsById(id)) {
            throw new OdaKiralamaException(ErrorType.MUSTERI_NOT_FOUND);
        }
    }
    // soft delete
    public boolean softDelete(Long id) {
        Musteri musteri = musteriRepository.findById(id)
                .orElseThrow(() -> new OdaKiralamaException(ErrorType.MUSTERI_NOT_FOUND));
        musteri.setAktif(false);
        musteriRepository.save(musteri);
        return true;
    }
    // findAll
    public List<MusteriResponseDto> findAll() {
        List<Musteri> musteriList = musteriRepository.findAll();
        if (musteriList.isEmpty()) {
            throw new OdaKiralamaException(ErrorType.MUSTERI_LIST_EMPTY);
        }
        return musteriList.stream()
                .map(MusteriMapper.INSTANCE::toResponse)
                .toList();
    }
    //update
    public MusteriResponseDto update(Long musteriId, MusteriRequestDto dto) {
        Musteri musteri = musteriRepository.findById(musteriId)
                .orElseThrow(() -> new RuntimeException("Müşteri bulunamadı"));
        MusteriMapper.INSTANCE.updateMusteriFromDto(dto, musteri);
        Musteri savedMusteri = musteriRepository.save(musteri);
        return MusteriMapper.INSTANCE.toResponse(savedMusteri);
    }
    //findById
    public MusteriResponseDto findById(Long id) {
        return musteriRepository.findById(id)
                .map(MusteriMapper.INSTANCE::toResponse)
                .orElseThrow(() -> new OdaKiralamaException(ErrorType.MUSTERI_NOT_FOUND));
    }

    public Musteri findById2(Long id) {
        return musteriRepository.findMusteriById(id);
    }
}
