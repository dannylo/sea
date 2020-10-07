package br.edu.ifrn.laj.pdcorp.apisea.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrn.laj.pdcorp.apisea.dtos.UserDTO;
import br.edu.ifrn.laj.pdcorp.apisea.exceptions.ApiException;
import br.edu.ifrn.laj.pdcorp.apisea.models.User;
import br.edu.ifrn.laj.pdcorp.apisea.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> saveOrEditUser(@RequestBody User user){
		try {
			return new ResponseEntity<UserDTO>(this.userService.save(user), HttpStatus.OK);
		} catch (ApiException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email){
		try {
			return new ResponseEntity<UserDTO>(this.userService.findByUsername(email), HttpStatus.OK);
		} catch (ApiException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
