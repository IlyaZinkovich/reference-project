package reference.api;

import org.reactivestreams.Publisher;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

public interface Api {

  Publisher<Void> handle(HttpServerRequest request, HttpServerResponse response);
}
