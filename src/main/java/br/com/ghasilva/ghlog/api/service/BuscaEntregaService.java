package br.com.ghasilva.ghlog.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghasilva.ghlog.api.exception.EntidadeNaoEncontradaException;
import br.com.ghasilva.ghlog.api.model.Entrega;
import br.com.ghasilva.ghlog.repository.EntregaRepository;

@Service
public class BuscaEntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		return entregaRepository.findById(entregaId).orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));
	}

}
