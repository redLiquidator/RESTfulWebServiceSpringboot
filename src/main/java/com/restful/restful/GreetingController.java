package com.restful.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//controller: execute incoming http request
@RestController  //return result with the form of json,xml..
public class GreetingController {
	
	private static final String template ="HEllo, %s!";
	private final AtomicLong counter = new AtomicLong();

	//this method expects that in the url, there should be a parameter, which is name 
	//if I want the parameter optional, I can do this: @RequestParam(required = false) String name   |   @RequestParam(defaultValue = "World") String name  
    //http://localhost:8080/Greeting?name=John
	@GetMapping("/Greeting")
	Greeting greeting(@RequestParam String name) {  
		return new Greeting(counter.incrementAndGet(),String.format(template,name));   //Greeting object(java object) is serialiazed into json (by jackson)
	}
	
	//@RequestMapping make this method accept all the different http method(get,delete,post...). I can specify which method I need. 
	@RequestMapping(method = RequestMethod.GET, path = "/greeting1")
	Greeting greeting1(@RequestParam String name) {  
		return new Greeting(counter.incrementAndGet(),String.format(template,name));   //Greeting object is serialiazed into json
	}
	
	

}
