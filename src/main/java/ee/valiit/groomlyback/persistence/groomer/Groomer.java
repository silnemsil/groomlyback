package ee.valiit.groomlyback.persistence.groomer;

import ee.valiit.groomlyback.persistence.location.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "groomer", schema = "groomly")
public class Groomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 500)
    @NotNull
    @Column(name = "description", nullable = false, length = 500)
    private String description;

    @Size(max = 20)
    @NotNull
    @Column(name = "tel_number", nullable = false, length = 20)
    private String telNumber;

    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

}