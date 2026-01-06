package desafio.itau.api.service;

import desafio.itau.api.domain.Transacao;
import desafio.itau.api.exceptions.ValorInvalido;
import desafio.itau.api.exceptions.ValorNulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransacaoService {

    @Autowired
    private Transacao transacao;
    private final ConcurrentLinkedQueue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    public void receberService(Transacao transacao){
        if (transacao.getValor() == null || transacao.getDataHora() == null) throw new ValorNulo();
        if (transacao.getDataHora().isAfter(OffsetDateTime.now())) throw new ValorInvalido();
        if (transacao.getValor() < 0) throw new ValorInvalido();
        transacoes.add(transacao);
    }
}
