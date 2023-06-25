package bg.tu.petkowwa.web;

import bg.tu.petkowwa.model.dto.MovieDTO;
import bg.tu.petkowwa.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

  private final MovieService movieService;

  public MoviesController(MovieService movieService) {
    this.movieService = movieService;
  }

  @GetMapping
  public ResponseEntity<List<MovieDTO>> getAllMovies() {
    return ResponseEntity.
        ok(movieService.getAllMovies());
  }

  @Operation(summary = "Get movie by the given ID")
  @ApiResponses(
      value = {
          @ApiResponse(responseCode = "200", description = "If the movie was discovered.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MovieDTO.class))}),
          @ApiResponse(responseCode = "400", description = "If the ID was incorrect."),
          @ApiResponse(responseCode = "404", description = "If the movie was not found.")
      }
  )
  @GetMapping("/{id}")
  public ResponseEntity<MovieDTO> getMovieById(@PathVariable("id") Long movieId) {
    Optional<MovieDTO> theMovie = movieService.findMovieById(movieId);

    return
        theMovie.
            map(ResponseEntity::ok).
            orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<MovieDTO> deleteMovieById(@PathVariable("id") Long movieId) {
   movieService.deleteById(movieId);

    return ResponseEntity.
        noContent().
        build();
  }

  @PostMapping()
  public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO newMovie,
            UriComponentsBuilder uriComponentsBuilder) {
    long newMovieId = movieService.createMovie(newMovie);

    return ResponseEntity.created(uriComponentsBuilder.
        path("/api/movies/{id}").build(newMovieId)).
        build();
  }

}
