package ee.valiit.groomlyback.persistence.groomerprocedure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroomerProcedureRepository extends JpaRepository<GroomerProcedure, Integer> {

    @Query("select g from GroomerProcedure g where g.groomer.id = :groomerId")
    List<GroomerProcedure> findGroomerProceduresBy(Integer groomerId);
}