package enums;

public enum CarType {
    YELLOW("/images/cars/YellowCar.png"),RED("/images/cars/RedCar.png");

    public String imagePath;

    CarType(String imagePath) {
        this.imagePath=imagePath;
    }
}
