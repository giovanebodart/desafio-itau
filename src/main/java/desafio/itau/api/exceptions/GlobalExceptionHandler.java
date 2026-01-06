package desafio.itau.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValorInvalido.class)
    public ResponseEntity handleValorInvalido(){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
    }

    @ExceptionHandler
    public ResponseEntity handleValorNulo(){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
    }
}
