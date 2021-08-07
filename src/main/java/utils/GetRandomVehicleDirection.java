package utils;

import java.util.concurrent.ThreadLocalRandom;

public class GetRandomVehicleDirection {

    public static boolean getIsLeftToRight()
    {
        return ThreadLocalRandom.current().nextInt(0, 2) == 0;
    }
}
