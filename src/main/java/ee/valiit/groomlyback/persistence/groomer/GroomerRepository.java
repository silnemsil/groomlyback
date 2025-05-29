package ee.valiit.groomlyback.persistence.groomer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GroomerRepository extends JpaRepository<Groomer, Integer> {

// otsime groomeri linna järgi
    @Query("select g from Groomer g where g.location.city.id = :cityId")
    List<Groomer> findGroomersByCity(Integer cityId);


}