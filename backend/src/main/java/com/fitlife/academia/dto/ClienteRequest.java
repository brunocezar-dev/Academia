package com.fitlife.academia.dto;
import jakarta.validation.constraints.*;
public record ClienteRequest(@NotBlank @Size(min=3,max=120) String nome,@NotBlank @Email @Size(max=160) String email,@NotBlank @Size(max=25) String telefone,@NotBlank @Pattern(regexp="START|PERFORMANCE|PREMIUM") String plano) {}
