package com.springsecurity.controller;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.model.CustomResponse;

@RestController
@RequestMapping("/rest")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomResponse> loginMessage(Principal principal) {
		CustomResponse response=new CustomResponse();
		response.setMessage("Welcome to My Page "+ principal.getName());
        return new ResponseEntity<CustomResponse>(response,HttpStatus.OK);
    }
	@RequestMapping(value = "/loginpost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> helloPost(Principal principal) {
		CustomResponse response=new CustomResponse();
		response.setMessage("Welcome to My login Page "+ principal.getName());
		return new ResponseEntity<CustomResponse>(response, HttpStatus.OK);
	}
}
