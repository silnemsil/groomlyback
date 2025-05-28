package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.controller.groomer.dto.GroomerDto;
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
                .map(groomerMapper::toDto)
                .collect(Collectors.toList());
    }

    public GroomerDto getGroomerDetails(Integer groomerId) {
        Groomer groomer = groomerRepository.findById(groomerId)
                .orElseThrow(() -> new RuntimeException("Groomer not found with id: " + groomerId));
        return groomerMapper.toDto(groomer);
    }

}

