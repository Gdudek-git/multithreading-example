package model.spawner;

import enums.CarType;
import model.vechicle.Car;
import utils.*;

public class CarSpawner {

    private int amountOfSpawnedCars = 0;

    public synchronized void decreaseAmountOfSpawnedCars()
    {
        amountOfSpawnedCars--;
    }

    public synchronized void increaseAmountOfSpawnedCars()
    {
        amountOfSpawnedCars++;
    }

    public Car spawnCar()
    {
        if(amountOfSpawnedCars<6)
        {
            return createCar();
        }
        return null;
    }

    private Car createCar()
    {
        Car car = new Car(GetRandomVehicleDirection.getIsLeftToRight(), GetRandomCarType.getRandomCarType(CarType.class));
        car.setImageView();
        car.setImageViewSize();
        SetNodeOrientation.setNodeOrientation(car.getIsDrivingLeftToRight(),car.getImageView());
        car.setSpeed(GetRandomSpeed.getCarSpeed());
        car.setCarRoute(GetCarRoute.getCarRoute(car));
        return car;
    }

}
