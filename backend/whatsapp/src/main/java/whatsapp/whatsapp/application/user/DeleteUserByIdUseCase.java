package whatsapp.whatsapp.application.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import whatsapp.whatsapp.infra.persistance.user.UserRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteUserByIdUseCase {
    private final UserRepository repository;

    /*
    * Aviso: talvez seja interessante adicionar uma exceção p/ o caso de não existir
    * nenhum usuário cujo ID corresponde ao passado pelo parâmetro.
    * */
    @Transactional
    public void execute(UUID id) {

        /*
        * Regra de Negócio: Pensar nas implicações de se excluir um usuário.
        * Por exemplo, o que iria acontecer com suas mensagens, ou, ele seria
        * automáticamente removido dos grupos que fazia parte?
        * */

        repository.deleteById(id);
    }
}
