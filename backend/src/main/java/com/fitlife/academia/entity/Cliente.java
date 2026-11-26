package com.fitlife.academia.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 120) private String nome;
    @Column(nullable = false, unique = true, length = 160) private String email;
    @Column(nullable = false, length = 25) private String telefone;
    @Column(nullable = false, length = 20) private String plano;
    @Column(nullable = false) private LocalDateTime criadoEm = LocalDateTime.now();
    public Long getId(){return id;} public String getNome(){return nome;} public void setNome(String v){nome=v;}
    public String getEmail(){return email;} public void setEmail(String v){email=v;}
    public String getTelefone(){return telefone;} public void setTelefone(String v){telefone=v;}
    public String getPlano(){return plano;} public void setPlano(String v){plano=v;}
    public LocalDateTime getCriadoEm(){return criadoEm;}
}
