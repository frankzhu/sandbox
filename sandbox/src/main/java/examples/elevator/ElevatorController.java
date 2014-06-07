package examples.elevator;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by fzhu on 5/26/2014.
 */
public class ElevatorController implements Runnable {

    private Set<Integer> upQueue = new TreeSet<>();
    private Set<Integer> downQueue = new TreeSet<>();
    private Elevator elevator;

    public synchronized void request(int floor, Direction direction) {
        if (direction == Direction.DOWN) {
            downQueue.add(floor);
        } else if (direction == Direction.UP) {
            upQueue.add(floor);
        }
        notifyAll();
    }

    public synchronized void move() {
        while (upQueue.isEmpty() && downQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Direction newDir;
        int newFloor;
        if (elevator.getDirection() == Direction.DOWN && !downQueue.isEmpty()) {
            newDir = Direction.DOWN;

        } else {
            
        }
    }

    @Override
    public void run() {

    }

}
