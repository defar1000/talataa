package co.com.david.api;

import co.com.david.model.Status;
import co.com.david.model.lista.Lista;
import co.com.david.model.movie.Movie;
import co.com.david.model.paginator.Paginator;
import co.com.david.usecase.lists.ListsUseCase;
import co.com.david.usecase.movies.MoviesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final MoviesUseCase moviesUseCase;
    private final ListsUseCase listsUseCase;

    @GetMapping(path = "/movie")
    public ResponseEntity<Paginator<Movie>> getAllMovies(@RequestParam(required = false) Map<String, String> filters) {
        return new ResponseEntity<>(moviesUseCase.getAllMovies(filters), HttpStatus.OK);
    }

    @GetMapping(path = "/list/{id}/details")
    public ResponseEntity<Lista> getListDetailsById(@PathVariable Integer id) {
        return new ResponseEntity<>(listsUseCase.getDetailsById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/list/{id}/remove_item")
    public ResponseEntity<Status> deleteMovieOnList(@PathVariable Integer id, @RequestBody Movie body) {
        return new ResponseEntity<>(listsUseCase.deleteMovieOnList(id, body), HttpStatus.OK);
    }

    @PutMapping(path = "/list/{id}/add_item")
    public ResponseEntity<Status> saveMovieOnList(@PathVariable Integer id, @RequestBody Movie body) {
        return new ResponseEntity<>(listsUseCase.saveMovieOnList(id, body), HttpStatus.OK);
    }

    @PatchMapping(path = "/list/{id}/update_items")
    public ResponseEntity<Lista> updateMoviesOnList(@PathVariable Integer id, @RequestBody List<Movie> body) {
        return new ResponseEntity<>(listsUseCase.updateMovies(id, body), HttpStatus.OK);
    }

    @PostMapping(path = "/list/{id}/clear")
    public ResponseEntity<Lista> clearMoviesOnList(@PathVariable Integer id) {
        return new ResponseEntity<>(listsUseCase.clearMovies(id), HttpStatus.OK);
    }
}
