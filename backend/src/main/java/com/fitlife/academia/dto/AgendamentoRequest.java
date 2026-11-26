package com.fitlife.academia.dto;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
public record AgendamentoRequest(@NotBlank @Email String email,@NotBlank @Size(max=60) String modalidade,@NotNull @Future LocalDateTime dataHora) {}
