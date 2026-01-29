package whatsapp.whatsapp.domain.user;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // Vai servir no lugar do e-mail
    @Setter
    @Column(nullable = false, unique = true)
    private String userTag;

    @Setter
    @Column(nullable = false)
    private String username;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Setter
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(
        String userTag,
        String username,
        String password,
        UserRole userRole
    ) {
        this.userTag = userTag;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}
