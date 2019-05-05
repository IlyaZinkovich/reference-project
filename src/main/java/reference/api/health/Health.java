package reference.api.health;

@SuppressWarnings("WeakerAccess")
public class Health {

  public final Status status;

  public Health(final Status status) {
    this.status = status;
  }

  enum Status {
    UP, DOWN
  }
}
