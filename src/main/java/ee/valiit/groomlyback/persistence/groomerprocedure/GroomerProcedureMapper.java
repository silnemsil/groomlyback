package ee.valiit.groomlyback.persistence.groomerprocedure;

import ee.valiit.groomlyback.controller.groomer.dto.ProcedureInfo;
import ee.valiit.groomlyback.controller.groomerprocedure.dto.GroomerProcedureDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroomerProcedureMapper {
    GroomerProcedure toGroomerProcedureEntity(GroomerProcedureDto groomerProcedureDto);

    GroomerProcedureDto toGroomerProcedureDto(GroomerProcedure groomerProcedure);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    GroomerProcedure partialUpdate(GroomerProcedureDto groomerProcedureDto, @MappingTarget GroomerProcedure groomerProcedure);

    @Mapping(source = "id", target = "groomerProcedureId")
    @Mapping(source = "procedure.name", target = "procedureName")
    @Mapping(source = "price", target = "procedurePrice")
    ProcedureInfo toProcedureInfos(GroomerProcedure groomerProcedure);


    List<ProcedureInfo> toProcedureInfos(List<GroomerProcedure> groomerProcedures);
}