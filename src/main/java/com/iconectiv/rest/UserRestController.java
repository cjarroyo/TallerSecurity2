package com.iconectiv.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.iconectiv.modelo.Role;
import com.iconectiv.modelo.User;
import com.iconectiv.modelo.UserDto;
import com.iconectiv.service.UserService;

@RestController
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/publico/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		modelAndView.addObject("userName", "Bienvenido " + user.getNombres() + " " + user.getApellidos() + " (" + user.getEmail() + ")");
		//modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("publico/home");
		return modelAndView;
	}
	

	// ----all users
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		List<UserDto> usersDto = parseFromListUserToListUserDto(users);
		
		if (usersDto.isEmpty()) {
			return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDto>>(usersDto, HttpStatus.OK);
	}

	private List<UserDto> parseFromListUserToListUserDto(List<User> users) {
		List<UserDto> lista = new ArrayList<UserDto>();
		for(User user: users){
			UserDto userDto = parseFromUserToUserDto(user);
			lista.add(userDto);
		}
		return lista;
	}
	
	private UserDto parseFromUserToUserDto(User user){
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setNombres(user.getNombres());
		userDto.setApellidos(user.getApellidos());
		userDto.setEmail(user.getEmail());
		userDto.setRole(user.getRole().getId());
		userDto.setRolename(user.getRole().getName());
		return userDto;
	}


	// ---One USer
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// save
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody UserDto userDto, UriComponentsBuilder ucBuilder) {
		User user = parseFromUserDtoToUser(userDto);
		
		if (userService.isUserExist(user)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	private User parseFromUserDtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setNombres(userDto.getNombres());
		user.setApellidos(userDto.getApellidos());
		user.setEmail(userDto.getEmail());
		
		Role role = new Role();
		role.setId(userDto.getRole());
		user.setRole(role);
		
		return user;
	}


	// update
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
		User currentUser = userService.findById(id);
		if (currentUser == null) {
			return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
		}
		User currentUserUpdate = parseFromUserDtoToUser(userDto);
		userService.updateUser(currentUserUpdate);
		
		UserDto currentUserDtoUpdate = parseFromUserToUserDto(currentUserUpdate);
		
		return new ResponseEntity<UserDto>(currentUserDtoUpdate, HttpStatus.OK);
	}
	// delete
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("Unable to delete. User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
