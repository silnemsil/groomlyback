package ee.valiit.groomlyback.persistence.location;

import ee.valiit.groomlyback.persistence.city.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "groomly")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Size(max = 255)
    @NotNull
    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Size(max = 255)
    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "lat", precision = 18, scale = 15)
    private BigDecimal lat;

    @Column(name = "long", precision = 18, scale = 15)
    private BigDecimal longField;


}