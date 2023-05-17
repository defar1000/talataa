package co.com.david.model.paginator.gateways;

import co.com.david.model.movie.Movie;
import co.com.david.model.paginator.Paginator;

import java.util.List;
import java.util.Map;

public interface PaginatorRepository {
    Paginator<Movie> getAllMovies(Map<String, String> filters);
}
