package decorator.coffee;

public class Americano extends CoffeeIngredient {

    Americano(Coffee coffee) {
        super(coffee);
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getContent() {
        return String.format("%s + %s", coffee.getContent(), "water");
    }

    public int getPrice() {
        return coffee.getPrice() + 0;
    }
}
