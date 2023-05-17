package co.com.david.usecase.movies;
import co.com.david.model.movie.Movie;
import co.com.david.model.movie.gateways.MovieRepository;
import co.com.david.model.paginator.Paginator;
import co.com.david.model.paginator.gateways.PaginatorRepository;
import lombok.RequiredArgsConstructor;

import java.util.Map;


@RequiredArgsConstructor
public class MoviesUseCase {

    private final PaginatorRepository paginatorRepository;
    private final MovieRepository movieRepository;

    public Paginator<Movie> getAllMovies(Map<String, String> filters) {
        return paginatorRepository.getAllMovies(filters);
    }
    public Movie getById(int id) {
        return movieRepository.getById(id);
    }
}
