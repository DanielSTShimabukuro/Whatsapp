package whatsapp.whatsapp.interfaces.rest.user.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import whatsapp.whatsapp.domain.user.UserRole;

public record CreateUserRequest(
        @NotBlank(message = "userTag não pode estar vazio")
        // Aviso: esse RegExp checa se a String possui '@' na primeira posição
        @Pattern(regexp = "^@", message = "userTag deve conter @ na primeira posição")
        String userTag,

        @NotBlank(message = "username não pode estar vazio")
        @Size(min = 3, message = "username deve ter no mínimo 3 caracteres")
        String username,

        @NotBlank(message= "password não pode estar vazia")
        @Size(min = 6, message = "password deve ter no mínimo 6 caracteres")
        @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)",
            message = "Password deve conter 1 letra maiúscula, 1 minúscula, 1 número e 1 símbolo"
        )
        String password,

        // Aviso: Pode ser interessante não permitir isso — independentemente da Role do usuário
        UserRole userRole
) {}