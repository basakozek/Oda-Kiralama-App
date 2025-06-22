package org.basak.odakiralama.mapper;

import org.basak.odakiralama.dto.request.KiralamaRequestDto;
import org.basak.odakiralama.dto.response.KiralamaResponseDto;
import org.basak.odakiralama.entity.Kiralama;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface KiralamaMapper {
    KiralamaMapper INSTANCE = Mappers.getMapper( KiralamaMapper.class);
    KiralamaResponseDto toResponse(Kiralama kiralama);
    Kiralama toEntity(KiralamaRequestDto kiralamaRequestDto);
    void updateKiralamaFromDto(KiralamaRequestDto dto, @MappingTarget Kiralama kiralama);

}
