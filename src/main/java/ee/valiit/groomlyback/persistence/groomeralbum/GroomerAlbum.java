package ee.valiit.groomlyback.persistence.groomeralbum;

import ee.valiit.groomlyback.persistence.groomer.Groomer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "groomer_album", schema = "groomly")
public class GroomerAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groomer_id", nullable = false)
    private Groomer groomer;

    @NotNull
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}