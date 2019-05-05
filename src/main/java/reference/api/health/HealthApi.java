package reference.api.health;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;

import com.google.gson.Gson;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reference.api.Api;
import reference.api.health.Health.Status;

public class HealthApi implements Api {

  public static final String ENDPOINT = "/health";
  private final Gson gson;

  public HealthApi(Gson gson) {
    this.gson = gson;
  }

  public Publisher<Void> handle(HttpServerRequest request, HttpServerResponse response) {
    Health health = new Health(Status.UP);
    String healthJson = gson.toJson(health);
    return response.status(OK).sendString(Mono.just(healthJson));
  }
}
