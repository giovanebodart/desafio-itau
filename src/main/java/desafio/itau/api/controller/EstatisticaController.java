package desafio.itau.api.controller;


import desafio.itau.api.dto.EstatisticaDTO;
import desafio.itau.api.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private TransacaoService service;

    @Operation(
            summary = "Retorna a estatistica das transações feitas nos ultimos 60 segundos"
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Retorna OK com o body sendo a estatística das transações")
    })

    @GetMapping
    public ResponseEntity<EstatisticaDTO> visualizarEstatisticas(){
        EstatisticaDTO estatistica = service.visualizar();
        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
    }

}
