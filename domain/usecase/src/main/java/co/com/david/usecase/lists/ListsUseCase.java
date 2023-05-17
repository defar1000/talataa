package co.com.david.usecase.lists;

import co.com.david.model.Status;
import co.com.david.model.lista.Lista;
import co.com.david.model.lista.gateways.ListaRepository;
import co.com.david.model.movie.Movie;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ListsUseCase {
    private final ListaRepository listaRepository;

    public Lista getDetailsById (int id) {
        return listaRepository.getDetailsById(id);
    }

    public Status deleteMovieOnList (int id, Movie body) {
        return listaRepository.deleteMovieOnList(id, body);
    }

    public Status saveMovieOnList (int id, Movie body) {
        return listaRepository.saveMovieOnList(id, body);
    }

    public Lista updateMovies (int id, List<Movie> body) {
        clearMovies(id);
        body.forEach(movie -> {
            saveMovieOnList(id, movie);
        });
        return getDetailsById(id);
    }
    public Lista clearMovies (int id) {
        listaRepository.clearMovies(id);
        return getDetailsById(id);
    }
}
