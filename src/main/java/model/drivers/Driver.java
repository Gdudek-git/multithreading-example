package model.drivers;


import model.vechicle.Vehicle;



public abstract class Driver {

    protected Vehicle vehicle;

    protected void drive(){}

    protected void simulateSpeed()
    {
        try
        {
            Thread.sleep(vehicle.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
