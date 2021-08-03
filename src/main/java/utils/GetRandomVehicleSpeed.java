package utils;

import java.util.concurrent.ThreadLocalRandom;

public class GetRandomVehicleSpeed {

    public synchronized static int getCarSpeed()
    {
        return ThreadLocalRandom.current().nextInt(50, 80);
    }

    public synchronized static int getTrainSpeed()
    {
        return ThreadLocalRandom.current().nextInt(10, 40);
    }
}
