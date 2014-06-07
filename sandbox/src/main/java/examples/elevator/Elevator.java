package examples.elevator;

/**
 * Created by fzhu on 5/26/2014.
 */
public class Elevator {
    private int currentFloor = 1;
    private Direction direction = Direction.UP;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
