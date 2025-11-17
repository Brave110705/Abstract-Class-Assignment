public class Plant extends LivingBeing {
    public Plant(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(name + " breathes ");
    }

    @Override
    public void eat() {
        System.out.println(name + " absorbs nutrients from the soil and sunlight");
    }

    @Override
    public void move() {
        System.out.println(name + " moves passively toward light");
    }
}
