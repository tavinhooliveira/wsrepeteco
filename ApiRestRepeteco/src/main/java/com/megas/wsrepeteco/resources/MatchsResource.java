package com.megas.wsrepeteco.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.megas.wsrepeteco.domain.Friends;
import com.megas.wsrepeteco.domain.Matchs;
import com.megas.wsrepeteco.services.MatchsService;

@RestController
@RequestMapping("/wsrepeteco/matchs")
public class MatchsResource {
	
	@Autowired
	private MatchsService matchsService;
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Matchs>> listar() {
		List<Matchs> matchs = matchsService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(matchs);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Matchs matchs) {
		matchs = matchsService.salvar(matchs);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(matchs.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarSalvar(@Valid @RequestBody Matchs matchs) {
		matchs = matchsService.salvar(matchs);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(matchs.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Matchs> buscar(@PathVariable("id") String id) {
		Matchs matchs = matchsService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(matchs);
	}
	
	@CrossOrigin
	@RequestMapping(value = "readStatus/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> opcao(@RequestBody Matchs matchs, @PathVariable("id") String id) {
		matchs.setId(id);
		matchsService.read(matchs);
		
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Matchs matchs, @PathVariable("id") String id) {
		matchs.setId(id);
		matchsService.atualizar(matchs);
		
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
		matchsService.deletar(id);

		return ResponseEntity.noContent().build();
	}
	


}
