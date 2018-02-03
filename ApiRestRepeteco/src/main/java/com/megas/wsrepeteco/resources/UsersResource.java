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
import com.megas.wsrepeteco.domain.Users;
import com.megas.wsrepeteco.services.UsersService;

@RestController
@RequestMapping("/wsrepeteco/users")
public class UsersResource {

	@Autowired
	private UsersService usersService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Users>> listar() {
		List<Users> users = usersService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> buscar(@PathVariable("id") Long id) {
		Users users = usersService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Users users) {
		users = usersService.salvar(users);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(users.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarSalvar(@Valid @RequestBody Users users) {
		users = usersService.salvar(users);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(users.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Users users, 
			@PathVariable("id") Long id) {
		users.setId(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}/friends", method = RequestMethod.POST)
	public ResponseEntity<Void> adicionarFriends(@PathVariable("id") Long usersId, 
			@RequestBody List<Friends> friends) {
		
		friends.forEach(f -> {
			usersService.salvarFriends(usersId, f);
		});		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}/friends", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizarFriends(@PathVariable("id") Long usersId, 
			@RequestBody List<Friends> friends) {		
		friends.forEach(f -> {
			usersService.salvarFriends(usersId, f);
		});		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}/friends", method = RequestMethod.GET)
	public ResponseEntity<List<Friends>> listarFriends(
			@PathVariable("id")Long usersId) {
		List<Friends> friends = usersService.listarFriends
				(usersId);
		
		return ResponseEntity.status(HttpStatus.OK).body(friends);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		usersService.deletar(id);

		return ResponseEntity.noContent().build();
	}
	
}