package whatsapp.whatsapp.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUsersUseCase {
    private final UserRepository repository;

    // Aviso: Pode ser necessário aprimorar esse caso de uso para lidar com paginação
    public List<User> execute() {
        return repository.findAll();
    }
}