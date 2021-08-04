public class Toy {
    private double basePrice;
    protected ToySize size;

    public Toy(double basePrice, ToySize size) {
        this.basePrice = basePrice;
        this.size = size;
    }
    public double getPrice() {
        if (size == ToySize.SMALL) {
            return getBasePrice();
        } else if (size == ToySize.MEDIUM) {
            return 3 * getBasePrice() / 2;
        } else {
            return 2 * getBasePrice();
        }
    }

    public double getPrice(double discount) {
        return getPrice() * (100 - discount) / 100;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
