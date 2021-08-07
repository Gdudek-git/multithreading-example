package model.railroad_tracks;



import javafx.animation.RotateTransition;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Translate;
import javafx.util.Duration;


public abstract class LevelCrossing {

    private ImageView topBarrier;
    private ImageView bottomBarrier;
    private ImageView lights;

    private RotateTransition topBarrierRotation;
    private RotateTransition bottomBarrierRotation;


    public LevelCrossing(ImageView topBarrier,ImageView bottomBarrier, ImageView lights)
    {
        this.topBarrier = topBarrier;
        this.bottomBarrier = bottomBarrier;
        this.lights=lights;

        setRotateTransitionForBarriers();

        changePivotForRotation(topBarrier,-25,topBarrier.getFitHeight()/3);
        changePivotForRotation(bottomBarrier,-25,bottomBarrier.getFitHeight()/3);

    }

    private void setRotateTransitionForBarriers()
    {
        topBarrierRotation = new RotateTransition(Duration.seconds(4),topBarrier);
        bottomBarrierRotation = new RotateTransition(Duration.seconds(4),bottomBarrier);
    }

    private void changePivotForRotation(Node node, double x, double y)
    {
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }

    protected void closeBarriers()
    {
        topBarrierRotation.setByAngle(-90);
        bottomBarrierRotation.setByAngle(-90);
        topBarrierRotation.play();
        bottomBarrierRotation.play();

    }

    protected void openBarriers()
    {
        topBarrierRotation.setByAngle(90);
        bottomBarrierRotation.setByAngle(90);
        topBarrierRotation.play();
        bottomBarrierRotation.play();
    }

    public void changeLightsToRed()
    {
        Platform.runLater(()->
                lights.setImage(new Image("/images/level_crossing/lights/RedLights.png",250,179,true,true)));
    }

    public void changeLightsToGreen()
    {
        Platform.runLater(()->
                lights.setImage(new Image("/images/level_crossing/lights/GreenLights.png",250,179,true,true)));
    }


}
