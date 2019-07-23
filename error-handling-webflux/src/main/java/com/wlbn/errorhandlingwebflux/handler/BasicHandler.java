package com.wlbn.errorhandlingwebflux.handler;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.wlbn.errorhandlingwebflux.exception.CustomException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class BasicHandler {

	public static final String QUERY_PARAM = "msg";

	public Mono<ServerResponse> handleBasicRequest(ServerRequest request) {

		// Handling exception using onErrorReturn method.
//		return Mono.defer(() -> getResponseMessage(request)).onErrorReturn("Exception occurred!")
//				.flatMap(respText -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//						.body(BodyInserters.fromObject(respText)));

		// Handling exception using onErrorResume method.
		// 1. Create dynamic fallback method when error occurred.
//		return Mono.defer(() -> getResponseMessage(request))
//				.onErrorResume(e -> Mono.just("Exception handled by onErrorResume dynamic fallback method."))
//				.flatMap(respText -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//						.body(BodyInserters.fromObject(respText)));
		
		// 2. Create a custom fallback method when error occurred.
//		return Mono.defer(() -> getResponseMessage(request))
//				.onErrorResume(e -> customFallback())
//				.flatMap(respText -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//						.body(BodyInserters.fromObject(respText)));
		
		// 3. Catch, wrap, and re-throw an error while exception occurred.
//		return Mono.defer(() -> getResponseMessage(request))
//				.onErrorResume(e -> Mono.error(new CustomException(HttpStatus.BAD_REQUEST, "Message is required!", e)))
//				.flatMap(respText -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
//						.body(BodyInserters.fromObject(respText)));
		
		return Mono.defer(() -> getResponseMessage(request))
		.flatMap(respText -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(BodyInserters.fromObject(respText)));

				
	}
	
//	private Mono<String> customFallback() {
//		return Mono.just("Exception handled by onErrorResume custom falllback method.");
//	}

	private Mono<String> getResponseMessage(ServerRequest request) {
		Optional<String> msg = request.queryParam(QUERY_PARAM);
		if (msg.isPresent())
			log.debug("Request parameter is:{}", msg.get());
		return Mono.just("Hello " + msg.get() + "!");
	}

}
