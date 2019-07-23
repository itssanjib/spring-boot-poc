package com.wlbn.errorhandlingwebflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wlbn.errorhandlingwebflux.handler.BasicHandler;

@Configuration
public class BasicRouter {
	
	private static final String ROUTE_INDEX = "/home";
	
	@Autowired
	BasicHandler basicHandler;
	
	@Bean
	public RouterFunction<ServerResponse> index() {		
		return RouterFunctions.route(RequestPredicates.GET(ROUTE_INDEX), basicHandler::handleBasicRequest);
	}

}
