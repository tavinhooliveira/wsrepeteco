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
import com.megas.wsrepeteco.services.FriendsService;

@RestController
@RequestMapping("/wsrepeteco/friends")
public class FriendsResource {
	
	@Autowired
	private FriendsService friendsService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Friends>> listar() {
		List<Friends> friends = friendsService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(friends);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Friends friends) {
		friends = friendsService.salvar(friends);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(friends.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarSalvar(@Valid @RequestBody Friends friends) {
		friends = friendsService.salvar(friends);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(friends.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Friends> buscar(@PathVariable("id") String id) {
		Friends friends = friendsService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(friends);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Friends friends, @PathVariable("id") String id) {
		friends.setId(id);
		friendsService.atualizar(friends);
		
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "opcao/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> opcao(@RequestBody Friends friends, @PathVariable("id") String id) {
		friends.setId(id);
		friendsService.opcao(friends);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
		friendsService.deletar(id);

		return ResponseEntity.noContent().build();
	}
	

}
