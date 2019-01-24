
package parkinglotsuggestionsystem;

import java.util.Scanner;

public class ParkingLotSuggestionSystem {

    public static void main(String[] args) {
        CarsTypeStorage carsStorage = new CarsTypeStorage();
        Parking parking = new Parking();
        
        carsStorage.addNewCar("ASD123", "petrol/diesel");
        carsStorage.addNewCar("ASD321", "electric");
        carsStorage.addNewCar("DSA123", "vans");
        
        parking.addNewFloor(-3, 1);
        parking.addNewFloor(-2, 1);
        parking.addNewFloor(-1, 1);
        parking.addNewFloor(0, 1);
        parking.addNewFloor(1, 1);
        parking.addNewFloor(2, 1);
        
        parking.setBarrierFloor(-2);
        
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.next();
            String type = carsStorage.getCarTypeByPlate(input);
            if(type == null){
                System.out.println("Car not found.");
            }else{
                String output = parking.placeCarByType(type);
                if(output == null){
                    System.out.println("No place found.");
                }else{
                    System.out.println(output);
                }
            }
        }
    }
}
