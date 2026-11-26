package com.fitlife.academia.repository;
import com.fitlife.academia.entity.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> { boolean existsByDataHoraAndStatus(LocalDateTime dataHora,String status); }
