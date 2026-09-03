import java.util.Scanner;

public class password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = "";
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        boolean test4 = false;
        System.out.print("Create a password: ");
        ans = sc.nextLine();
        System.out.println();
        while (!test1 || !test2 || !test3 || !test4) {
            if (ans.length() > 7) {
                test1 = true;
            }
            for (int i = 0; i < ans.length(); i++) {
                char ch = ans.charAt(i);
                if (Character.isUpperCase(ch)) {
                    test2 = true;
                }
                if (Character.isLowerCase(ch)) {
                    test3 = true;
                }
                if (Character.isDigit(ch)) {
                    test4 = true;
                }
            }
            if (!test1 || !test2 || !test3 || !test4) {
                System.out.println("Password rejected:");
                if (!test1) {
                    System.out.println("Must have a length of at least eight");
                }
                if (!test2) {
                    System.out.println("Must contain an uppercase letter");
                }
                if (!test3) {
                    System.out.println("Must contain an lowercase letter");
                }
                if (!test4) {
                    System.out.println("Must contain a number");
                }
                System.out.println();
                System.out.print("Create a password: ");
                ans = sc.nextLine();
                System.out.println();
                test1 = false;
                test2 = false;
                test3 = false;
                test4 = false;
            }

        }
        System.out.println("Password accepted!");
        sc.close();
    }

}
