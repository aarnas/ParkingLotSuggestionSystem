
package parkinglotsuggestionsystem;

public class Car {
    private String plateNumber;
    private String carType;

    public Car(String plateNumber, String carType) {
        this.plateNumber = plateNumber;
        this.carType = carType;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getCarType() {
        return carType;
    }    
}
