package model.vechicle;

import enums.TrainType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Train extends Vehicle {

    private TrainType trainType;

    public Train(TrainType trainType)
    {
        imageView = new ImageView();
        this.trainType = trainType;
    }

    @Override
    public void setImageView()
    {
        imageView.setImage(new Image(trainType.imagePath,150,105,true,true));
    }

    @Override
    public void setImageViewSize()
    {
        super.setImageViewSize();
        imageView.setFitWidth(150);
        imageView.setFitHeight(105);
    }
}
