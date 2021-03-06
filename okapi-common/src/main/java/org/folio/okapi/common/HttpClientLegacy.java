package org.folio.okapi.common;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.net.SocketAddress;

public class HttpClientLegacy {
  private HttpClientLegacy() {
    throw new IllegalStateException("HttpClientLegacy");
  }

  /**
   * Send HTTP request with style ala Vert.x 3.
   * @param client HTTP client
   * @param method HTTP method
   * @param socketAddress socket address
   * @param url Full URL
   * @param response response handler
   * @return handler for HTTP request
   */
  public static HttpClientRequest requestAbs(HttpClient client, HttpMethod method,
                                             SocketAddress socketAddress, String url,
                                             Handler<HttpClientResponse> response) {
    return client.requestAbs(method, socketAddress, url, hndlr -> {
      if (hndlr.succeeded()) {
        response.handle(hndlr.result());
      }
    });
  }

  /**
   * Send HTTP request with style ala Vert.x 3.
   * @param client HTTP client
   * @param method HTTP method
   * @param url Full URL
   * @param response response handler
   * @return handler for HTTP request
   */
  public static HttpClientRequest requestAbs(HttpClient client, HttpMethod method,
                                             String url, Handler<HttpClientResponse> response) {
    return client.requestAbs(method, url, hndlr -> {
      if (hndlr.succeeded()) {
        response.handle(hndlr.result());
      }
    });
  }


  /**
   * Send HTTP request with style ala Vert.x 3.
   * @param client HTTP client
   * @param method HTTP method
   * @param port server port
   * @param host server host
   * @param response response handler
   * @return handler for HTTP request
   */
  public static HttpClientRequest request(HttpClient client, HttpMethod method, int port,
                                          String host, String uri,
                                          Handler<HttpClientResponse> response) {
    return client.request(method, port, host, uri, hndlr -> {
      if (hndlr.succeeded()) {
        response.handle(hndlr.result());
      }
    });
  }

  /**
   * Send HTTP POST request with style ala Vert.x 3.
   * @param client HTTP client
   * @param port server port
   * @param host server host
   * @param response response handler
   * @return handler for HTTP request
   */
  public static HttpClientRequest post(HttpClient client, int port,
                                       String host, String uri,
                                       Handler<HttpClientResponse> response) {
    return request(client, HttpMethod.POST, port, host, uri, response);
  }

  /**
   * Send HTTP GET request with style ala Vert.x 3.
   * @param client HTTP client
   * @param port server port
   * @param host server host
   * @param response response handler
   * @return handler for HTTP request
   */
  public static HttpClientRequest get(HttpClient client, int port,
                                      String host, String uri,
                                      Handler<HttpClientResponse> response) {
    return request(client, HttpMethod.GET, port, host, uri, response);
  }

  /**
   * Send HTTP DELETE request with style ala Vert.x 3.
   * @param client HTTP client
   * @param port server port
   * @param host server host
   * @param response response handler
   * @return handler for HTTP request
   */
  public static HttpClientRequest delete(HttpClient client, int port,
                                         String host, String uri,
                                         Handler<HttpClientResponse> response) {
    return request(client, HttpMethod.DELETE, port, host, uri, response);
  }
}
