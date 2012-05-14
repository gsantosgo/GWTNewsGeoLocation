package es.uem.geolocation.server.util;

import java.io.IOException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

public class RetryHandler implements HttpRequestRetryHandler {
	public boolean retryRequest(IOException exception, int executionCount,
			HttpContext context) {
		//
		if (executionCount > 3) {
			return false;
		}

		if (exception instanceof NoHttpResponseException) {
			// Retry if the server dropped connection on us
			return true;
		}
		/*
		 * if (exception instanceof SSLHandshakeException) { // Do not retry on
		 * SSL handshake exception return false; }
		 */
		HttpRequest request = (HttpRequest) context
				.getAttribute(ExecutionContext.HTTP_REQUEST);
		boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
		if (idempotent) {
			// Retry if the request is considered idempotent
			return true;
		}
		return false;
	}
}
