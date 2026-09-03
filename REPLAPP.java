import java.util.Scanner;

public class REPLAPP {
    public static void main(String[] args) {
        System.out.println("Welcome to my REPL App!");
        Scanner sc = new Scanner(System.in);
        String command = "";
        String word = "";
        double num1 = 0;
        double num2 = 0;

        while (!command.equals("quit")) {

            command = sc.nextLine().toLowerCase();
            if (command.equals("help")) {
                System.out.println();
                System.out.println("Available commands: ");
                System.out.println();
                System.out.println("add");
                System.out.println("subtract");
                System.out.println("multiply");
                System.out.println("divide");
                System.out.println("random");
                System.out.println("reverse");
                System.out.println("quit");
                System.out.println();
            }
            if (command.equals("add")) {
                System.out.print("First number: ");
                num1 = sc.nextInt();
                System.out.print("Second number: ");
                num2 = sc.nextInt();
                System.out.println("Result: " + (num1 + num2));
                System.out.println();
                command = sc.nextLine();

            }
            if (command.equals("subtract")) {
                System.out.print("First number: ");
                num1 = sc.nextInt();
                System.out.print("Second number: ");
                num2 = sc.nextInt();
                System.out.println("Result: " + (num1 - num2));
                System.out.println();
                command = sc.nextLine();
            }
            if (command.equals("multiply")) {
                System.out.print("First number: ");
                num1 = sc.nextInt();
                System.out.print("Second number: ");
                num2 = sc.nextInt();
                System.out.println("Result: " + (num1 * num2));
                System.out.println();
                command = sc.nextLine();
            }
            if (command.equals("divide")) {
                System.out.print("First number: ");
                num1 = sc.nextInt();
                System.out.print("Second number: ");
                num2 = sc.nextInt();
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                    System.out.println();
                } else {
                    System.out.println("Result: " + (num1 / num2));
                    System.out.println();
                    command = sc.nextLine();
                }
            }
            if (command.equals("random")) {
                System.out.print("Minimum: ");
                num1 = sc.nextInt();
                System.out.print("Maximum: ");
                num2 = sc.nextInt();
                int rand = (int) (Math.random() * (num2 + 1 - num1)) + (int) num1;
                System.out.println("Random number: " + rand);
                System.out.println();
                command = sc.nextLine();
            }
            if (command.equals("reverse")) {
                System.out.print("Enter text: ");
                word = sc.nextLine();
                String reverse = "";
                for (int i = word.length() - 1; i > -1; i--) {
                    reverse += word.charAt(i);
                }
                System.out.println(reverse);
                System.out.println();

            }

        }
        sc.close();
    }
}
