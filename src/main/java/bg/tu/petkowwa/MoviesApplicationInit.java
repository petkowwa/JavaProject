package bg.tu.petkowwa;

import bg.tu.petkowwa.model.entity.ActorEntity;
import bg.tu.petkowwa.model.entity.MovieEntity;
import bg.tu.petkowwa.repository.ActorRepository;
import bg.tu.petkowwa.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class MoviesApplicationInit implements CommandLineRunner {

  private final ActorRepository actorRepository;
  private final MovieRepository movieRepository;


  MoviesApplicationInit(ActorRepository actorRepository,
                        MovieRepository movieRepository) {

    this.actorRepository = actorRepository;
    this.movieRepository = movieRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    if (movieRepository.count() == 0 && actorRepository.count() == 0) {
      initCrowe();
      initJohnnyDepp();
      initBradPitt();
      initChristianBale();
      initAlPacino();
    }
  }

  private void initJohnnyDepp() {
    initActor("JohnnyDepp",
        "Pirates of the Caribbean"
    );
  }

  private void initBradPitt() {
    initActor("Brad Pitt",
        "Snatch"
    );
  }

  private void initChristianBale() {
    initActor("Christian Bale",
        "American Psycho",
        "The Machinist",
        "The Black Knight"
    );
  }

  private void initAlPacino() {
    initActor("Al Pacino",
        "Scent of a Woman",
        "Heat",
        "The Devil's Advocate"
    );
  }

  private void initCrowe() {

    initActor("Russel Crowe",
        "Gladiator",
        "LA Confidential");
  }

  private void initActor(String actorName, String... movies) {
    ActorEntity actor = new ActorEntity();
    actor.setName(actorName);
    actor = actorRepository.save(actor);

    List<MovieEntity> allMovies = new ArrayList<>();

    for (String movie: movies) {
      MovieEntity aMovie = new MovieEntity();
      aMovie.setActor(actor);
      aMovie.setTitle(movie);
      aMovie.setImdb(UUID.randomUUID().toString());//random string, not real, dummy
      allMovies.add(aMovie);
    }

    actor.setMovies(allMovies);
    actorRepository.save(actor);

    movieRepository.saveAll(allMovies);
  }
}
