public class operators {
    public static void main(String[] args) {
        int a = 20;
        int b = 10;
        a += 30;
        b += 30;
        a -= 10;
        b -= 10;
        a *= 200;
        b *= 200;
        a /= 2;
        b /= 2;

        System.out.println(a > b);
        System.out.println(a > b && b > 0);
    }

}
