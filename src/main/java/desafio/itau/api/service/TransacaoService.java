package desafio.itau.api.service;

import desafio.itau.api.domain.Transacao;
import desafio.itau.api.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransacaoService {

    private final Queue<Transacao> transacoes = new ConcurrentLinkedQueue<>();

    public void receber(TransacaoDTO dto){
        Transacao transacao = new Transacao(dto.getValor(), dto.getDataHora());
        transacoes.add(transacao);
    }

    public void deletar(){
        transacoes.clear();
    }
}
