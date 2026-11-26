package com.fitlife.academia.controller;
import org.springframework.http.*;import org.springframework.web.bind.MethodArgumentNotValidException;import org.springframework.web.bind.annotation.*;import org.springframework.web.server.ResponseStatusException;import java.util.Map;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(ResponseStatusException.class) public ResponseEntity<Map<String,String>> status(ResponseStatusException ex){return ResponseEntity.status(ex.getStatusCode()).body(Map.of("message",ex.getReason()==null?"Erro na solicitação.":ex.getReason()));}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,String>> validation(MethodArgumentNotValidException ex){String msg=ex.getBindingResult().getFieldErrors().stream().findFirst().map(e->e.getField()+": valor inválido.").orElse("Dados inválidos.");return ResponseEntity.badRequest().body(Map.of("message",msg));}
}
