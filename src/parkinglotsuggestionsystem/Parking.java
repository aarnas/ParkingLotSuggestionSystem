package parkinglotsuggestionsystem;

import java.util.ArrayList;

public class Parking {
    private int barrierFloor;
    private ArrayList<Floor> floors = new ArrayList();

    public void setBarrierFloor(int barrierFloor) {
        this.barrierFloor = barrierFloor;
    }
    
    public void addNewFloor(int position, int placesLeft){
        Floor fresh = new Floor(position, placesLeft);
        floors.add(fresh);
    }
    
    public Floor getFloorByPosition(int position){
        for(Floor s:floors){
            if(s.getFloorPosition() == position){
                return s;
            }
        }
        return null;
    }
    
    public int getLowestFloor(){
        int lowest = getFloorByPosition(barrierFloor).getFloorPosition();
        for(Floor s:floors){
            if(s.getFloorPosition() < lowest){
                lowest = s.getFloorPosition();
            }
        }
        return lowest;
    }
    
    public int getHighestFloor(){
        int highest = getFloorByPosition(barrierFloor).getFloorPosition();
        for(Floor s:floors){
            if(s.getFloorPosition() > highest){
                highest = s.getFloorPosition();
            }
        }
        return highest;
    }
    
    public boolean checkForPlaceByFloor(int position){
        Floor f = getFloorByPosition(position);
        if(f.getPlacesLeft() > 0){
            int decrease = f.getPlacesLeft() - 1;
            f.setPlacesLeft(decrease);
            return true;
        }else{
            return false;
        } 
    }
    
    public String placeCarByType(String type){
        String output = null;
        int up = barrierFloor;
        int down = barrierFloor;
        switch (type){
            case "petrol/diesel":
                while(up <= getHighestFloor() || down >= getLowestFloor()){
                    try{
                        if(checkForPlaceByFloor(up)){
                            output = up+"";
                            break;
                        }else{
                            up++;
                        }
                    }catch(Exception e){
                    }
                     try{
                        if(checkForPlaceByFloor(down)){
                            output = down+"";
                            break;
                        }else{
                            down--;
                        }
                    }catch(Exception e){
                    }
                }
            break;
            
            case "electric":
                try{
                    if(up==getHighestFloor()){
                        if(checkForPlaceByFloor(getHighestFloor())){
                            output = getHighestFloor()+"";
                        }else if(checkForPlaceByFloor(getHighestFloor()-1)){
                            output = getHighestFloor()-1+"";
                        }
                    }else{
                        if(checkForPlaceByFloor(getHighestFloor()-1)){
                            output = getHighestFloor()-1+"";    
                        }else if(checkForPlaceByFloor(getHighestFloor())){
                            output = getHighestFloor()+"";
                        }
                    }
                }catch(Exception e){
                }
            break;
            
            case "vans":
                try{
                    if(down==getLowestFloor()){
                        if(checkForPlaceByFloor(getLowestFloor())){
                            output = getLowestFloor()+"";
                        }else if(checkForPlaceByFloor(getLowestFloor()+1)){
                            output = getLowestFloor()+1+"";
                        }
                    }else{
                        if(checkForPlaceByFloor(getLowestFloor()+1)){
                            output = getLowestFloor()+1+"";    
                        }else if(checkForPlaceByFloor(getLowestFloor())){
                            output = getLowestFloor()+"";
                        }
                    }
                }catch(Exception e){
                }
            break;
            
            default:
                output = "Vehicle type unknown.";
            break;
        }
        return output;
    }
}
