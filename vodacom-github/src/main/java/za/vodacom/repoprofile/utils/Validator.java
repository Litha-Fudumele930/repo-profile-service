package za.vodacom.repoprofile.utils;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Validator {

    public static boolean isSupplied(String value) {
        return (value == null || value.isEmpty()) ? false : true;
    }

    public static <T> boolean isSupplied(List<T> value) {
        return (value == null || value.size() < 1) ? false : true;
    }

    public static boolean isSupplied(Object value) {
        return (value == null) ? false : true;
    }
}
