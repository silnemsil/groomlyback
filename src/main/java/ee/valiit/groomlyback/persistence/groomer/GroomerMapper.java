package ee.valiit.groomlyback.persistence.groomer;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface GroomerMapper {


    @Mapping(source = "id", target = "groomerId")
    @Mapping(source = "", target = "streetName")
    @Mapping(source = "location", target = "streetName")
    @Mapping(source = "", target = "")
    @Mapping(source = "", target = "")
    @Mapping(source = "", target = "")
    @Mapping(source = "", target = "")
    GroomerDto toDtos (Groomer groomer);

    @Mapping(source = "name", target = "groomerName")

}
