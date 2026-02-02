package whatsapp.whatsapp.infra.persistance.message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whatsapp.whatsapp.domain.group.Group;
import whatsapp.whatsapp.domain.message.Message;
import whatsapp.whatsapp.domain.user.User;


@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {
  Optional<Message> findById(UUID id);

  List<Message> findByGroup(Group group);
  List<Message> findByAuthorAndGroup(User author, Group group);

  boolean existsById(UUID id);
  boolean existsByGroup(Group group);
  boolean existsByAuthorAndGroup(User author, Group group);
}
