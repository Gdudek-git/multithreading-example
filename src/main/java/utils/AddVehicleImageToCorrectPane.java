package utils;

import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import model.vechicle.Car;

public class AddVehicleImageToCorrectPane {

    public synchronized static void addVehicleImageToCorrectPane(Car car, AnchorPane bottomPane, AnchorPane topPane)
    {
        if(car.getIsDrivingLeftToRight())
        {
            Platform.runLater(()->topPane.getChildren().add(car.getImageView()));
        }

        else
        {
            Platform.runLater(()->bottomPane.getChildren().add(car.getImageView()));
        }
    }
}
