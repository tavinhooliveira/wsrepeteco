package com.megas.wsrepeteco.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.megas.wsrepeteco.domain.Option;
import com.megas.wsrepeteco.services.OptionService;

@RestController
@RequestMapping("/wsrepeteco/option")
public class OptionResources {

	@Autowired
	private OptionService optionService;
	
	//Listar Todos
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Option>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(optionService.listar());
	}
	
	//Salvar
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@RequestBody Option option) {
		option = optionService.salvar(option);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(option.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	
	//Buscar user
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
		Option option = optionService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(option);
	}
	
	//Delete user
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		optionService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	//Atualizar user
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Option option, 
			@PathVariable("id") Long id) {
		option.setId(id);
		optionService.atualizar(option);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	

}
