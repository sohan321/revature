public class calculator {
    public static void main(String[] args) {
        double num1 = 7;
        double num2 = 0;
        char operator = '/';
        String again = "y";
        while (again.equals("y")) {
            if (operator == '+') {
                System.out.printf("Result: %.1f%n", num1 + num2);
            } else if (operator == '-') {
                System.out.printf("Result: %.1f%n", num1 - num2);
            } else if (operator == '*') {
                System.out.printf("Result: %.1f%n", num1 * num2);
            } else if (operator == '/') {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.printf("Result: %.1f%n", num1 / num2);
                }
            } else {
                System.out.println("Enter valid operator");
            }
            again = "n";
            System.out.println("Thank you for using the calculator.");
        }

    }
}
