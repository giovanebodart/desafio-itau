package desafio.itau.api.controller;


import desafio.itau.api.dto.EstatisticaDTO;
import desafio.itau.api.service.TransacaoService;
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

    @GetMapping
    public ResponseEntity<EstatisticaDTO> visualizarEstatisticas(){
        EstatisticaDTO estatistica = service.visualizar();
        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
    }
}
