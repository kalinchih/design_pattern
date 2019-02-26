package coffee;

abstract class CoffeeIngredient implements Coffee {

    protected Coffee coffee;

    CoffeeIngredient(Coffee coffee) {
        this.coffee = coffee;
    }
}
