package co.com.david.consumer;

import lombok.*;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
public class ObjectRequest {

    private String val1;
    private String val2;

}
