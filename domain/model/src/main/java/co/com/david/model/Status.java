package co.com.david.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Status {
    private int status_code;
    private String status_message;
}
