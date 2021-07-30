package model.road;

import java.util.ArrayList;

public abstract class Road {

    protected double mapX;
    protected double mapY;
    protected double vehicleRotation;
    protected static ArrayList<Waypoint> roadCoordinates;


    protected void mapTheRoadCurve(double newMapX,double newMapY,double newVehicleRotation,boolean vehicleShouldRotate)
    {
        for(int i=0;i<25;i++)
        {
            mapX+=newMapX;
            mapY+=newMapY;
            vehicleRotation+=newVehicleRotation;
            roadCoordinates.add(new Waypoint(mapX,mapY,vehicleRotation,vehicleShouldRotate));
        }
    }

    public ArrayList getRoadCoordinates()
    {
        return roadCoordinates;
    }

}
