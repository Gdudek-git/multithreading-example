package model.vechicle;

import javafx.scene.image.ImageView;
import model.road.Waypoint;

import java.util.ArrayList;

public abstract class Vehicle {

    protected ArrayList<Waypoint> route;

    protected int speed=50;
    protected ImageView imageView;
    protected boolean isDrivingLeftToRight;


    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void setRoute(ArrayList<Waypoint> route)
    {
        this.route = route;
    }

    public ArrayList<Waypoint> getRoute()
    {
        return route;
    }

    public ImageView getImageView()
    {
        return imageView;
    }

    public void setImageView()
    {
    }

    public void setImageViewSize()
    {
        imageView.setPreserveRatio(false);
    }

}
