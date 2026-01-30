package whatsapp.whatsapp.application.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.application.exceptions.UserNotFoundException;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUsernameUseCase {
    private final UserRepository repository;


    @Transactional
    public void execute(UUID id, String username) {
        User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException());


        user.setUsername(username);
    }
}
