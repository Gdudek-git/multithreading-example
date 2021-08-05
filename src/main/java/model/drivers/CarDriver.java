package model.drivers;

import javafx.application.Platform;
import model.display.CarDisplayManager;
import model.road.Waypoint;
import model.vechicle.Car;
import model.vechicle.Vehicle;
import utils.SetNodeOrientation;


public class CarDriver extends Driver {

    private CarDisplayManager carDisplayManager;
    private Driver.VehiclesSynchronization vehiclesSynchronization;

    public CarDriver(Vehicle vehicle,CarDisplayManager carDisplayManager)
    {
        this.vehicle=vehicle;
        this.carDisplayManager = carDisplayManager;
        vehiclesSynchronization = this.new VehiclesSynchronization();
    }

    public void drive()
    {
        int waypointIndex = 0;
        for(Waypoint waypoint: vehicle.getRoute())
        {
            Platform.runLater(() ->
            {
                vehicle.getImageView().setLayoutX(waypoint.getMapX());
                vehicle.getImageView().setLayoutY(waypoint.getMapY());
                vehicle.getImageView().setRotate(waypoint.getRequiredVehicleRotation());
            });

            changeNodeOrientation(waypoint);
            carDisplayManager.ensureCarImageIsInCorrectAnchorPane((Car)vehicle,waypoint);

            vehiclesSynchronization.setVehicleDrivesThroughWaypoint(waypointIndex,vehicle.getRoute());
            if(waypointIndex+30<vehicle.getRoute().size())
            {
                vehiclesSynchronization.checkIfTherIsAnotherVehicleInFrontOf(waypointIndex + 30, vehicle.getRoute());
            }
            super.simulateSpeed();
            vehiclesSynchronization.setVehicleDroveThroughWaypoint(waypointIndex,vehicle.getRoute());
            waypointIndex++;
        }

    }




    private void changeNodeOrientation(Waypoint waypoint)
    {
        if(waypoint.getVehicleShouldRotate())
        {
            SetNodeOrientation.setNodeOrientation(true,vehicle.getImageView());
        }
        else
        {
            SetNodeOrientation.setNodeOrientation(false,vehicle.getImageView());
        }
    }

}
