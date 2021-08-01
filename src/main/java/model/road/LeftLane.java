package model.road;

import java.util.ArrayList;

public final class LeftLane extends Road {

    private static LeftLane leftLane;


    public static LeftLane getLeftLane()
    {
        if(leftLane==null)
        {
            leftLane = new LeftLane();
        }
        return leftLane;
    }

    public ArrayList<Waypoint> getCarRoute()
    {
        return route;
    }

    private LeftLane()
    {
        mapX =1220;
        mapY = 620;
        vehicleRotation = 0;
        route = new ArrayList<>();

        mapTheRoad();
    }

    private void mapTheRoad()
    {
        for(;mapX>=210;mapX-=5)
        {
            route.add(new Waypoint(mapX,mapY,0,true));
        }

        super.mapTheRoadCurve(-2.6,-3.2,3.6,true, route);
        vehicleRotation = -90;
        route.add(new Waypoint(mapX,mapY,vehicleRotation,false));
        super.mapTheRoadCurve(1.6,-4.2,3.6,false, route);
        vehicleRotation = 0;

        for(;mapX<795;mapX+=5)
        {
            route.add(new Waypoint(mapX,mapY,vehicleRotation,false));
        }

        super.mapTheRoadCurve(5,-4.48,-3.6,false, route);
        vehicleRotation = -90;
        route.add(new Waypoint(mapX,mapY,vehicleRotation,false));
        super.mapTheRoadCurve(-3.4,-5.8,-3.6,true, route);

        for(;mapX>-120;mapX-=5)
        {
            route.add(new Waypoint(mapX,mapY,vehicleRotation,false));
        }
    }
}