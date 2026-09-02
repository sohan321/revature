import java.util.Scanner;

public class REPL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = -1;
        float money = 0;
        float balance = 0;

        while (ans != 4) {
            if (ans == 1) {
                System.out.println();
                System.out.printf("Your balance is %.2f$", balance);
            }

            else if (ans == 2) {
                System.out.println();
                System.out.println("How much do you want to deposit?");
                money = sc.nextFloat();
                while (money < 0) {
                    System.out.println();
                    System.out.println("Error enter a valid amount");
                    money = sc.nextFloat();
                }
                balance += money;
            }

            else if (ans == 3) {
                System.out.println();
                System.out.println("How much do you want to Withdraw?");
                money = sc.nextFloat();
                while (money < 0 || money > balance) {
                    System.out.println();
                    System.out.println("Error enter a valid amount");
                    System.out.println("Balance = " + balance);
                    money = sc.nextFloat();
                }
                balance -= money;

            }
            ans = -1;
            while (ans < 1 || ans > 4) {
                System.out.println();
                System.out.println();
                System.out.println("Choose one of the options below");
                System.out.println("1. Check balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.println();
                ans = sc.nextInt();
            }

        }
        sc.close();

    }
}
