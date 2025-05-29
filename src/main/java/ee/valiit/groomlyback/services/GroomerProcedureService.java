package ee.valiit.groomlyback.services;

import ee.valiit.groomlyback.controller.groomerprocedure.dto.GroomerProcedureDto;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedure;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedureMapper;
import ee.valiit.groomlyback.persistence.groomerprocedure.GroomerProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroomerProcedureService {

    private final GroomerProcedureRepository groomerProcedureRepository;
    private final GroomerProcedureMapper groomerProcedureMapper;


    public GroomerProcedureService(GroomerProcedureRepository groomerProcedureRepository, GroomerProcedureMapper groomerProcedureMapper) {
        this.groomerProcedureRepository = groomerProcedureRepository;
        this.groomerProcedureMapper = groomerProcedureMapper;
    }

    public List<GroomerProcedureDto> getGroomerProcedures(Integer groomerId) {
        List<GroomerProcedure> procedures = groomerProcedureRepository.findAllByGroomer_Id(groomerId);
        return procedures.stream().map(groomerProcedureMapper::toGroomerProcedureDto).collect(Collectors.toList());
    }
}
