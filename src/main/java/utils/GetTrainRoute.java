package utils;

import model.road.RailRoadTracks;
import model.road.Waypoint;
import model.vechicle.Train;
import java.util.ArrayList;


public class GetTrainRoute {

    public synchronized static ArrayList<Waypoint> getTrainRoute(Train train)
    {
        if(train.getIsDrivingLeftToRight())
        {
            return RailRoadTracks.getInstance().getRoute();
        }

        return RailRoadTracks.getInstance().getReversedRoute();
    }
}
