import java.util.ArrayList;
import java.util.List;

/**
 * Simulation Engine Class
 * Runs and manages the ecosystem simulation
 */
public class SimulationEngine {
    private Field world;
    private List<Animal> animals;

    private static final double FOX_CREATION_PROBABILITY = 0.08;
    private static final double RABBIT_CREATION_PROBABILITY = 0.10;

    public SimulationEngine(int height, int width) {
        world = new Field(height, width);
        animals = new ArrayList<>();
        spawnInitialAnimals();
    }

    public void runSimulation(int cycles) {
        for (int cycle = 1; cycle <= cycles; cycle++) {
            System.out.println("Cycle " + cycle + " | Foxes: " + count(Fox.class)
                    + " Rabbits: " + count(Rabbit.class));
            world.printFieldWithStats();

            List<Animal> newAnimals = new ArrayList<>();
            for (Animal animal : new ArrayList<>(animals)) {
                animal.behave(newAnimals);
                if (!animal.isAlive()) {
                    animals.remove(animal);
                }
            }
            animals.addAll(newAnimals);
        }
    }

    /**
     * Spawn initial foxes and rabbits into the simulation based on probabilities.
     * Uses separate probability checks for each animal type (independent checks).
     */
    private void spawnInitialAnimals() {
        for (int row = 0; row < world.getHeight(); row++) {
            for (int col = 0; col < world.getWidth(); col++) {
                Position pos = new Position(row, col);
                double rand = Math.random();

                if (Math.random() <= FOX_CREATION_PROBABILITY) {
                    animals.add(new Fox(world, pos));
                }
                else if (Math.random() <= RABBIT_CREATION_PROBABILITY) {
                    animals.add(new Rabbit(world, pos));
                } else {
                    world.clear(pos);
                }
            }
        }
    }

    private int count(Class<?> cls) {
        int counter = 0;
        for (Animal animal : animals) {
            if (cls.isInstance(animal)) {
                counter++;
            }
        }
        return counter;
    }
}
