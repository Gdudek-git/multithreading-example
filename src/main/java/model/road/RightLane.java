package model.road;

import java.util.ArrayList;

public final class RightLane extends Road {

    private static RightLane rightLane;

    public static RightLane getRightLane()
    {
        if(rightLane==null)
        {
            rightLane = new RightLane();
        }
        return rightLane;
    }

    public ArrayList<Waypoint> getCarRoute()
    {
        return route;
    }

    private RightLane()
    {
        mapX =-100;
        mapY = 224;
        requiredVehicleRotation = 0;
        route = new ArrayList<>();

        mapTheRoad();
    }

    private void mapTheRoad()
    {
        for(;mapX<=800;mapX+=5)
        {
            route.add(new Waypoint(mapX,224,0,false));
        }

        super.mapTheRoadCurve(2.4,3.84,3.6,false, route);
        requiredVehicleRotation = -90;
        route.add(new Waypoint(860,mapY, requiredVehicleRotation,true));
        super.mapTheRoadCurve(-3.2,3.2,3.6,true, route);

        for(; mapX>=135; mapX-=5)
        {
            route.add(new Waypoint(mapX,mapY, requiredVehicleRotation,true));
        }

        super.mapTheRoadCurve(-2.4,5.8,-3.6,true, route);
        requiredVehicleRotation = 90;
        route.add(new Waypoint(mapX,mapY,90,false));
        super.mapTheRoadCurve(5.2,4.8,-3.6,false, route);

        for(;mapX<=1220;mapX+=5)
        {
            route.add(new Waypoint(mapX,mapY,0,false));
        }

    }
}
