package ee.valiit.groomlyback.services.city;

import ee.valiit.groomlyback.controller.city.dto.CityDto;
import ee.valiit.groomlyback.persistence.city.City;
import ee.valiit.groomlyback.persistence.city.CityMapper;
import ee.valiit.groomlyback.persistence.city.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityDto> getAllCities() {

        List<City> cities = cityRepository.findAll(); //tagastab city entity objektidest
        List<CityDto> cityDtos = cityMapper.toCityDtos(cities);
        return cityDtos;
    }
}
