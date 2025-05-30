package ee.valiit.groomlyback.persistence.groomer;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;
import ee.valiit.groomlyback.controller.registration.dto.NewGroomer;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroomerMapper {

    @Mapping(source = "groomerName", target = "name")
    @Mapping(source = "groomerDescription", target = "description")
    @Mapping(source = "groomerTelNumber", target = "telNumber")
    @Mapping(source = "groomerEmail", target = "email")
    Groomer toGroomer(NewGroomer newGroomer);

    // Entiteedist DTO-ks
    @Mapping(source = "id", target = "groomerId")
    @Mapping(source = "name", target = "groomerName")
    @Mapping(source = "description", target = "groomerDescription")
    @Mapping(source = "telNumber", target = "groomerTelNumber")
    @Mapping(source = "email", target = "groomerEmail")
    @Mapping(source = "location.city.id", target = "cityId") // NB: location → city → id
    @Mapping(source = "location.streetName", target = "streetName") // NB: location → city → id
    @Mapping(source = "location.houseNumber", target = "houseNumber") // NB: location → city → id
    GroomerDto toGroomerDto(Groomer groomer);

    List<GroomerDto> toGroomerDtos(List<Groomer> groomers);
}
