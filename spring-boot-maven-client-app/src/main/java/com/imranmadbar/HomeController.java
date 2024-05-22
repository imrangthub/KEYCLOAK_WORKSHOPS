package com.imranmadbar;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

	@GetMapping("/home")
	public ResponseEntity<String> hello(Authentication authentication) {
		final String body = "Hello From Home: " + authentication.getName();
		return ResponseEntity.ok(body);
	}

	@RequestMapping(value = "/anonymous", method = RequestMethod.GET)
	public ResponseEntity<String> getAnonymous() {
		return ResponseEntity.ok("Hello Anonymous");
	}

	@PreAuthorize("hasRole('ROLE_user')")
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<String> getUser() {
		return ResponseEntity.ok("Hello Secured with user role.");
	}
	
	
	
	
	
	
}
