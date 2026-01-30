package whatsapp.whatsapp.application.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdatePasswordUseCase {
    private final UserRepository repository;

    @Transactional
    public void execute(UUID id, String password) {
        // Aviso: aprimorar tratamento de erro caso não encontre Usuário
        User user = repository.findById(id).orElseThrow();

        // Regra de negócio: encriptar a nova senha antes de reatribuí-la ao Usuário

        user.setPassword(password);
    }
}
