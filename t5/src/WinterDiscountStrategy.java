public class WinterDiscountStrategy implements DiscountStrategy {
    @Override
    public long priceByDiscount(Clothing clothing) {
        long price = clothing.getBasePrice();
        if (clothing.getSeason() == Season.SUMMER) {
            price = 3 * price / 4;
        } else if (clothing.getSeason() == Season.FALL) {
            price = 6 * price / 10;
        } else if (clothing.getSeason() == Season.WINTER) {
            price=price / 2;
        }
        if (clothing instanceof Jacket) {
            price=9 * price / 10;
        }
        return price;
    }
}
