package model.road;


import java.util.ArrayList;
import java.util.Collections;

public final class RailRoadTracks extends Road {

    private static RailRoadTracks railRoadTracks;
    private ArrayList<Waypoint> reversedRoute;

    public static RailRoadTracks getInstance()
    {
        if(railRoadTracks==null)
        {
            railRoadTracks = new RailRoadTracks();
        }
        return railRoadTracks;
    }

    public ArrayList<Waypoint> getReversedRoute()
    {
        return reversedRoute;
    }

    private RailRoadTracks()
    {
        mapX = -300;
        mapY=275;
        route = new ArrayList<>();
        mapTheRoad();
        createReversedRoute();
    }

    private void createReversedRoute()
    {
        reversedRoute = (ArrayList<Waypoint>)route.clone();
        Collections.reverse(reversedRoute);
    }

    private void mapTheRoad()
    {
        for(;mapX<1300;mapX+=5)
        {
            route.add(new Waypoint(mapX,mapY,0,false));
        }
    }



}
