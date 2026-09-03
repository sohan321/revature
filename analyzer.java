import java.util.Scanner;

public class analyzer {
    public static void main(String[] args) {
        String word = "";
        int vowel = 0;
        int consonants = 0;
        int digit = 0;
        int spaces = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = sc.nextLine();
        word = word.toLowerCase();
        int chars = word.length();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (Character.isDigit(ch)) {
                digit += 1;
            }

            else if (ch == ' ') {
                spaces += 1;
            }

            else if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel += 1;
                }

                else {
                    consonants += 1;
                }
            }

        }

        sc.close();
        System.out.println();
        System.out.println("Characters: " + chars);
        System.out.println("Vowels: " + vowel);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digit);
        System.out.println("Spaces: " + spaces);

}
