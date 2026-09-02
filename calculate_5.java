import java.util.Scanner;

public class calculate_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first test score: ");
        int val1 = sc.nextInt();
        while (val1 < 0 || val1 > 100) {
            System.out.print("Enter a valid grade: ");
            val1 = sc.nextInt();
        }

        System.out.print("Enter the second test score: ");
        int val2 = sc.nextInt();
        while (val2 < 0 || val2 > 100) {
            System.out.print("Enter a valid grade: ");
            val2 = sc.nextInt();
        }

        System.out.print("Enter the third test score: ");
        int val3 = sc.nextInt();
        while (val3 < 0 || val3 > 100) {
            System.out.print("Enter a valid grade: ");
            val3 = sc.nextInt();
        }

        System.out.print("Enter the fourth test score: ");
        int val4 = sc.nextInt();
        while (val4 < 0 || val4 > 100) {
            System.out.print("Enter a valid grade: ");
            val4 = sc.nextInt();
        }

        System.out.print("Enter the fifth test score: ");
        int val5 = sc.nextInt();
        while (val5 < 0 || val5 > 100) {
            System.out.print("Enter a valid grade: ");
            val5 = sc.nextInt();
        }

        int total = val1 + val2 + val3 + val4 + val5;
        float avg = total / 5;
        int highest = -1;
        int lowest = 101;
        int[] vals = { val1, val2, val3, val4, val5 };
        char[] grades = new char[5];
        for (int i = 0; i < 5; i++) {
            if (vals[i] > highest) {
                highest = vals[i];
            }
            if (vals[i] < lowest) {
                lowest = vals[i];
            }
        }

        for (int i = 0; i < 5; i++) {
            if (vals[i] > 89) {
                grades[i] = 'A';
            }

            else if (vals[i] > 79) {
                grades[i] = 'B';
            }

            else if (vals[i] > 69) {
                grades[i] = 'C';
            }

            else if (vals[i] > 59) {
                grades[i] = 'D';
            }

            else {
                grades[i] = 'F';
            }
        }
        System.out.println();
        System.out.printf("Total: %d%n", total);
        System.out.printf("Average: %.2f%n", avg);
        System.out.printf("Highest: %d%n", highest);
        System.out.printf("Lowest: %d%n", lowest);
        System.out.println();
        System.out.println("Your values were:");
        System.out.printf("%d - %c%n", vals[0], grades[0]);
        System.out.printf("%d - %c%n", vals[1], grades[1]);
        System.out.printf("%d - %c%n", vals[2], grades[2]);
        System.out.printf("%d - %c%n", vals[3], grades[3]);
        System.out.printf("%d - %c%n", vals[4], grades[4]);

        sc.close();
    }
}
