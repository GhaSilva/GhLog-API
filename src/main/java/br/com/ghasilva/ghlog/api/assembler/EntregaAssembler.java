package br.com.ghasilva.ghlog.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ghasilva.ghlog.api.model.Entrega;
import br.com.ghasilva.ghlog.api.model.EntregaModel;
import br.com.ghasilva.ghlog.api.model.input.EntregaInput;


@Component
public class EntregaAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaModel toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaModel.class);
	}
	
	public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
		return entregas.stream().map(this::toModel).collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
}
