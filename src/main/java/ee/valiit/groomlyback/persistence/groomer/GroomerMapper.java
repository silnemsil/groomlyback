package ee.valiit.groomlyback.persistence.groomer;

import ee.valiit.groomlyback.controller.registration.dto.NewGroomer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroomerMapper {

    @Mapping(source = "groomerName",target = "name")
    @Mapping(source = "groomerDescription",target = "description")
    @Mapping(source = "groomerTelNumber",target = "telNumber")
    @Mapping(source = "groomerEmail",target = "email")
    Groomer toGroomer(NewGroomer newGroomer);

}