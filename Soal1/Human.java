public class Human extends LivingBeing {
    public Human(String name) {
        super(name);
    }

    @Override
    public void breathe() {
        System.out.println(name + " breathes using lung");
    }

    @Override
    public void eat() {
        System.out.println(name + " mangan");
    }

    @Override
    public void move() {
        System.out.println(name + " walks on two legs");
    }
}
