package ee.valiit.groomlyback.persistence.groomerprocedure;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GroomerProcedureRepository extends JpaRepository<GroomerProcedure, Integer> {
    List<GroomerProcedure> findAllByGroomer_Id(Integer groomerId);
}