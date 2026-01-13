package desafio.itau.api.service;

import desafio.itau.api.domain.Transacao;
import desafio.itau.api.dto.EstatisticaDTO;
import desafio.itau.api.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransacaoService {

    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    /**
     *
     * @param dto é uma transação que é adicionada a fila encadeada
     */
    public void receber(TransacaoDTO dto){
        Transacao transacao = new Transacao(dto.getValor(), dto.getDataHora());
        transacoes.add(transacao);
    }

    public void deletar(){
        transacoes.clear();
    }

    /**
     *
     * @return EstatisticaDTO que representa a classe DoubleSummaryStatistics e que possui os mesmos campos
     */

    public EstatisticaDTO visualizar(){
        DoubleSummaryStatistics summaryStatistics = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();
        EstatisticaDTO dto = new EstatisticaDTO(summaryStatistics);
        if(dto.getCount() == 0){
            dto.setMin(0.0);
            dto.setMax(0.0);
        }
        return dto;
    }
}
