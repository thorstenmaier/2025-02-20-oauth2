package de.oio.fscloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class CloudSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudSecurityApplication.class, args);
	}

	@GetMapping("/")
	public Authentication home() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		return securityContext.getAuthentication();
	}
}
