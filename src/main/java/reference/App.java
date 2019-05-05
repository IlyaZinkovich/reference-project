package reference;

import com.google.gson.Gson;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.netty.http.server.HttpServer;
import reference.api.health.HealthApi;

public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);
  private static final Gson GSON = new Gson();
  private static final Duration SHUTDOWN_TIMEOUT = Duration.ofSeconds(10);
  private static final HealthApi healthApi = new HealthApi(GSON);

  public static void main(String[] args) {
    HttpServer.create()
        .port(8080)
        .route(routes -> routes.get(HealthApi.ENDPOINT, healthApi::handle))
        .bindUntilJavaShutdown(
            SHUTDOWN_TIMEOUT,
            server -> log.info("Started HTTP server on port {}.", server.port())
        );
  }
}
