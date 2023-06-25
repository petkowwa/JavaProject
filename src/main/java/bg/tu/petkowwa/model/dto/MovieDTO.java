package bg.tu.petkowwa.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MovieDTO {

  private Long id;
  private String title;

  @NotEmpty
  @Size(min = 5)
  private String imdb;

  private ActorDTO actor;

  public Long getId() {
    return id;
  }

  public MovieDTO setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public MovieDTO setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getImdb() {
    return imdb;
  }

  public MovieDTO setImdb(String imdb) {
    this.imdb = imdb;
    return this;
  }

  public ActorDTO getActor() {
    return actor;
  }

  public MovieDTO setActor(ActorDTO actor) {
    this.actor = actor;
    return this;
  }

  @Override
  public String toString() {
    return "MovieDTO{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", imdb='" + imdb + '\'' +
        ", actor=" + actor +
        '}';
  }
}
