package com.fitlife.academia.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="agendamentos", indexes=@Index(name="idx_agendamento_horario", columnList="dataHora"))
public class Agendamento {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional=false, fetch=FetchType.EAGER) @JoinColumn(name="cliente_id", nullable=false) private Cliente cliente;
    @Column(nullable=false, length=60) private String modalidade;
    @Column(nullable=false) private LocalDateTime dataHora;
    @Column(nullable=false, length=20) private String status="CONFIRMADO";
    public Long getId(){return id;} public Cliente getCliente(){return cliente;} public void setCliente(Cliente v){cliente=v;}
    public String getModalidade(){return modalidade;} public void setModalidade(String v){modalidade=v;}
    public LocalDateTime getDataHora(){return dataHora;} public void setDataHora(LocalDateTime v){dataHora=v;}
    public String getStatus(){return status;} public void setStatus(String v){status=v;}
}
