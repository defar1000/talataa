package co.com.david.api;

import co.com.david.usecase.movies.MoviesUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApiRestTest {

    ApiRest apiRest = new ApiRest(null);

    @Test
    void apiRestTest() {
        var response = apiRest.getAllMovies(null);
//        assertEquals("Hello World", response);
    }
}
