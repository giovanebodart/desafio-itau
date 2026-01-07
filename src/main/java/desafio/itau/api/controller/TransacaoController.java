package desafio.itau.api.controller;

import desafio.itau.api.domain.Transacao;
import desafio.itau.api.dto.EstatisticaDTO;
import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.api.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @PostMapping
    public ResponseEntity<Transacao> receberTransacao(@Valid @RequestBody TransacaoDTO dto){
        service.receber(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity deletarTransacoes(){
        service.deletar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
