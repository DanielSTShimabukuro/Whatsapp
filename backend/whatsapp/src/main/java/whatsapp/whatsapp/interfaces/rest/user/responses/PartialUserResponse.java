package whatsapp.whatsapp.interfaces.rest.user.responses;

import whatsapp.whatsapp.domain.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

// PartialUserResponse omite alguns campos da Entidade Usuário
public record PartialUserResponse(
    UUID id,
    String userTag,
    String username,

    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public static PartialUserResponse from(User user) {
        return new PartialUserResponse(
                user.getId(),
                user.getUserTag(),
                user.getUsername(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
