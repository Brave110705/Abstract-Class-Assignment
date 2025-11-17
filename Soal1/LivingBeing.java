public abstract class LivingBeing {
    protected String name;

    public LivingBeing(String name) {
        this.name = name;
    }

    public abstract void breathe();
    public abstract void eat();
    public abstract void move();

    public void grow() {
        System.out.println(name + " is growing");
    }

    public String getName() {
        return name;
    }
}
