import java.util.List;

/**
 * Rabbit Class
 * Represents prey in the simulation
 */
public class Rabbit extends Animal {
    public Rabbit(Field world, Position position) {
        super(world, position);
    }
    
    @Override
    public void behave(List<Animal> newborns) {
        if (isAlive()) {
            Position newPos = getWorld().getFreeAdjacentPosition(getPosition());
            if (newPos != null) {
                updatePosition(newPos);
            } else {
                die();
            }
        }
    }
}
