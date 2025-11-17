import java.util.List;

/**
 * Abstract Animal Class
 * Represents the common traits for all animals in the simulation.
 */
public abstract class Animal {
    private int age;
    private boolean isAlive;
    private Field world;
    private Position position;
    
    public Animal(Field world, Position position) {
        this.age = 0;
        this.isAlive = true;
        this.world = world;
        updatePosition(position);
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public void die() {
        isAlive = false;
        if (position != null) {
            world.clear(position);
            position = null;
            world = null;
        }
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void updatePosition(Position newPosition) {
        if (position != null) {
            world.clear(position);
        }
        position = newPosition;
        world.place(this, newPosition);
    }
    
    public Field getWorld() {
        return world;
    }

    public abstract void behave(List<Animal> newborns);
}
