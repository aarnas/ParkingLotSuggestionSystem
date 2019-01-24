
package parkinglotsuggestionsystem;

import java.util.ArrayList;

public class CarsTypeStorage {
    private ArrayList<Car> cars = new ArrayList();
    
    public void addNewCar(String plateNumber, String type){
        Car fresh = new Car(plateNumber, type);
        cars.add(fresh);
    }
    
    public String getCarTypeByPlate(String plateNumber){
        for(Car s:cars){
            if(plateNumber.equalsIgnoreCase(s.getPlateNumber())){
                return s.getCarType();
            }
        }
        return null;
    }
}
