package bg.tu.petkowwa.model.dto;

public class ActorDTO {

  private String name;

  public String getName() {
    return name;
  }

  public ActorDTO setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String toString() {
    return "ActorDTO{" +
        "name='" + name + '\'' +
        '}';
  }
}
