package model.road;

import java.util.ArrayList;

public abstract class Road {

    protected double mapX;
    protected double mapY;
    protected double requiredVehicleRotation;
    protected ArrayList<Waypoint> route;



    protected void mapTheRoadCurve(double newMapX,double newMapY,double newVehicleRotation,boolean vehicleShouldRotate,ArrayList<Waypoint>carRoute)
    {
        for(int i=0;i<25;i++)
        {
            mapX+=newMapX;
            mapY+=newMapY;
            requiredVehicleRotation +=newVehicleRotation;
            carRoute.add(new Waypoint(mapX,mapY, requiredVehicleRotation,vehicleShouldRotate));
        }
    }



}
