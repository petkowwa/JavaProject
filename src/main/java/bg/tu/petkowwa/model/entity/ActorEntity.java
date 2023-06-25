package bg.tu.petkowwa.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "actors")
public class ActorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy = "actor")
  private List<MovieEntity> movies;

  public Long getId() {
    return id;
  }

  public ActorEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public ActorEntity setName(String name) {
    this.name = name;
    return this;
  }

  public List<MovieEntity> getMovies() {
    return movies;
  }

  public ActorEntity setMovies(List<MovieEntity> movies) {
    this.movies = movies;
    return this;
  }

  @Override
  public String toString() {
    return "ActorEntity{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", movies=" + movies +
        '}';
  }
}
