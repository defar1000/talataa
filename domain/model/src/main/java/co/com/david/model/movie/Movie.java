package co.com.david.model.movie;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Movie {
    private boolean adult;
    private String backdrop_path;
    private List<Integer> genre_ids;
    private int id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
    private String belongs_to_collection;
    private int budget;
    private String homepage;
    private String imdb_id;
    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private List<Genero> genres;
    private List<CompaniaProductora> production_companies;
    private List<PaisProductor> production_countries;
    private List<Idioma> spoken_languages;

}
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class Genero {
    private int id;
    private String name;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class CompaniaProductora {
    private int id;
    private String logo_path;
    private String name;
    private String origin_country;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class PaisProductor {
    private String iso_3166_1;
    private String name;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
class Idioma {
    private String english_name;
    private String iso_639_1;
    private String name;
}
