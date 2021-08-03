package model.drivers;

import javafx.application.Platform;
import model.road.Waypoint;
import model.vechicle.Vehicle;

public class TrainDriver extends Driver {

    public TrainDriver(Vehicle vehicle)
    {
        this.vehicle=vehicle;

    }

    public void drive()
    {
        Platform.runLater(() -> vehicle.getImageView().setY(vehicle.getRoute().get(0).getMapY()));
        for(Waypoint waypoint:vehicle.getRoute())
        {

            Platform.runLater(() -> vehicle.getImageView().setX(waypoint.getMapX()));
            super.simulateSpeed();
        }
    }

}
