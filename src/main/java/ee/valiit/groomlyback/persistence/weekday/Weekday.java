package ee.valiit.groomlyback.persistence.weekday;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "weekday", schema = "groomly")
public class   Weekday {
    @Id
    @ColumnDefault("nextval('groomly.weekday_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "number", nullable = false)
    private Integer number;

    @NotNull
    @Column(name = "short", nullable = false, length = Integer.MAX_VALUE)
    private String shortField;

    @Size(max = 10)
    @NotNull
    @Column(name = "long", nullable = false, length = 10)
    private String longField;

}