package Exercise_1.Creational.Factory;

public class Main {
    public static void main(String[] args) {

        //client doesn't know which class's object is being created , only the factory class knows it

        Food f1 = FoodFactory.getFood("Pizza");
        f1.prepare();

        Food f2 = FoodFactory.getFood("Burger");
        f2.prepare();

        Food f3 = FoodFactory.getFood("Sandwich");
        f3.prepare();
    }
}
