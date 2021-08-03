package model.vechicle;

import enums.CarType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.road.Waypoint;
import utils.GetResourcePath;

import java.util.ArrayList;

public class Car extends Vehicle{

    private CarType carType;
    public ArrayList<Waypoint> route;

    public Car(boolean isDrivingLeftToRight, CarType carType)
    {
        imageView = new ImageView();
        this.isDrivingLeftToRight = isDrivingLeftToRight;
        this.carType =carType;
    }



    public boolean getIsDrivingLeftToRight()
    {
        return isDrivingLeftToRight;
    }

    @Override
    public void setImageView()
    {
        imageView.setImage(new Image(GetResourcePath.getResourcePath(carType.imagePath),110,50,true,true));
    }

    @Override
    public void setImageViewSize()
    {
        super.setImageViewSize();
        imageView.setFitWidth(110);
        imageView.setFitHeight(50);
    }
}

