package org.basak.odakiralama.mapper;

import org.basak.odakiralama.dto.request.MusteriRequestDto;
import org.basak.odakiralama.dto.response.MusteriResponseDto;
import org.basak.odakiralama.entity.Musteri;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MusteriMapper {
    MusteriMapper INSTANCE = Mappers.getMapper( MusteriMapper.class);

    MusteriResponseDto toResponse(Musteri musteri);
    Musteri toEntity(MusteriRequestDto musteriRequestDto);
    void updateMusteriFromDto(MusteriRequestDto dto, @MappingTarget Musteri musteri);

}
