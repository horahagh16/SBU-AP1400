class Util {
    static String repeat( int b){
        //if String repeat didnt work this code can be replaced
        return new String(new char[b]).replace("\0", " * r");
    }
}
@FunctionalInterface
interface Shape {
    public String getArea();

    public default int dimensions() {
        return 2;
    }
}

public class Main {

    public static void printer(Shape shape) {
        System.out.println(
                "area: " + shape.getArea() +
                        " in " + shape.dimensions() + " dimensions"
        );
    }

    public static void main(String[] args) {
        Shape square = () -> "r * r";
        printer(square);

        Shape rectangle = () -> "a * b";
        printer(rectangle);

        Shape triangle = () -> "0.5 * b * h";
        printer(triangle);

        Shape circle = () -> "PI" +" * r".repeat(2);
        printer(circle);

        Shape Sphere  = new Shape() {
            @Override
            public int dimensions() {
                return 3;
            }

            @Override
            public String getArea() {
                return "4 * PI" +" * r".repeat(2);
            }
        };
        printer(Sphere);
    }
}


