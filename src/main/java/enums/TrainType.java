package enums;

public enum TrainType {
    SINGLE_UNIT("/images/train/SingleUnitTrain.png");

    public String imagePath;

    TrainType(String imagePath) {
        this.imagePath = imagePath;
    }
}
