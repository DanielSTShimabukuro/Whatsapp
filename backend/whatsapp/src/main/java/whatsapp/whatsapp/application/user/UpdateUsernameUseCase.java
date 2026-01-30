package whatsapp.whatsapp.application.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUsernameUseCase {
    private final UserRepository repository;


    @Transactional
    public void execute(UUID id, String username) {
        // Aviso: aprimorar tratamento de erro caso não encontre Usuário
        User user = repository.findById(id).orElseThrow();


        user.setUsername(username);
    }
}
