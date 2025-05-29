package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;
import ee.valiit.groomlyback.persistence.groomer.GroomerMapper;
import ee.valiit.groomlyback.persistence.groomer.GroomerRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroomerService {

    private final GroomerRepository groomerRepository;
    private final GroomerMapper groomerMapper;

    public GroomerService(GroomerRepository groomerRepository, GroomerMapper groomerMapper) {
        this.groomerRepository = groomerRepository;
        this.groomerMapper = groomerMapper;
    }

    public List<GroomerDto> getAllGroomers() {
        return groomerRepository.findAll().stream()
                .map(groomerMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<GroomerDto> findGroomers(@RequestParam(defaultValue = "0") Integer cityId) {
        if (cityId == 0) {
            return getAllGroomers();
        } else {
            List<Groomer> groomers = groomerRepository.findGroomersByCity(cityId);
            validateAtLeastOneGroomer(groomers);
            return groomerMapper.toDtoList(groomers);
        }
    }



    private void validateAtLeastOneGroomer(List<Groomer> groomers){
        if (groomers == null || groomers.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Groomers not found");
        }
    }
}
