package ee.valiit.groomlyback.persistence.userimage;

import ee.valiit.groomlyback.persistence.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "user_image", schema = "groomly")
public class UserImage {
    @Id
    @ColumnDefault("nextval('bank.user_image_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "data", nullable = false)
    private byte[] data;

}