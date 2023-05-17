package co.com.david.helper;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Map;

public class GenericHelper {
    public static <K,V> MultiValueMap<K,V> mapToMultiValueMap(Map <K,V> map) {
        MultiValueMap<K,V> mvm = new LinkedMultiValueMap<K,V>();
        map.forEach(mvm::add);
        return mvm;
    }
}
