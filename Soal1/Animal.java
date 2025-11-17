public class Animal extends LivingBeing {
    public Animal(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(name + " breathes using lungs");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats");
    }

    @Override
    public void move() {
        System.out.println(name + " walks/swims/flies");
    }
}
