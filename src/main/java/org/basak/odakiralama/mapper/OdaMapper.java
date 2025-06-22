package org.basak.odakiralama.mapper;
import org.basak.odakiralama.dto.request.OdaRequestDto;
import org.basak.odakiralama.dto.response.OdaResponseDto;
import org.basak.odakiralama.entity.Oda;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OdaMapper {
    OdaMapper INSTANCE = Mappers.getMapper(OdaMapper.class);
    OdaResponseDto toResponse(Oda oda);
    Oda toEntity(OdaRequestDto odaRequestDto);
    void updateOdaFromDto(OdaRequestDto dto, @MappingTarget Oda oda);

}
