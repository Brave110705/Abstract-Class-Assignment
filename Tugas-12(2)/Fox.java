import java.util.List;

/**
 * Fox Class
 * Represents a predator in the simulation
 */
public class Fox extends Animal {
    public Fox(Field world, Position position) {
        super(world, position);
    }
    
    @Override
    public void behave(List<Animal> newborns) {
        if (isAlive()) {
            Position target = searchForFood();
            if (target == null) {
                target = getWorld().getFreeAdjacentPosition(getPosition());
            }
            if (target != null) {
                updatePosition(target);
            } else {
                die();
            }
        }
    }
    
    private Position searchForFood() {
        for (Position pos : getWorld().getAdjacentPositions(getPosition())) {
            Object obj = getWorld().getObjectAt(pos);
            if (obj instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) obj;
                rabbit.die();
                return pos;
            }
        }
        return null;
    }
}
