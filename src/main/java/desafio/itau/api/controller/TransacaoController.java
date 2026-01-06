package desafio.itau.api.controller;

import desafio.itau.api.domain.Transacao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.DoubleSummaryStatistics;

@Controller
public class TransacaoController {

    @PostMapping("/transacao")
    public ResponseEntity<Transacao> receberTransacao(@Valid @RequestBody  Transacao transacao){
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
