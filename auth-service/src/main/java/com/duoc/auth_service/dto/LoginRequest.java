package com.duoc.auth_service.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(

    @NotBlank(message = "El email es obligatorio")
    String email,

    @NotBlank(message = "La clave es obligatoria")
    String password
) {}