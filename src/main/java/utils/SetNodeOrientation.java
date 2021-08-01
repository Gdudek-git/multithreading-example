package utils;

import javafx.geometry.NodeOrientation;
import javafx.scene.Node;

public class SetNodeOrientation {

    public synchronized static void setNodeOrientation(boolean isLeftToRight, Node node)
    {
        if(!isLeftToRight)
        {
            node.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        }
        else
        {
            node.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        }
    }

}
