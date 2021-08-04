public class SummerDiscountStrategy implements DiscountStrategy {
    @Override
    public long priceByDiscount(Clothing clothing) {
        long price = clothing.getBasePrice();
        if (clothing.getSeason() == Season.SUMMER) {
            price = price / 2;
        } else if (clothing.getSeason() == Season.SPRING) {
            price = 6 * price / 10;
        } else if (clothing.getSeason() == Season.WINTER) {
            price = 7 * price / 10;
        }
        return price;
    }
}
