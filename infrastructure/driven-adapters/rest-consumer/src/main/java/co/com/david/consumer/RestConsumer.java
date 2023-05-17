package co.com.david.consumer;

import co.com.david.consumer.config.RestConsumerConfig;
import co.com.david.helper.GenericHelper;
import co.com.david.model.Status;
import co.com.david.model.lista.Lista;
import co.com.david.model.lista.gateways.ListaRepository;
import co.com.david.model.movie.Movie;
import co.com.david.model.movie.gateways.MovieRepository;
import co.com.david.model.paginator.Paginator;
import co.com.david.model.paginator.gateways.PaginatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestConsumer implements PaginatorRepository, MovieRepository, ListaRepository {

    private final WebClient client;
    private final RestConsumerConfig config;

    @Override
    public Paginator<Movie> getAllMovies(Map<String, String> filters) {
        MultiValueMap<String, String> mvMap = GenericHelper.mapToMultiValueMap(filters);
        return client
                .get()
                .uri(uriBuilder -> {
                    return uriBuilder.path("/discover/movie")
                        .queryParams(mvMap)
                        .build();
                })
                .retrieve()
                .bodyToMono(PaginatorResponse.class)
                .blockOptional().orElseGet(PaginatorResponse::new);
    }

    @Override
    public Movie getById(int id) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder.path("/movie").path("/"+id).build())
                .retrieve()
                .bodyToMono(MovieResponse.class)
                .blockOptional().orElseGet(MovieResponse::new);
    }

    @Override
    public Lista getDetailsById(int id) {
        return client
                .get()
                .uri(uriBuilder -> {
                    return uriBuilder.path("/list")
                            .path("/"+id)
                            .queryParam("session_id", config.getSessionId())
                            .build();
                })
                .retrieve()
                .bodyToMono(ListaResponse.class)
                .blockOptional().orElseGet(ListaResponse::new);
    }

    @Override
    public Status deleteMovieOnList(int id, Movie body) {
        return client
                .post()
                .uri(uriBuilder -> {
                    return uriBuilder.path("/list")
                            .path("/"+id)
                            .path("/remove_item")
                            .queryParam("session_id", config.getSessionId())
                            .build();
                })
                .retrieve()
                .bodyToMono(StatusResponse.class)
                .blockOptional().orElseGet(StatusResponse::new);
    }

    @Override
    public Status saveMovieOnList(int id, Movie body) {
        return client
                .post()
                .uri(uriBuilder -> {
                    return uriBuilder.path("/list")
                            .path("/"+id)
                            .path("/add_item")
                            .queryParam("session_id", config.getSessionId())
                            .build();
                })
                .retrieve()
                .bodyToMono(StatusResponse.class)
                .blockOptional().orElseGet(StatusResponse::new);
    }

    @Override
    public Status clearMovies(int id) {
        return client
                .post()
                .uri(uriBuilder -> {
                    return uriBuilder.path("/list")
                            .path("/"+id)
                            .path("/clear")
                            .queryParam("session_id", config.getSessionId())
                            .build();
                })
                .retrieve()
                .bodyToMono(StatusResponse.class)
                .blockOptional().orElseGet(StatusResponse::new);
    }
}