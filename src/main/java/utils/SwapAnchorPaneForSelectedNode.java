package utils;

import javafx.application.Platform;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class SwapAnchorPaneForSelectedNode {

    public synchronized static void swapToTopPane(AnchorPane topPane, AnchorPane bottomPane, ImageView image)
    {
        Platform.runLater(()->
        {
            topPane.getChildren().add(image);
            bottomPane.getChildren().remove(image);
        });
    }

    public synchronized static void swapToBottomPane(AnchorPane bottomPane, AnchorPane topPane,ImageView image)
    {
        Platform.runLater(()->
        {
            bottomPane.getChildren().add(image);
            topPane.getChildren().remove(image);
        });
    }

}
