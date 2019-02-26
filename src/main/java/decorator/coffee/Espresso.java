package decorator.coffee;

class Espresso implements Coffee {

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public String getContent() {
        return "espresso";
    }

    public int getPrice() {
        return 50;
    }
}
