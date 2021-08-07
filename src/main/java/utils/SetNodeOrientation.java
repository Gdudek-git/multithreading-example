package utils;

import javafx.application.Platform;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;

public class SetNodeOrientation {

    public synchronized static void setNodeOrientation(boolean isLeftToRight, Node node)
    {
        if(isLeftToRight)
        {
            Platform.runLater(()->node.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT));
        }
        else
        {
            Platform.runLater(()->node.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT));
        }
    }

}
