public class Main {
    public static void main(String[] args) {
        LivingBeing john = new Human("John");
        LivingBeing tiger = new Animal("Tiger");
        LivingBeing coconutTree = new Plant("Coconut Tree");
        
        System.out.println("--- Human ---");
        john.eat();
        john.move();
        john.breathe();
        john.grow();

        System.out.println("\n--- Animal ---");
        tiger.eat();
        tiger.move();
        tiger.breathe();
        tiger.grow();

        System.out.println("\n--- Plant ---");
        coconutTree.eat();
        coconutTree.breathe();
    }
}
