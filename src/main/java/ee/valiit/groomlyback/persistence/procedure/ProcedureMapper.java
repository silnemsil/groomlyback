package ee.valiit.groomlyback.persistence.procedure;


import ee.valiit.groomlyback.controller.procedure.ProcedureDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public class ProcedureMapper {
    ProcedureDto toDto(Procedure entity) {
        return null;
    }

    Procedure toEntity(ProcedureDto dto) {
        return null;
    }
}
