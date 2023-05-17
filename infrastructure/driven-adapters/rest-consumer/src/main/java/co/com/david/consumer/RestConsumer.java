package co.com.david.consumer;

import co.com.david.helper.GenericHelper;
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
public class RestConsumer implements PaginatorRepository, MovieRepository {

    private final WebClient client;

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
}