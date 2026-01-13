package desafio.itau.api.controller;

import desafio.itau.api.domain.Transacao;
import desafio.itau.api.dto.EstatisticaDTO;
import desafio.itau.api.dto.TransacaoDTO;
import desafio.itau.api.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Recebe transação e a adiciona na fila encadeada de transações"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "A trasação foi bem sucedida"),
            @ApiResponse(responseCode = "422", description = "Os requisitos da transação não foram atendidos")
    })

    @PostMapping
    public ResponseEntity<Transacao> receberTransacao(@Valid @RequestBody TransacaoDTO dto){
        service.receber(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Apaga todas as transações da fila"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "A fila foi apagada com sucesso")
    })

    @DeleteMapping
    public ResponseEntity deletarTransacoes(){
        service.deletar();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
