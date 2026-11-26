package com.fitlife.academia.controller;

import com.fitlife.academia.dto.*;import com.fitlife.academia.entity.*;import com.fitlife.academia.service.AcademiaService;
import jakarta.validation.Valid;import org.springframework.http.HttpStatus;import org.springframework.web.bind.annotation.*;import java.util.List;

@RestController @RequestMapping("/api")
public class AcademiaController {
    private final AcademiaService service; public AcademiaController(AcademiaService service){this.service=service;}
    @GetMapping("/health") public String health(){return "FitLife API online";}
    @GetMapping("/clientes") public List<Cliente> clientes(){return service.listarClientes();}
    @GetMapping("/clientes/{id}") public Cliente cliente(@PathVariable Long id){return service.buscarCliente(id);}
    @PostMapping("/clientes") @ResponseStatus(HttpStatus.CREATED) public Cliente criar(@Valid @RequestBody ClienteRequest r){return service.criarCliente(r);}
    @PutMapping("/clientes/{id}") public Cliente atualizar(@PathVariable Long id,@Valid @RequestBody ClienteRequest r){return service.atualizarCliente(id,r);}
    @DeleteMapping("/clientes/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void excluir(@PathVariable Long id){service.excluirCliente(id);}
    @GetMapping("/agendamentos") public List<Agendamento> agendamentos(){return service.listarAgendamentos();}
    @PostMapping("/agendamentos") @ResponseStatus(HttpStatus.CREATED) public Agendamento agendar(@Valid @RequestBody AgendamentoRequest r){return service.criarAgendamento(r);}
}
