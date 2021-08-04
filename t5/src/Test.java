public class Test {
    public static void main(String[] args) {
        Car car = new Car(20000, ToySize.SMALL);
        /*Toy toy=new Toy(100,ToySize.MEDIUM);
        System.out.println(toy.getPrice());
        System.out.println(toy.getPrice(10));
        System.out.println(toy.getBasePrice());*/
        System.out.println(car.getPrice());
        System.out.println(car.getPrice(20));
    }
}
