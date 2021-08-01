package model.road;

import java.util.ArrayList;

public abstract class Road {

    protected double mapX;
    protected double mapY;
    protected double vehicleRotation;
    protected ArrayList<Waypoint> route;



    protected void mapTheRoadCurve(double newMapX,double newMapY,double newVehicleRotation,boolean vehicleShouldRotate,ArrayList<Waypoint>carRoute)
    {
        for(int i=0;i<25;i++)
        {
            mapX+=newMapX;
            mapY+=newMapY;
            vehicleRotation+=newVehicleRotation;
            carRoute.add(new Waypoint(mapX,mapY,vehicleRotation,vehicleShouldRotate));
        }
    }



}
