package garg.anurag.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import garg.anurag.api.constants.URI;
import garg.anurag.api.entity.User;
import garg.anurag.api.service.UserService;

@RestController
@RequestMapping(value = URI.USERS)
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID)
	public User findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public User create(@RequestBody User user) {
		return service.create(user);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID)
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}


}
