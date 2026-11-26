package com.fitlife.academia.service;

import com.fitlife.academia.dto.*;
import com.fitlife.academia.entity.*;
import com.fitlife.academia.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class AcademiaService {
    private final ClienteRepository clientes; private final AgendamentoRepository agendamentos;
    public AcademiaService(ClienteRepository clientes, AgendamentoRepository agendamentos){this.clientes=clientes;this.agendamentos=agendamentos;}
    public List<Cliente> listarClientes(){return clientes.findAll();}
    public Cliente buscarCliente(Long id){return clientes.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado."));}
    public Cliente criarCliente(ClienteRequest r){if(clientes.existsByEmailIgnoreCase(r.email())) throw new ResponseStatusException(HttpStatus.CONFLICT,"Este e-mail já está cadastrado."); Cliente c=new Cliente(); c.setNome(r.nome().trim()); c.setEmail(r.email().trim().toLowerCase()); c.setTelefone(r.telefone().trim()); c.setPlano(r.plano()); return clientes.save(c);}
    public Cliente atualizarCliente(Long id,ClienteRequest r){Cliente c=buscarCliente(id); clientes.findByEmailIgnoreCase(r.email()).filter(outro->!outro.getId().equals(id)).ifPresent(outro->{throw new ResponseStatusException(HttpStatus.CONFLICT,"E-mail já utilizado por outro cliente.");}); c.setNome(r.nome().trim());c.setEmail(r.email().trim().toLowerCase());c.setTelefone(r.telefone().trim());c.setPlano(r.plano());return clientes.save(c);}
    public void excluirCliente(Long id){Cliente c=buscarCliente(id);clientes.delete(c);}
    @Transactional public Agendamento criarAgendamento(AgendamentoRequest r){Cliente c=clientes.findByEmailIgnoreCase(r.email().trim()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Cadastre o aluno antes de agendar.")); if(agendamentos.existsByDataHoraAndStatus(r.dataHora(),"CONFIRMADO")) throw new ResponseStatusException(HttpStatus.CONFLICT,"Este horário já está ocupado. Escolha outro."); Agendamento a=new Agendamento();a.setCliente(c);a.setModalidade(r.modalidade().trim());a.setDataHora(r.dataHora());return agendamentos.save(a);}
    public List<Agendamento> listarAgendamentos(){return agendamentos.findAll();}
}
