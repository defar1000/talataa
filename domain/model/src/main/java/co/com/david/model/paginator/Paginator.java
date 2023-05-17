package co.com.david.model.paginator;
import lombok.*;
//import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Paginator<R> {
    private int page;
    private List<R> results;
    private int total_pages;
    private int total_results;
}
