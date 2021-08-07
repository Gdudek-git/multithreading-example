package model.drivers;

import javafx.application.Platform;
import model.railroad_tracks.CrossingKeeper;
import model.road.Waypoint;
import model.vechicle.Vehicle;

public class TrainDriver extends Driver {

    CrossingKeeper crossingKeeper;

    public TrainDriver(Vehicle vehicle,CrossingKeeper crossingKeeper)
    {
        this.vehicle=vehicle;
        this.crossingKeeper = crossingKeeper;

    }

    public void drive()
    {
        Platform.runLater(() ->
        {
            vehicle.getImageView().setY(vehicle.getRoute().get(0).getMapY());
            vehicle.getImageView().setX(vehicle.getRoute().get(0).getMapX());
        });
        informCrossingKeeperThatTrainIsComing();

        for(Waypoint waypoint:vehicle.getRoute())
        {

            Platform.runLater(() -> vehicle.getImageView().setX(waypoint.getMapX()));
            super.simulateSpeed();
        }
        informCrossingKeeperThatTrainIsGone();
    }

    private void informCrossingKeeperThatTrainIsComing()
    {
        crossingKeeper.trainIsComing();
        giveCrossingKeeperTimeToReact();
    }

    private void informCrossingKeeperThatTrainIsGone()
    {
        crossingKeeper.trainIsGone();
    }

    private void giveCrossingKeeperTimeToReact()
    {
        try
        {
            Thread.sleep(10000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
