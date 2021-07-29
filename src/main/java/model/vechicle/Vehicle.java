package model.vechicle;

import javafx.scene.image.ImageView;

public abstract class Vehicle {

    protected int speed=50;
    protected ImageView imageView;

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
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
