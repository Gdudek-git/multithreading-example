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

    private RightLane()
    {
        mapX =-100;
        mapY = 224;
        vehicleRotation = 0;
        roadCoordinates = new ArrayList<>();

        mapTheRoad();
    }

    private void mapTheRoad()
    {
        for(;mapX<=800;mapX+=5)
        {
            roadCoordinates.add(new Waypoint(mapX,224,0,false));
        }

        super.mapTheRoadCurve(2.4,3.84,3.6,false);
        vehicleRotation = -90;
        roadCoordinates.add(new Waypoint(860,mapY,vehicleRotation,true));
        super.mapTheRoadCurve(-3.2,3.2,3.6,true);

        for(; mapX>=135; mapX-=5)
        {
            roadCoordinates.add(new Waypoint(mapX,mapY,vehicleRotation,true));
        }

        super.mapTheRoadCurve(-2.4,5.8,-3.6,true);
        vehicleRotation = 90;
        roadCoordinates.add(new Waypoint(mapX,mapY,90,false));
        super.mapTheRoadCurve(5.2,4.8,-3.6,false);

        for(;mapX<=1220;mapX+=5)
        {
            roadCoordinates.add(new Waypoint(mapX,mapY,0,false));
        }

    }
}
