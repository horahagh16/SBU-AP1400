public class Car extends Toy {

    public Car(double basePrice, ToySize size) {
        super(basePrice, size);
    }
    public double getPrice() {
        if (size == ToySize.SMALL) {
            return 2 * getBasePrice();
        } else if (size == ToySize.MEDIUM) {
            return 5 * getBasePrice() / 2;
        } else {
            return 3 * getBasePrice();
        }
    }
}
