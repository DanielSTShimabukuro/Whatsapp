package whatsapp.whatsapp.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepository repository;

    public Optional<User> execute(UUID id) {
        /*
        * Aviso: pensar em tratar erro caso não exista nenhum usuário
        * cujo ID corresponde ao passado pelo parâmetro.
        * */

        return repository.findById(id);
    }
}
