package whatsapp.whatsapp.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByUserTagUseCase {
    private final UserRepository repository;

    public Optional<User> execute(String userTag) {
        // Aviso: '@' como símbolo prefixador do campo userTag pode ser alterado por outro no futuro.
        if(userTag.charAt(0) != '@') {
            userTag = "@" + userTag;
        }

        /*
         * Aviso: pensar em tratar erro caso não exista nenhum usuário
         * cujo userTag corresponde ao passado pelo parâmetro.
         * */

        return repository.findByUserTag(userTag);
    }
}
