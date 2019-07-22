package com.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

@Path("/protected")
public class ProtectedResource {
	
    private final Logger logger = LoggerFactory.getLogger(getClass());

	@Path("/greeting")
    @GET
    @Produces("application/json")
	public String getMetadata() {
		
		Jwt jwt = (Jwt)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.debug(jwt.toString());
		
        return "Hello World!";
    }
}
