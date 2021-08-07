package controller;


import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.display.CarDisplayManager;
import model.drivers.CarDriver;
import model.drivers.TrainDriver;
import model.railroad_tracks.CrossingKeeper;
import model.spawner.CarSpawner;
import model.spawner.TrainSpawner;
import model.vechicle.Car;
import model.vechicle.Train;
import utils.AddVehicleImageToCorrectPane;

import java.util.concurrent.ThreadLocalRandom;


public class MapViewController {

    @FXML
    private AnchorPane bottomPane;
    @FXML
    private AnchorPane topPane;
    @FXML
    private ImageView barrierLights;
    @FXML
    private ImageView bottomBarrier;
    @FXML
    private ImageView topBarrier;


    @FXML
    public void initialize()
    {
        startSpawning();
    }


    private void startSpawning()
    {
        CarSpawner carSpawner = new CarSpawner();
        TrainSpawner trainSpawner = new TrainSpawner();

        Runnable cars = () -> spawnCars(carSpawner);
        Thread car = new Thread(cars);
        car.setDaemon(true);
        car.start();

        spawnTrain(trainSpawner);
    }

    private void spawnCars(CarSpawner carSpawner)
    {
        while(true)
        {
            Task<Void> task = new Task<>()
            {
                @Override
                protected Void call()
                {
                    Car car = carSpawner.spawnCar();
                    if (car != null)
                    {
                        CarDisplayManager carDisplayManager = new CarDisplayManager(bottomPane, topPane);
                        CarDriver carDriver = new CarDriver(car, carDisplayManager);
                        carSpawner.increaseAmountOfSpawnedCars();
                        AddVehicleImageToCorrectPane.addVehicleImageToCorrectPane(car, bottomPane, topPane);
                        carDriver.drive();
                        carSpawner.decreaseAmountOfSpawnedCars();
                    }
                    return null;
                }
            };
            Thread t = new Thread(task);
            t.setDaemon(true);
            t.start();
            waitBeforeSpawningAnotherCar();
        }
    }

    private void waitBeforeSpawningAnotherCar()
    {
        try
        {
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000,5000));
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void spawnTrain(TrainSpawner trainSpawner)
    {
        CrossingKeeper crossingKeeper = new CrossingKeeper(topBarrier,bottomBarrier,barrierLights);
        Task<Void> trains = new Task<>()
        {
            @Override
            protected Void call()
            {
                while(true)
                {
                    Train train = trainSpawner.spawnTrain();
                    TrainDriver trainDriver = new TrainDriver(train,crossingKeeper);
                    Platform.runLater(()->topPane.getChildren().add(train.getImageView()));
                    trainDriver.drive();
                    try
                    {
                        Thread.sleep(23000);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread train = new Thread(trains);
        train.setDaemon(true);
        train.start();
    }
}
