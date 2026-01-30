package whatsapp.whatsapp.infra.persistance.message;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whatsapp.whatsapp.domain.message.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
  Optional<Message> findById(UUID id);

  boolean existsById(UUID id);
}
