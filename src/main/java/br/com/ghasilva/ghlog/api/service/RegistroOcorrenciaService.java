package br.com.ghasilva.ghlog.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghasilva.ghlog.api.domain.Ocorrencia;
import br.com.ghasilva.ghlog.api.model.Entrega;

@Service
public class RegistroOcorrenciaService {

	
	@Autowired
	private BuscaEntregaService buscaEntregaService;
	
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
		
	}
	
}
