package temi.dev.demobackend.user;

import java.time.LocalDateTime;
import java.util.function.BinaryOperator;

public record UserModel( Integer id, String firstname, String lastname, String email, String password,
                         LocalDateTime createdAt, LocalDateTime updatedAt
) {}
