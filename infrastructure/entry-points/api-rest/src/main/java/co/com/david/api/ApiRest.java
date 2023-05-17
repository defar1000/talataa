package co.com.david.api;

import co.com.david.model.movie.Movie;
import co.com.david.model.paginator.Paginator;
import co.com.david.usecase.movies.MoviesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final MoviesUseCase useCase;

    @GetMapping(path = "/movie")
    public ResponseEntity<Paginator<Movie>> getAllMovies(@RequestParam(required = false) Map<String, String> filters) {
        return new ResponseEntity<>(useCase.getAllMovies(filters), HttpStatus.OK);
    }

    @GetMapping(path = "/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Integer id) {
        return new ResponseEntity<>(useCase.getById(id), HttpStatus.OK);
    }
}
