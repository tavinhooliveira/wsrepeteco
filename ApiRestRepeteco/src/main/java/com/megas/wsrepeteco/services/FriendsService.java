package com.megas.wsrepeteco.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.megas.wsrepeteco.domain.Friends;
import com.megas.wsrepeteco.repository.FriendsRepository;
import com.megas.wsrepeteco.services.exceptions.OptionNaoEncontradoException;
import com.megas.wsrepeteco.services.exceptions.UsersNaoEncontradoException;

@Service
public class FriendsService {
	
	@Autowired
	private FriendsRepository friendsRepository;
	
	//Listar Todos
		public List<Friends> listar() {
			return friendsRepository.findAll();
		}
		
		//Salvar Friends
		public Friends salvar(Friends friends) {
			if(friends.getId() != null) {
				Friends a = friendsRepository.findOne(friends.getId());
				
				if(a != null) {
					System.out.println("|Update| Friends Atualizado:"+friends.getId());
					friends.setOption(a.getOption());
					return friendsRepository.save(friends);
				}
			}
			System.out.println("|Create| Friends cadastrado:"+friends.getId());
			return friendsRepository.save(friends);
		}
		
		//Buscar User
		public Friends buscar(Long id) {
			Friends friends = friendsRepository.findOne(id);
			
			if(friends == null) {
				throw new UsersNaoEncontradoException("O Amigo não pôde ser encontrado.");
			}
			return friends;
		}
				
		//Verificar se Existe
		private void verificarExistencia(Friends friends) {
			buscar(friends.getId());
		}
				
		//Atuaizar
		public void atualizar(Friends friends) {
			verificarExistencia(friends);
			friendsRepository.save(friends);
		}
		
		//Classification Opcão
		public void opcao(Friends friends) {			
			verificarExistencia(friends);
			Friends a = friendsRepository.findOne(friends.getId());
			if(a != null) {
				System.out.println("|Update|Classification|UserId: "+a.getUser_id()+" Friends_ID: "+friends.getId()+" Opção: "+friends.getOption());
				friends.setCity(a.getCity());
				friends.setEmail(a.getEmail());
				friends.setGender(a.getGender());
				friends.setId_fb_friends(a.getId_fb_friends());
				friends.setImagem(a.getImagem());
				friends.setLink(a.getLink());
				friends.setName(a.getName());
				friends.setUser_id(a.getUser_id());
				friends.setUsers(a.getUsers());
				friends.setUpdateDataOption(new Date());
				friendsRepository.save(friends);
			}
			friendsRepository.save(friends);
		}
		
		//Deletar
		public void deletar(Long id) {
			try {
				friendsRepository.delete(id);
			} catch (EmptyResultDataAccessException e) {
				throw new OptionNaoEncontradoException("O Amigo não pôde ser Deletado.");
			}
		}		
		
}
