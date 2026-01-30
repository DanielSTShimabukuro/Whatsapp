package whatsapp.whatsapp.interfaces.rest.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import whatsapp.whatsapp.application.user.*;
import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.interfaces.rest.user.requests.CreateUserRequest;
import whatsapp.whatsapp.interfaces.rest.user.responses.PartialUserResponse;
import whatsapp.whatsapp.interfaces.rest.user.responses.UserResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    // --- Casos de Uso --- //
    private final CreateUserUseCase createUserUseCase;

    private final GetAllUsersUseCase getAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetUserByUserTagUseCase getUserByUserTagUseCase;
    private final GetUsersByUsernameUseCase getUsersByUsernameUseCase;

    private final DeleteUserByIdUseCase deleteUserByIdUseCase;

    // --- Rotas HTTP --- //

    // --- CREATE --- //
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        User user = createUserUseCase.execute(
                request.userTag(),
                request.username(),
                request.password(),
                request.userRole()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponse.from(user));
    }

    // --- GET ALL --- //
    @GetMapping
    public ResponseEntity<List<PartialUserResponse>> getAll() {
        List<User> foundUsers = getAllUsersUseCase.execute();

        return ResponseEntity.ok().body(
                foundUsers.stream()
                .map(PartialUserResponse::from)
                .toList()
        );
    }

    // --- GET BY id --- //
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
        // Aviso: Qnd criar tratamento de erro global, aprimorar o lançamento de erro aqui
        User foundUser = getUserByIdUseCase.execute(id).orElseThrow();

        return ResponseEntity.ok().body(UserResponse.from(foundUser));
    }

    // --- GET BY userTag --- //
    @GetMapping(params = "userTag")
    public ResponseEntity<UserResponse> getById(@RequestParam String userTag) {
        // Aviso: Qnd criar tratamento de erro global, aprimorar o lançamento de erro aqui
        User foundUser = getUserByUserTagUseCase.execute(userTag).orElseThrow();

        return ResponseEntity.ok().body(UserResponse.from(foundUser));
    }

    // --- GET BY username --- //
    @GetMapping(params = "username")
    public ResponseEntity<List<PartialUserResponse>> getByUsername(@PathVariable String username) {
        List<User> foundUsers = getUsersByUsernameUseCase.execute(username);

        return ResponseEntity.ok().body(
                foundUsers.stream()
                        .map(PartialUserResponse::from)
                        .toList()
        );
    }

    // --- DELETE --- //
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        deleteUserByIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}