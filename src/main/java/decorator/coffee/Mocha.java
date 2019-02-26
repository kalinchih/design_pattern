package decorator.coffee;

public class Mocha extends CoffeeIngredient {

    Mocha(Coffee coffee) {
        super(coffee);
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getContent() {
        return String.format("%s + %s", coffee.getContent(), "chocolate");
    }

    public int getPrice() {
        return coffee.getPrice() + 5;
    }
}
