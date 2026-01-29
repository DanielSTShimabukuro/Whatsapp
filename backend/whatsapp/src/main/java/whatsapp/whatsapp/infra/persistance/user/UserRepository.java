package whatsapp.whatsapp.infra.persistance.user;

import org.springframework.data.jpa.repository.JpaRepository;
import whatsapp.whatsapp.domain.user.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>  findByUserTag(String userTag);
    boolean         existsByUserTag(String userTag);
}