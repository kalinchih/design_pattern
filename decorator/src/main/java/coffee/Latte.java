package coffee;

public class Latte extends CoffeeIngredient {

    Latte(Coffee coffee) {
        super(coffee);
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getContent() {
        return String.format("%s + %s", coffee.getContent(), "steamed milk + foam");
    }

    public int getPrice() {
        return coffee.getPrice() + 20;
    }
}
