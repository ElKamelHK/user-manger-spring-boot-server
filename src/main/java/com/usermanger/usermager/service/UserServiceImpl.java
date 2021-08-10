package com.usermanger.usermager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

	boolean comparerDeuxUser(User user1 , User user2)
	{
		if(user1.equals(user2))
			return true;
		else
			return false;
	}
	/*
	 * Fonction que permet de mettre a jour  un utilisateur dans la base
	 * 
	 * @params user id de type Long et le nouvelle User
	 * 
	 * @return ResponseEntity<?> 
	 */
	@Transactional
	public ResponseEntity<?> updateUser(User user, Long id) {
		// Trouver un utlisateur par son id
		Optional <User> ancUserOp=this.findById(id);
		// si l'utilisateur existe
		if(ancUserOp.isPresent())
		{
			// Tester Si le cin ajouter est unique
			Optional <User> userCin=this.findByCin(user.getCin());
			if(userCin.isPresent()&&userCin.get().getId()!=id)
			{
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);	
			}else
			{
				ancUserOp.get().setAge(user.getAge());
				ancUserOp.get().setCin(user.getCin());
				ancUserOp.get().setCountry(user.getCountry());
				ancUserOp.get().setFirstName(user.getFirstName());
				ancUserOp.get().setLastname(user.getLastname());
				// extract le nouveau  utlisateur par son id
				Optional <User> newUserOp=this.findById(id);
				if(this.comparerDeuxUser(ancUserOp.get(), newUserOp.get()))
					return new ResponseEntity<User>(ancUserOp.get(),HttpStatus.OK);
				else
					return new ResponseEntity<Void>(HttpStatus.CONFLICT);	
			}
			
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);	
		}
	}
	/*
	 * Fonction que permet de supprimer un utilisateur de la base
	 * 
	 * @params user id de type Long
	 * 
	 * @return ResponseEntity<?> 
	 */
	public ResponseEntity<?> deletewUserById(Long id) {
		Optional <User> userOp=this.findById(id);
		if(userOp.isPresent())
		{
			this.userRepository.deleteById(id);
			Optional <User> userDeletingTest=this.findById(id);
			if(userDeletingTest.isPresent()) 
			{
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}else
			{
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
		}else
		{
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
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
