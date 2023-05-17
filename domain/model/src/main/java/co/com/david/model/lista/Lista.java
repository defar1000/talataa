package co.com.david.model.lista;
import co.com.david.model.movie.Movie;
import lombok.*;

import java.util.List;
//import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Lista {
    private String created_by;
    private String description;
    private int favorite_count;
    private int id;
    private List<Movie> items;
    private int item_count;
    private String iso_639_1;
    private String name;
    private String poster_path;
}
