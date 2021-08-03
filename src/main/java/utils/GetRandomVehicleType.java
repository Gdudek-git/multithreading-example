package utils;

import java.security.SecureRandom;

public class GetRandomVehicleType {

    private static final SecureRandom random = new SecureRandom();

    public  synchronized static <T extends Enum<?>> T getRandomVehicleType(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
