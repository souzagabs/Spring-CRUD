package com.dia312.springcrud.dto;

import jakarta.validation.constraints.NotBlank;

public record UsersRecordDto(@NotBlank String nome,@NotBlank String email, @NotBlank String senha) {

}
