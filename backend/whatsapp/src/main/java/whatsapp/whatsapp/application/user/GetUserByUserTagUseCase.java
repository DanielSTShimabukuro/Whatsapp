package whatsapp.whatsapp.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.application.exceptions.UserNotFoundException;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

@Service
@RequiredArgsConstructor
public class GetUserByUserTagUseCase {
    private final UserRepository repository;

    public User execute(String userTag) {
        // Aviso: '@' como símbolo prefixador do campo userTag pode ser alterado por outro no futuro.
        if(userTag.charAt(0) != '@') {
            userTag = "@" + userTag;
        }

        return repository.findByUserTag(userTag).orElseThrow(() -> new UserNotFoundException());
    }
}
