package ee.valiit.groomlyback.persistence.location;

import ee.valiit.groomlyback.controller.registration.dto.NewGroomer;
import ee.valiit.groomlyback.persistence.city.CityMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {CityMapper.class})
public interface LocationMapper {

    @Mapping(source = "cityId",target = "city.id")
    @Mapping(source = "streetName",target = "streetName")
    @Mapping(source = "houseNumber",target = "houseNumber")
    Location toLocation(NewGroomer newGroomer);
}