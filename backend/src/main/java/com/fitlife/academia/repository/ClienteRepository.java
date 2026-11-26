package com.fitlife.academia.repository;
import com.fitlife.academia.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface ClienteRepository extends JpaRepository<Cliente,Long> { Optional<Cliente> findByEmailIgnoreCase(String email); boolean existsByEmailIgnoreCase(String email); }
