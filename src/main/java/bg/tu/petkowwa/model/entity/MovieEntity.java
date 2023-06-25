package bg.tu.petkowwa.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String imdb;

  @ManyToOne
  private ActorEntity actor;

  public Long getId() {
    return id;
  }

  public MovieEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public MovieEntity setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getImdb() {
    return imdb;
  }

  public MovieEntity setImdb(String imdb) {
    this.imdb = imdb;
    return this;
  }

  public ActorEntity getActor() {
    return actor;
  }

  public MovieEntity setActor(ActorEntity actor) {
    this.actor = actor;
    return this;
  }

  @Override
  public String toString() {
    return "MovieEntity{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", imdb='" + imdb + '\'' +
        ", actor=" + (actor != null ? actor.getName() : null) +
        '}';
  }
}
