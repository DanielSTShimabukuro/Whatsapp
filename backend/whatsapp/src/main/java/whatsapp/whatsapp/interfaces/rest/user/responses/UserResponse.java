package whatsapp.whatsapp.interfaces.rest.user.responses;

import whatsapp.whatsapp.domain.user.User;
import whatsapp.whatsapp.domain.user.UserRole;

import java.time.LocalDateTime;
import java.util.UUID;

// UserResponse retorna todos os campos da Entidade Usuário
public record UserResponse(
   UUID id,
   String userTag,
   String username,
   UserRole userRole,

   // Aviso: Mesmo aqui talvez seja interessante não retornar a senha
   String password,

   LocalDateTime createdAt,
   LocalDateTime updatedAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getUserTag(),
                user.getUsername(),
                user.getUserRole(),
                user.getPassword(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}