package co.com.david.model.lista.gateways;

import co.com.david.model.Status;
import co.com.david.model.lista.Lista;
import co.com.david.model.movie.Movie;

public interface ListaRepository {
    Lista getDetailsById (int id);
    Status deleteMovieOnList (int id, Movie body);
    Status saveMovieOnList (int id, Movie body);
//    Lista updateMovies (int id, Movie body);
    Status clearMovies (int id);
}
