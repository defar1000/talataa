package co.com.david.model.movie.gateways;

import co.com.david.model.movie.Movie;

public interface MovieRepository {
    Movie getById(int id);
}
