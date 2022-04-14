package br.com.ghasilva.ghlog.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghasilva.ghlog.api.model.Entrega;
import br.com.ghasilva.ghlog.repository.EntregaRepository;

@Service
public class FinalizacaoEntregaService {
	
	@Autowired
	 private BuscaEntregaService buscaEntregaService;
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public void finalizar(long entregaId) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		entrega.finalizar();
		
		
		entregaRepository.save(entrega);
	}
}
