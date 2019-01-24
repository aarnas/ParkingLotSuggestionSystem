
package parkinglotsuggestionsystem;

public class Floor {
    private int floorPosition;
    private int placesLeft;

    public Floor(int floorPosition, int placesLeft) {
        this.floorPosition = floorPosition;
        this.placesLeft = placesLeft;
    }

    public int getFloorPosition() {
        return floorPosition;
    }

    public int getPlacesLeft() {
        return placesLeft;
    }

    public void setPlacesLeft(int placesLeft) {
        this.placesLeft = placesLeft;
    }
}
