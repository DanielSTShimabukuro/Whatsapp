package whatsapp.whatsapp.infra.persistance.group;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whatsapp.whatsapp.domain.group.Group;
import whatsapp.whatsapp.domain.user.User;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {
  Optional<Group> findById(UUID id);

 List<Group> findByMembersContaining(User member);

  boolean existsById(UUID id);
}
