package ee.valiit.groomlyback.persistence.groomerprocedure;

import ee.valiit.groomlyback.controller.groomerprocedure.dto.GroomerProcedureDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroomerProcedureMapper {
    GroomerProcedure toGroomerProcedureEntity(GroomerProcedureDto groomerProcedureDto);

    GroomerProcedureDto toGroomerProcedureDto(GroomerProcedure groomerProcedure);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    GroomerProcedure partialUpdate(GroomerProcedureDto groomerProcedureDto, @MappingTarget GroomerProcedure groomerProcedure);
}