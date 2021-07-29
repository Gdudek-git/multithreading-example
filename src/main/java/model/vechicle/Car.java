package model.vechicle;

import enums.CarType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.GetResourcePath;

public class Car extends Vehicle{

    private boolean isRightLane;
    private CarType carType;

    public Car(boolean isRightLane, CarType carType)
    {
        imageView = new ImageView();
        this.isRightLane=isRightLane;
        this.carType =carType;
    }

    public boolean getIsRightLine()
    {
        return isRightLane;
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

