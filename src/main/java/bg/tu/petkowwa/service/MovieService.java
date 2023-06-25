package bg.tu.petkowwa.service;

import bg.tu.petkowwa.model.dto.ActorDTO;
import bg.tu.petkowwa.model.dto.MovieDTO;
import bg.tu.petkowwa.model.entity.ActorEntity;
import bg.tu.petkowwa.model.entity.MovieEntity;
import bg.tu.petkowwa.repository.ActorRepository;
import bg.tu.petkowwa.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  private final MovieRepository movieRepository;
  private ActorRepository actorRepository;

  public MovieService(MovieRepository movieRepository,
                      ActorRepository actorRepository) {
    this.movieRepository = movieRepository;
    this.actorRepository = actorRepository;
  }


  public long createMovie(MovieDTO newMovie) {
    String actorName = newMovie.getActor().getName();
    Optional<ActorEntity> actorOpt = this.actorRepository.findActorEntityByName(actorName);

    MovieEntity newMovieEntity = new MovieEntity().
        setTitle(newMovie.getTitle()).
        setImdb(newMovie.getImdb()).
        setActor(actorOpt.orElseGet(() -> createNewActor(actorName)));

    return movieRepository.save(newMovieEntity).getId();
  }

  private ActorEntity createNewActor(String actorName) {
    return actorRepository.save(new ActorEntity().setName(actorName));
  }

  public void deleteById(Long bookId) {
    movieRepository.
        findById(bookId).
        ifPresent(movieRepository::delete);
  }

  public Optional<MovieDTO> findMovieById(Long movieId) {
    return movieRepository.
        findById(movieId).
        map(this::map);
  }

  public List<MovieDTO> getAllMovies() {
    return movieRepository.findAll().
        stream().
        map(this::map).
        toList();
  }

  private MovieDTO map(MovieEntity movieEntity) {

    ActorDTO actorDTO = new ActorDTO().
        setName(movieEntity.getActor().getName());

    return new MovieDTO().
        setId(movieEntity.getId()).
        setActor(actorDTO).
        setImdb(movieEntity.getImdb()).
        setTitle(movieEntity.getTitle());
  }
}
