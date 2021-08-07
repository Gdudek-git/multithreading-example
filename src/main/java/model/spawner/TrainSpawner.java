package model.spawner;

import enums.TrainType;
import model.vechicle.Train;
import utils.*;

public class TrainSpawner {


    public Train spawnTrain()
    {
        return createTrain();
    }

    private Train createTrain()
    {
        Train train = new Train(GetRandomVehicleDirection.getIsLeftToRight(),GetRandomVehicleType.getRandomVehicleType(TrainType.class));
        train.setImageView();
        train.setImageViewSize();
        SetNodeOrientation.setNodeOrientation(train.getIsDrivingLeftToRight(),train.getImageView());
        train.setSpeed(GetRandomVehicleSpeed.getTrainSpeed());
        train.setRoute(GetTrainRoute.getTrainRoute(train));
        return train;
    }
}
