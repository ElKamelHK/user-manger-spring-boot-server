package com.usermanger.usermager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.usermanger.usermager.model.User;
import com.usermanger.usermager.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	/*
	 * Fonction que retourne une liste des utilisateur
	 * 
	 * @return List<User>
	 */
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	/*
	 * Fonction que retourne un utilisateur par son Cin
	 * 
	 * @params cin de type String
	 * 
	 * @return Optional<User>
	 */
	public Optional<User> findByCin(String cin) {
		// TODO Auto-generated method stub
		return this.userRepository.findByCin(cin);
	}

	/*
	 * Fonction que retourne un utilisateur par son Id
	 * 
	 * @params id de type Long
	 * 
	 * @return Optional<User>
	 */
	public Optional<User> findById(Long id) {
		Optional<User> optUser = this.userRepository.findById(id);

		return optUser;
	}

	/*
	 * Fonction que permet d'ajouter un utilisateur
	 * 
	 * @params user de type User
	 * 
	 * @return User
	 */
	public ResponseEntity<?> addNewUser(User user) {
		// optional User par Cin
		Optional<User> optUser = this.findByCin(user.getCin());
		// test si l'utilisateur déjà existe par son cin 
		if (optUser.isPresent()) {
			// return Status 302 found
			return new ResponseEntity<Void>(HttpStatus.FOUND);
		} else {
			// si n'existe pas enregistre le dans la base
			User newUser= this.save(user);
			 // si la nouvelle user no null alors affiche le avec la status 201
			if (newUser!=null) {
				return new ResponseEntity<User>(user, HttpStatus.CREATED);
			} else {
				 // si la nouvelle user null alors affiche le satuts 400
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}
		}

	}

	/*
	 * Fonction que permet de sauvgarder un utilisateur dans la base
	 * 
	 * @params user de type User
	 * 
	 * @return User
	 */
	public User save(User user) {
		// TODO Auto-generated method stub
		return this.userRepository.saveAndFlush(user);
	}

	 

}
