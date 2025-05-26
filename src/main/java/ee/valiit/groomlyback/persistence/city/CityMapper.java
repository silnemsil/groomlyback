package ee.valiit.groomlyback.persistence.city;

import ee.valiit.groomlyback.controller.city.dto.CityDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

//see meetod on vaja selleks, et võtta andmed Entitys ja me näeme neid frontendis
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CityMapper {


   @Mapping(source = "id", target = "cityId")
    @Mapping(source = "name", target = "cityName")
    CityDto toCityDto(City city);
 List<CityDto> toCityDtos(List<City> cities);
}


