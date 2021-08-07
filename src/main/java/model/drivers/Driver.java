package model.drivers;

import model.road.Waypoint;
import model.vechicle.Vehicle;

import java.util.ArrayList;


public abstract class Driver {

    protected Vehicle vehicle;

    protected void drive(){}

    protected void simulateSpeed()
    {
        try
        {
            Thread.sleep(vehicle.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected class VehiclesSynchronization
    {
        protected void setVehicleDrivesThroughWaypoint(int waypointIndex,ArrayList<Waypoint>route)
        {
            route.get(waypointIndex).setWaypointIsOccupied();
        }

        protected void setVehicleDroveThroughWaypoint(int waypointIndex,ArrayList<Waypoint>route)
        {
            route.get(waypointIndex).setWaypointIsNotOccupied();
        }

        protected void checkIfThereIsAnotherVehicleInFrontOf(int waypointIndex, ArrayList<Waypoint>route)
        {
            while(route.get(waypointIndex).getOccupied())
            {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }



    }

}
