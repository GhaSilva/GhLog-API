package br.com.ghasilva.ghlog.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ghasilva.ghlog.api.exception.NegocioException;
import br.com.ghasilva.ghlog.api.model.Cliente;
import br.com.ghasilva.ghlog.repository.ClienteRepository;

@Service
public class CatalogoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId).orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com esse e-mail.");
		}
		
		return clienteRepository.save(cliente);
		
	}
	
	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}
