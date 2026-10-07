public class test {
    public static void main(String[] args) {
        byte b = 127;
        int a = 2555;
        b = (byte) a;
        System.out.println(b);
        int day = 41;
        switch (day) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 13:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            default:
                System.out.println("test");

        }
        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
