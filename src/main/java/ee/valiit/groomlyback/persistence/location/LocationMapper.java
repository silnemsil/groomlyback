package ee.valiit.groomlyback.persistence.location;

import ee.valiit.groomlyback.persistence.city.CityMapper;
import ee.valiit.groomlyback.persistence.groomer.GroomerDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CityMapper.class})
public interface LocationMapper {
    Location toEntity(LocationDto locationDto);

    LocationDto toDto(Location location);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Location partialUpdate(LocationDto locationDto, @MappingTarget Location location);

    @Mapping(source = "cityId",target = "city.id")
    @Mapping(source = "streetName",target = "streetName")
    @Mapping(source = "houseNumber",target = "houseNumber")
    Location toLocation(GroomerDto groomerDto);
}