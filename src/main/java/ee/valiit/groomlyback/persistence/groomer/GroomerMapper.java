package ee.valiit.groomlyback.persistence.groomer;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GroomerMapper {
    Groomer toEntity(GroomerDto groomerDto);

    GroomerDto toDto(Groomer groomer);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Groomer partialUpdate(GroomerDto groomerDto, @MappingTarget Groomer groomer);

    @Mapping(source = "groomerName",target = "name")
    @Mapping(source = "groomerDescription",target = "description")
    @Mapping(source = "groomerTelNumber",target = "telNumber")
    @Mapping(source = "groomerEmail",target = "email")
    Groomer toGroomer(GroomerDto groomerDto);
}