package model.display;

import javafx.scene.layout.AnchorPane;
import model.road.Waypoint;
import model.vechicle.Car;
import utils.SwapAnchorPaneForSelectedNode;

public class CarDisplayManager {

    private AnchorPane bottomPane;
    private AnchorPane topPane;
    private boolean paneChangedForTheFirstTime = false;
    private boolean paneChangedForTheSecondTime = false;

    public CarDisplayManager(AnchorPane bottomPane, AnchorPane topPane)
    {
        this.bottomPane = bottomPane;
        this.topPane = topPane;
    }

    public void ensureCarImageIsInCorrectAnchorPane(Car car, Waypoint waypoint)
    {
        if(car.getIsDrivingLeftToRight())
        {
            if (waypoint.getMapY() > 320 && !paneChangedForTheFirstTime)
            {
                paneChangedForTheFirstTime = true;
                SwapAnchorPaneForSelectedNode.swapToBottomPane(bottomPane, topPane,car.getImageView());
            }
            else
                {
                if (waypoint.getMapY() > 535 && !paneChangedForTheSecondTime)
                {
                    paneChangedForTheSecondTime = true;
                    SwapAnchorPaneForSelectedNode.swapToTopPane(topPane, bottomPane, car.getImageView());
                }
            }
        }
        else
        {
            if (waypoint.getMapY() < 535 && !paneChangedForTheFirstTime)
            {
                paneChangedForTheFirstTime = true;
                SwapAnchorPaneForSelectedNode.swapToTopPane(topPane, bottomPane, car.getImageView());
            }
            else
                {
                if (waypoint.getMapY() < 320 && !paneChangedForTheSecondTime)
                {
                    paneChangedForTheSecondTime = true;
                    SwapAnchorPaneForSelectedNode.swapToBottomPane(bottomPane, topPane, car.getImageView());
                }
            }
        }
    }

}
