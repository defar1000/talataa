package co.com.david.usecase.movies;
import co.com.david.model.movie.Movie;
import co.com.david.model.paginator.Paginator;
import co.com.david.model.paginator.gateways.PaginatorRepository;
import lombok.RequiredArgsConstructor;

import java.util.Map;


@RequiredArgsConstructor
public class MoviesUseCase {

    private final PaginatorRepository repository;

    public Paginator<Movie> getAllMovies(Map<String, String> filters) {
        return repository.getAllMovies(filters);
    }
}
