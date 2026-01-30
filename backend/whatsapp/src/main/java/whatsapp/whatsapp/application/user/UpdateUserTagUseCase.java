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
public class UpdateUserTagUseCase {
    private final UserRepository repository;


    @Transactional
    public void execute(UUID id, String userTag) {
        User user = repository.findById(id).orElseThrow(()-> new UserNotFoundException());

        if(!userTag.matches("^@")) {
            userTag = "@" + userTag;
        }

        user.setUserTag(userTag);
    }
}
