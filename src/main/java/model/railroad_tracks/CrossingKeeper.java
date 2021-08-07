package model.railroad_tracks;

import javafx.scene.image.ImageView;
import model.road.LeftLane;
import model.road.RightLane;

public class CrossingKeeper extends LevelCrossing{


    public CrossingKeeper(ImageView topBarrier, ImageView bottomBarrier, ImageView lights) {
        super(topBarrier, bottomBarrier, lights);
    }

    public void trainIsComing()
    {
        Runnable r = () ->
        {
            super.changeLightsToRed();
            stopCars();
            giveDriversTimeToReact();
            super.closeBarriers();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
    }

    public void trainIsGone()
    {
        Runnable r = () ->
        {
            super.openBarriers();
            giveDriversTimeToReact();
            super.changeLightsToGreen();
            letCarsPass();
        };
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
    }

    private void giveDriversTimeToReact()
    {
        try
        {
            Thread.sleep(5000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    private void stopCars()
    {
        LeftLane.getLeftLane().getRoute().get(410).setWaypointIsOccupied();
        RightLane.getRightLane().getRoute().get(210).setWaypointIsOccupied();
    }

    private void letCarsPass()
    {
        LeftLane.getLeftLane().getRoute().get(410).setWaypointIsNotOccupied();
        RightLane.getRightLane().getRoute().get(210).setWaypointIsNotOccupied();
    }


}
