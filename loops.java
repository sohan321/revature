public class loops {
    public static void main(String[] args) {

        System.out.print("For Loop:");
        for (int i = 0; i < 5; i++) {
            System.out.print(" " + (i + 1));
        }

        System.out.println();
        System.out.print("While Loop:");
        int count = 0;
        while (count < 5) {
            System.out.print(" " + (count + 1));
            count++;
        }

        System.out.println();
        System.out.print("Do-While Loop:");
        count = 0;
        do {
            System.out.print(" " + (count + 1));
            count++;
        } while (count < 5);
    }
}
