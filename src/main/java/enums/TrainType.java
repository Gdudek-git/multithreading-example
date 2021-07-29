package enums;

public enum TrainType {
    MULTIPLE_UNIT("/images/train/MultipleUnitTrain.png");

    public String imagePath;

    TrainType(String imagePath) {
        this.imagePath = imagePath;
    }
}
