
public class YaldaDiscountStrategy implements DiscountStrategy {

    @Override
    public long priceByDiscount(Clothing clothing) {
        long price = clothing.getBasePrice();
        if (clothing instanceof Jacket) {
            price = 9 * price / 10;
        } else if (clothing instanceof Socks) {
            price = 8 * price / 10;
        } else
            price = 3 * price / 4;
        return price;
    }
}
