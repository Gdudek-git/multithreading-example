package utils;

import java.security.SecureRandom;

public class GetRandomCarType {

    private static final SecureRandom random = new SecureRandom();

    public  synchronized static <T extends Enum<?>> T getRandomCarType(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
