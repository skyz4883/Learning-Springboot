package com.learning.restservices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController {
	
	//simpleMethod
	//GET
	//URI
	//@GetMapping ("/hellowworld1")
	@RequestMapping (method = RequestMethod.GET, path = "/helloworld")
	public String helloWorld() {
		
		return "Hello World";
	}

	@GetMapping("/Helloworld-bean")
	public UserDetails hellowworldbean() {
		
		
		return new UserDetails("Shiv","Kumar",25);
	}
}
