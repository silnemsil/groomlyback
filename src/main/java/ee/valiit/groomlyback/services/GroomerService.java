package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;
import ee.valiit.groomlyback.infrastructure.error.Error;
import ee.valiit.groomlyback.infrastructure.exception.DataNotFoundException;
import ee.valiit.groomlyback.persistence.groomer.Groomer;
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
                .map(groomerMapper::toGroomerDto)
                .collect(Collectors.toList());
    }

    public List<GroomerDto> findGroomers(Integer cityId) {
        List<Groomer> groomers = groomerRepository.findGroomersBy(cityId);
        validateAtLeastOneGroomer(groomers);
        List<GroomerDto> groomerDtos = groomerMapper.toGroomerDtos(groomers);
        return groomerDtos;
    }


    public GroomerDto getGroomerDetails(Integer groomerId) {
        Groomer groomer = groomerRepository.findById(groomerId)
                .orElseThrow(() -> new RuntimeException("Groomer not found with id: " + groomerId));
        return groomerMapper.toGroomerDto(groomer);
    }


    private void validateAtLeastOneGroomer(List<Groomer> groomers) {
        if (groomers == null || groomers.isEmpty()) {
            throw new DataNotFoundException(Error.NO_GROOMERS_FOUND.getMessage(), Error.NO_GROOMERS_FOUND.getErrorCode());
        }
    }
}
