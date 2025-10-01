package Exercise_1.Creational.Factory;

public class FoodFactory {
    public static Food getFood(String type) {
        if (type == null) return null;
        switch (type.toUpperCase()) {
            case "PIZZA": return new Pizza();
            case "BURGER": return new Burger();
            case "SANDWICH": return new SandWich();
            default: return null;
        }
    }
}
