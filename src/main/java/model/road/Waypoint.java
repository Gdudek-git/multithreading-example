package model.road;

public class Waypoint {

    private double mapX;
    private double mapY;
    private double requiredVehicleRotation;
    private boolean vehicleShouldRotate;

    public Waypoint(double mapX, double mapY, double requiredVehicleRotation, boolean vehicleShouldRotate) {
        this.mapX = mapX;
        this.mapY = mapY;
        this.requiredVehicleRotation = requiredVehicleRotation;
        this.vehicleShouldRotate = vehicleShouldRotate;
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
