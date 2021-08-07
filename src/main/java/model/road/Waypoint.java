package model.road;

public class Waypoint {

    private double mapX;
    private double mapY;
    private double requiredVehicleRotation;
    private boolean vehicleShouldRotate;
    private volatile boolean isOccupied;

    public Waypoint(double mapX, double mapY, double requiredVehicleRotation, boolean vehicleShouldRotate)
    {
        this.mapX = mapX;
        this.mapY = mapY;
        this.requiredVehicleRotation = requiredVehicleRotation;
        this.vehicleShouldRotate = vehicleShouldRotate;
        isOccupied = false;
    }

    public  boolean getOccupied()
    {
        return isOccupied;
    }

    public void setWaypointIsOccupied()
    {
        isOccupied = true;
    }

    public void setWaypointIsNotOccupied()
    {
        isOccupied = false;
    }


    public double getMapX() {
        return mapX;
    }

    public double getMapY() {
        return mapY;
    }

    public double getRequiredVehicleRotation() {
        return requiredVehicleRotation;
    }

    public boolean getVehicleShouldRotate() {
        return vehicleShouldRotate;
    }
}
