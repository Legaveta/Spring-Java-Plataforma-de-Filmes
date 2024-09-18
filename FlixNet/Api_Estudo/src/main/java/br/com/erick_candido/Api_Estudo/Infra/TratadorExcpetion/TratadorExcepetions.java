package br.com.erick_candido.Api_Estudo.Infra.TratadorExcpetion;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratadorExcepetions {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity tratarErroDadosDuplicados(){
        return ResponseEntity.badRequest().body("Este Cadastro Já Existe");
    }
}
