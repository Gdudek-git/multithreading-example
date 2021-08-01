package utils;

import model.road.LeftLane;
import model.road.RightLane;
import model.road.Waypoint;
import model.vechicle.Car;

import java.util.ArrayList;

public class GetCarRoute {

    public synchronized static ArrayList<Waypoint> getCarRoute(Car car)
    {
        if(car.getIsDrivingLeftToRight())
        {
            return RightLane.getRightLane().getCarRoute();
        }
        return LeftLane.getLeftLane().getCarRoute();
    }
}
