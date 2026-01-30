package whatsapp.whatsapp.infra.persistance.user;

import org.springframework.data.jpa.repository.JpaRepository;
import whatsapp.whatsapp.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>  findByUserTag(String userTag);
    boolean         existsByUserTag(String userTag);

    /*
    * A diretiva 'Containing' faz com que os resultados desse metodo sejam inclusivos.
    * Por exemplo, dado um username "João", passar apenas "J" ou "Joã" trará "João" nos resultados.
    * */
    List<User>      findAllByUsernameContaining(String username);
}