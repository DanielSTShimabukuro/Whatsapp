package whatsapp.whatsapp.application.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.domain.user.UserRole;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

@Service
@RequiredArgsConstructor
public class CreateUserUseCase {
    private final UserRepository repository;

    @Transactional
    public User execute(
            String userTag,
            String username,
            String password,

            /*
             Regra de Negócio: talvez remover isso daqui no caso de usuários serem criados com
             a role USER por padrão.
            */
            UserRole userRole
    ) {
        if(repository.existsByUserTag(userTag)) {
            // Aviso: tratar exceção de Conflito aqui...
        }

        // Aviso: '@' como símbolo prefixador do campo userTag pode ser alterado por outro no futuro.
        if(userTag.charAt(0) != '@') {
            userTag = "@" + userTag;
        }

        // Regra de Negócio: Mais tarde, encriptar senha antes de criar usuário

        User user = new User(userTag, username, password, userRole);

        repository.save(user);

        return user;
    }
}
