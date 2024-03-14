package crisci.caterina.goodstream.DTO;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
        String fullName,

        @NotNull
        @NotEmpty
        String email,

        @NotNull
        @NotEmpty
        String password) {
}
